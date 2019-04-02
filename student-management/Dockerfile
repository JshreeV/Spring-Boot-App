# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
From tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/student-management-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]

#$ docker image build -t student-management .
#$ docker container run -p 8080:8080 -d student-management
#$ docker container exec -it {container-id} /bin/sh
#/usr/local/tomcat # cd webapps/
#/usr/local/tomcat/webapps # ls
#ROOT      ROOT.war