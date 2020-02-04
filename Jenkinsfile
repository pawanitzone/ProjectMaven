pipeline {
  agent any
  environment { 
        PATH = "/var/jenkins_home/maven/bin:$PATH"     
        
    }
	
  stages {
    stage ('Clone Sources') {
        steps {
                git branch: 'master', url: 'https://github.com/pawanitzone/ProjectMaven'
            }
        }
		
    stage ('Exec Maven') {
       steps {
         sh "mvn -B -DskipTests clean package"
        }
    }
    
    
 }
}

