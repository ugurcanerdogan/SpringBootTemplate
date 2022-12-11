# Spring Boot Project Template

<img src="https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/img/1.png" width="720"/>

<img src="https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/img/2.png" width="720"/>


## Build Status
_**WARNING!**
GitHub Actions will fail for this draft repo. Because the project could not be deployed. The reason is that there is no valid DB connection in the [application.yml](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/src/main/resources/application.yaml)._

`Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
`

[![CodeQL](https://github.com/ugurcanerdogan/SpringBootTemplate/actions/workflows/codeql.yml/badge.svg)](https://github.com/ugurcanerdogan/SpringBootTemplate/actions/workflows/codeql.yml)

[![Java CI with Maven](https://github.com/ugurcanerdogan/SpringBootTemplate/actions/workflows/maven.yml/badge.svg)](https://github.com/ugurcanerdogan/SpringBootTemplate/actions/workflows/maven.yml)

### Motivation
It is a draft structure prepared for Spring Boot projects. Check the [readme](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/README.md) for details.

## Solution

<hr>

### Tech / Framework used

- [Java 17](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/pom.xml#L17)

`The application runs on Java 17. Dockerfile and GitHub Actions configurations are also set this way.`
- [Spring Boot 3.0](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/pom.xml#L8)

`It uses 3.0 which is one of the current Spring Boot versions. The User and Role model classes and the Repo - Service - Controller layers based on them are readily available.`
- [JWT](https://github.com/ugurcanerdogan/SpringBootTemplate/tree/master/src/main/java/com/uqi/template/security)

`In the project where the JWT infrastructure is ready, "api/v1/auth/**" paths are determined as permitAll(). Bearer token must be entered for other controller requests.`
- [MySQL Connector](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/src/main/resources/application.yaml#L5)

`The application.yml file of the project has been made ready for MySQL connection.`
- [Dependabot & CodeQL & Dependabot (GitHub Actions)](https://github.com/ugurcanerdogan/SpringBootTemplate/tree/master/.github)

`If the project is pushed to any GitHub repository, GitHub Actions workflows are automatically deployed.`
- [Dockerfile](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/Dockerfile)

`If the project is desired to be converted into an Docker image, the Dockerfile is also available for this.`

### Other Utilities

- [Global Exception Handling](https://github.com/ugurcanerdogan/SpringBootTemplate/tree/master/src/main/java/com/uqi/template/exception)

`You can diversify the exception handlers that are already placed in the User and Role CRUDs according to your needs.`
- [EmailValidator](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/src/main/java/com/uqi/template/config/EmailValidator.java)

`Email validator is available for User registrations.`
- [BCryptConfiguration](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/src/main/java/com/uqi/template/config/BCryptConfiguration.java)

`User passwords are hashed before being saved to the database.`
- [application.yml & banner.txt](https://github.com/ugurcanerdogan/SpringBootTemplate/tree/master/src/main/resources)

`application.yml is organized to facilitate DB connections. With the help of the website in banner.txt under the /src/main/resources/ folder, you can change the banner that will appear when Spring Boot is run.`
- [Code Formatter & Import Sorter PLUGINS](https://github.com/ugurcanerdogan/SpringBootTemplate/blob/master/pom.xml#L86)

`From the Maven plugins, you can run Code Formatter & Import Sorter plugins.`


<hr>

## Installation

### How to use it?
#### GitHub
Steps

1. Clone the repo https://github.com/ugurcanerdogan/SpringBootTemplate
2. Change project name and all the import statements
3. Add your own project needs (models, controllers, business logics etc.)
3. Run it and voilà app up and running !

### References

- https://github.com/teddysmithdev/pokemon-review-springboot

<hr>

### License

+ [MIT](https://choosealicense.com/licenses/mit/)