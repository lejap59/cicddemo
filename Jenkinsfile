pipeline {
    agent any 
    
    environment {
        mavenhome = tool 'jenkins-maven'
    }

    tools {
        jdk 'jenkins-jdk'
    }

    stages {
        stage('Build') {
            steps {
                sh "mvn clean -DskipTests install"
            }
        }
        
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }    
        
        stage('Deploy') {
            steps {
                sh "mvn jar:jar deploy:deploy"
            }
        }
    }
}
