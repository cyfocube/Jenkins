
pipeline {
    agent {
        label 'master'
    }
    
    stages {
        stage('Building') {
            steps {
                script {
                    pwd()
                    sh 'ls'
                }
            }
        }
        
        stage('Testing') {
            steps {
                echo 'testing pipeline'
            }
        }
    }
}

