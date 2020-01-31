FROM tomcat
MAINTAINER Pawan Kumar

#COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
ADD ./target/*.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
