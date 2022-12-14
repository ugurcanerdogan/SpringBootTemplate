package com.uqi.template.service;

import com.uqi.template.config.EmailValidator;
import com.uqi.template.dto.UserDTO;
import com.uqi.template.exception.UserNotFoundException;
import com.uqi.template.model.User;
import com.uqi.template.repository.RoleRepository;
import com.uqi.template.repository.UserRepository;
import com.uqi.template.security.JWTGenerator;
import com.uqi.template.security.JWTRequestModel;
import com.uqi.template.security.JWTResponseModel;
import com.uqi.template.security.UserDetailsAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;

	private final RoleRepository roleRepository;

	private final PasswordEncoder passwordEncoder;

	private final EmailValidator emailValidator;

	private final AuthenticationManager authenticationManager;

	private final JWTGenerator jwtGenerator;

	public User registerHelper(String username, String password) {

		String encodedPsw = passwordEncoder.encode(password);
		User user = new User();
		user.setUsername(username);
		user.setPassword(encodedPsw);
		var userRoleOpt = roleRepository.findByName("ROLE_USER");
		userRoleOpt.ifPresent((userRole) -> user.setRoles(Set.of(userRoleOpt.get())));
		return userRepository.save(user);
	}

	@Transactional
	public User register(UserDTO request) {

		boolean isValidEmail = emailValidator.test(request.getUsername());
		if (!isValidEmail) {
			throw new IllegalArgumentException("Not a valid email");
		}
		if (!userRepository.existsByUsername(request.getUsername())) {
			return registerHelper(request.getUsername(), request.getPassword());
		}
		throw new IllegalArgumentException("Email already taken");
	}

	public JWTResponseModel createToken(JWTRequestModel request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		}
		catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		final User user = userRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new UserNotFoundException("User could not be found"));
		final UserDetailsAdapter userDetails = new UserDetailsAdapter(user);
		final String jwtToken = jwtGenerator.generateJwtToken(userDetails);

		return new JWTResponseModel(jwtToken, userDetails.user().getId(), !userDetails.isEnabled(),
				userDetails.user().getUsername());
	}

}
