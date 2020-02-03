pipeline {
  agent any
  tools { 
        maven 'Maven'
        jdk "jdk8"		
    }
  stages{
    stage ('Clone Sources') {
        steps {
                git branch: 'master', url: 'https://github.com/pawanitzone/ProjectMaven.git'
            }
        }
		
    stage ('Exec Maven') {
       steps {
         sh 'mvn -B -DskipTests clean package'
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

