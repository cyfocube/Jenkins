// # Decplative --Mostly used in production
// Continues where it crashed

pipelines {
    agent any
 
    stages {
    stage ('Build_stage'){
        echo 'this is my build stage'
    }
    stage ('Test_stage'){
    echo 'This is my testing stage'
    }

    stage ('clone code from repo'){
        echo 'Clone the code from github'
    }

    stage('deploy'){
        echo 'Deploy in PROD'
    }


}

}