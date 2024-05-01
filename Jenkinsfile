node {
  def image
  //1//  
  stage ('checkout') {
    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '', url: 'https://github.com/RajaSekhar516/java-app.git']]])      
  }
   
  //2//   
  stage ('Build') {
    def mvnHome = tool name: 'maven', type: 'maven'
    def mvnCMD = "${mvnHome}/bin/mvn "
    sh "${mvnCMD} clean package"           
  }
       
  //3// 
  stage ('Docker Build') {
    docker.build('springboot')
  }

  //4// 
  stage ('Docker push') {
    docker.withRegistry('https://590183962564.dkr.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:aws-cred') {
      docker.image('springboot').push('latest')
    }
  }
  
  //5// 
  stage ('K8S Deploy') {
    sh 'kubectl apply -f spring-boot.yaml'
  } 
}
