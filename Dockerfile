FROM java:8-jdk

ARG jarName
ARG port
ARG version

ENV jarName=${jarName}
ENV port=${port}
ENV version=${version}

ADD ${jarName}/target/${jarName}-${version}-SNAPSHOT-exec.jar ${jarName}.${version}.jar

EXPOSE ${port}

CMD /bin/bash -c 'java -jar ${jarName}.${version}.jar'