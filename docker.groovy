pipeline {
    agent {label 'master'}

    stages {
        stage ('Clonethe workspace'){
            steps{
            CleanWs()
            }

        }

        stage('Clone the source code'){
            steps{
                echo 'In SCM stage'
                 git credentialId: 	'7a274961-ac5e-4b91-8336-62ccb8bf06b0', url:'https://github.com/cyfocube/Jenkins.git', branch:'main'
            }
        }




    }
}