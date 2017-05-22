
$CATALINA_HOME/bin/shutdown.sh

mvn clean install -DskipTests;
rm -r /home/hsenid/Softwares/tomcat/apache-tomcat-8.0.32/work/Catalina/localhost/hsenid
cp /home/hsenid/Documents/MAVEN/devspace_app/modules/hsenid/target/hsenid.war /home/hsenid/Softwares/tomcat/apache-tomcat-8.0.32/webapps
$CATALINA_HOME/bin/startup.sh



