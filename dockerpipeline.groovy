pipeline {
    agent {
        label 'master'
    }

    stages {
        stage ('Clone the workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Clone the source code') {
            steps {
                echo 'In SCM stage'
                git credentialsId: 'Git-Credentials', url: 'https://github.com/cyfocube/Jenkins.git', branch: 'main'
            }
        }

        stage('Validating the cloned contents') {
            steps {
                sh '''
                ls
                pwd
                '''
            }
        }
    }
}
