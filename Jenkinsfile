pipeline {
    agent any 
    
    environment {
        mavenhome = tool 'jenkins-mvn'
        imageName = "cicddemo"
        registryCredentials = "nexus"
        registry = "localhost:8080/"
        dockerImage = ""
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
        
        stage('Build image') {
            steps {
                script {
                    dockerImage = docker.build imageName
                }
            }
        }    
        
        stage('Deploy') {
            steps {
                script {
                    docker.withRegistry("http://" + registry, registryCredentials) {
                        dockerImage.push('latest')
                    }
                }
            }
        }
    }
}
