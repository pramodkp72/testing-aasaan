pipeline {
    agent any
    environment {
        GITHUB_TOKEN = credentials('github-pramodkp72-classic-token')
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/pramodkp72/testing-aasaan', credentialsId: 'github-pramodkp72-classic-token'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}