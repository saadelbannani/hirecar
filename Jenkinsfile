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
        echo "Kill running images and start new images."

        jarMap.each { jarName, port ->
            def imageUp = sh(script: "docker inspect -f '{{.State.Running}}' ${jarName}", returnStdout: true)
            if ($imageUp == "true") {
                sh "docker stop ${jarName}"
                sh "docker rm ${jarName}"
            }
        }

        sh "docker images"
        jarMap.each { jarName, port ->
        	sh "docker run -p ${port}:${port} -d ${jarName}"
        }
    }

    stage("Clean WS") {
        cleanWs()
    }
}