node {

	def jarMap = ["cars":"8090", "clients":"8091", "locations":"8092", "api-gateway":"9090", "discovery-server":"9091"]

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
        sh "docker images"
    }

    stage("Stop running images") {
        sh "docker-compose down"
    }

    stage("Run images") {
        sh "docker-compose up -d"
    }

    stage("Clean WS") {
        cleanWs()
    }
}