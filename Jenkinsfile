pipeline{

   agent any


   stages{
   stage("Build the mvn project"){
   steps{
   sh 'mvn clean package -DskipTests'
   }


   }

   stage("Build Docker Image"){

   steps{
    sh 'docker build -t=jaifee/selautomation .'
    sh 'docker push jaifee/selautomation'
   }

   }



   }
   post{
    always{
    echo "closing a file"
    }

   }



}