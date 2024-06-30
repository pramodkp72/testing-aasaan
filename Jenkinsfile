pipeline {
    agent any
    environment {
        GITHUB_TOKEN = credentials('github-pramodkp72-classic-token')
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    git url: 'https://github.com/pramodkp72/testing-aasaan.git', credentialsId: 'github-pramodkp72-classic-token'
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    sh './gradlew clean build'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh './gradlew test'
                }
            }
        }
    }
}