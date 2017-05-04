# Spring-Secured-Translater
      An application with the login functionality and access is granted based on the users'  role. Admin role is directed to Admin page after login and a normal user is directed to Home page after login. Both can access the Translater page which uses the Yandex API.

#### Prerequisities

- Maven 3.3.3
- Tomcat 8.0.9
- Yandex API Key
- JSTL tag library
- Spring Framework 4.3.8.RELEASE
- Spring Security 4.2.2.RELEASE


#### How to configure a Maven WebApp Project
- make a directory for Maven projects
- `cd /path to the directory/` in the terminal
- then execute `mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app`
  `DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false`                 
- move to the created directory `my-app`
- Then build the project as `mvn package`
- newly compiles and packaged jar file is seen


#### How to deploy in Tomcat
- move to the tomcat installation directory. It contains a `webapp` directory
- copy and paste the `war` file created from buliding the maven project
- start tomcat by running `./startup.sh` file in the bin directory 

#### How to access the application
- In the browser type`https://localhost:8443/hsenid`

