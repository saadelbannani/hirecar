FROM java:8-jdk

ARG jarName
ARG port

ENV jarName=${jarName}
ENV port=${port}

ADD ${jarName}/target/${jarName}-1.0-SNAPSHOT-exec.jar hirecar/${jarName}.jar

EXPOSE ${port}

CMD /bin/bash -c 'java -jar hirecar/${jarName}.jar'