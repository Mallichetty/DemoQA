pipeline 
{
    agent any

    stages {
        stage('Build') 
	     {
            steps 
		{
                mvn compile
            	}
             }
          }
    stages {
        stage('Test') 
	     {
            steps 
		{
                bat 'mvn test'
            	}
             }
          }
   stages {
        stage('Deploy') 
	     {
            steps 
		{
                echo 'Deploying it to Pre-prod for UAT'
            	}
             }
          }
   stages {
        stage('Production') 
	     {
            steps 
		{
                echo 'Code is in live Environment'
            	}
             }
          }
}