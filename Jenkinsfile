node {

	def jarMap = ["cars":"8090", "clients":"8091", "locations":"8092"]

    stage('Checkout code') {
        checkout scm
    }

    stage("Build") {
        sh "mvn clean package"
    }

    stage("Docker build") {
    	jarMap.each { jarName, port ->
        	sh "docker build -t ${jarName} --build-arg jarName=${jarName} --build-arg port=${port} ."
        }
    }

    stage("Docker run") {
        sh "docker images"
        jarMap.each { jarName, port ->
        	sh "docker run -p ${port}:${port} -d ${jarName}"
        }
    }

    stage("Clean WS") {
        cleanWs()
    }
}