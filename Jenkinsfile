pipeline {
    agent any
    stages {
        stage('git repo clone') {
            steps {
//                 bat "rmdir  /s /q employee-management"
                bat "git clone https://github.com/JRiyaz/employee-management.git"
            }
        }
        stage('clean') {
            steps {
                bat "mvn clean -f employee-management"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -P test -f employee-management"
            }
        }
        stage('package') {
            steps {
//             The 'prod' profile is configured in application.properties
                bat "mvn package -f employee-management"
            }
        }
    }
}