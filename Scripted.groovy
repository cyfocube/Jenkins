// # scripted pipelines
node {
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
// Or 
    stage('Build'){
        echo 'this is build stage'
    }
    
    stage ('Testing'){
        echo 'this is testing stage'
    }
    
    stage ('Deploy'){
        echo 'this is deploying stage'
    }
    
    stage ('Release'){
        echo 'this is release stage'
    }
    

}