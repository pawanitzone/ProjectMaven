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
         sh 'mvn clean install'
        }
    }
    
   
  }
}

