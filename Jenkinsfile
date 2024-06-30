pipeline {
    agent any
    environment {
        GITHUB_TOKEN = credentials('github-pramodkp72-classic-token')
        CHROME_DRIVER_PATH = "${env.WORKSPACE}/chromedriver"
    }
    stages {
        stage('Setup') {
            steps {
                script {
                    // Download and install ChromeDriver using curl
                    sh 'curl -O https://chromedriver.storage.googleapis.com/$(curl -s https://chromedriver.storage.googleapis.com/LATEST_RELEASE)/chromedriver_linux64.zip'
                    sh 'unzip chromedriver_linux64.zip'
                    sh 'chmod +x chromedriver'
                    sh "mv chromedriver ${CHROME_DRIVER_PATH}"
                }
            }
        }
        stage('Checkout') {
            steps {
                git url: 'https://github.com/pramodkp72/testing-aasaan.git', credentialsId: 'github-pramodkp72-classic-token'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                sh "export PATH=$PATH:${CHROME_DRIVER_PATH} && ./gradlew test"
            }
        }
    }
}
