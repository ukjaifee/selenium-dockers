pipeline{

    agent any

    stages{

         stage("Build an Code"){
            steps{
        sh "mvn clean package -DskipTests"
        }
        }

        stage("Build an Image"){
            steps{
         sh "docker build -t=jaifee/selautomation ."
        }
        }

        stage("Push an Image"){
            steps{
                sh "docker push jaifee/selautomation"
            }

        }


    }




}