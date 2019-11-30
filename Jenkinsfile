node {

	def jarMap = ["cars":"8090", "clients":"8091", "locations":"8092"]

    stage('Checkout code') {
        checkout scm
    }

    stage("Build project") {
        sh "mvn clean package"
    }

    stage("Build images") {
    	jarMap.each { jarName, port ->
        	sh "docker build -t ${jarName} --build-arg jarName=${jarName} --build-arg port=${port} ."
        }
    }

    stage("Run images") {
        sh "docker images"

        sh "docker-compose down"
        sh "docker-compose up"
    }

    stage("Clean WS") {
        cleanWs()
    }
}