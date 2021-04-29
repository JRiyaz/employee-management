pipeline {
    agent any
    stages {
        stage('git repo clone') {
            steps {
                git branch: 'main', url: 'https://github.com/JRiyaz/employee-management.git'
            }
        }
        stage('clean') {
            steps {
                sh "mvn clean"
            }
        }
        stage('package') {
            steps {
                sh "mvn package"
            }
        }
        stage('docker build') {
            steps {
                sh "docker build -t employee-management ."
            }
        }
        stage('docker run') {
             steps {
                 sh "docker run -d -p 5555:8080 employee-management"
             }
        }
    }
}