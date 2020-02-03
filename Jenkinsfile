pipeline {
  agent any
  tools { 
        maven 'Maven'	
	jdk  'jdk8'
    }
	
  stages {
    stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
	stage ('Clone Sources') {
        steps {
                git url: 'https://github.com/pawanitzone/ProjectMaven'
            }
        }
		
	stage ('Build') {
        steps {
          sh "mvn clean verify" 
         }			
	}
    
    stage('Docker Build') {
      steps {
        sh "docker build -t pawanitzone/hello:${env.BUILD_NUMBER} ."
      }
    }
    stage('Docker Push') {
      steps {
	  withCredentials([usernamePassword(credentialsId: 'dockerHubUser', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh "docker push pawanitzone/hello:${env.BUILD_NUMBER}"
        }
      }
	 }

    stage('Docker Remove Image') {
      steps {
        sh "docker rmi pawanitzone/hello:${env.BUILD_NUMBER}"
      }
    }
        stage('Docker run container') {
      steps {
        sh "sudo docker run -d --name hello-${env.BUILD_NUMBER} -p 8888:8080 pawanitzone/hello:${env.BUILD_NUMBER}"
		
      }
    }
 }
}
