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
        stage('Test') 
	     {
            steps 
		{
                bat 'mvn test'
            	}
             }
        stage('Deploy') 
	     {
            steps 
		{
                echo 'Deploying it to Pre-prod for UAT'
            	}
             }
        stage('Production') 
	     {
            steps 
		{
                echo 'Code is in live Environment'
            	}
             }
          }
}