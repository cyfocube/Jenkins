pipeline {
	agent {label 'master'} 
		
		stages {
			stage('Cleanws') {
				steps {
					 cleanWs()
					}
			}
			
			stage('Git Clone') {
				steps {
					
					sshagent(['fake-pai']) {
						 
                 	 sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo apt-get install git -y'
                         sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo rm -rf Jenkins'
						 sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo git clone https://github.com/cyfocube/Jenkins.git'
						 
					}		  
				}
			}
		
	stage('Verify the Clone') {
				steps {
					
					sshagent(['fake-pai']) {
						 
						 
						 sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo pwd'
						 sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo ls'
						 sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo cat Jenkins/Dockerfile'
						 
						 
					}		  
				}
			}
	stage('Build the Docker Image') {
				steps {
					
					sshagent(['fake-pai']) {
						 
						  sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo apt-get update -y'
						sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo apt-get install docker -y'
						 sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo snap install docker'
						 sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo docker build -t cyfodocker /home/ubuntu/Jenkins/'
					
						 
						 
					}		  
				}
			}
			
			stage('Docker images') {
				steps {
					
					sshagent(['fake-pai']) {
						 
						 sh 'ssh -o StrictHostKeyChecking=no ${hostname} sudo docker images'
						
						 
					}		  
				}
			}
			
		}
}		