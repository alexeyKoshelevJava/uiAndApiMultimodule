pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {

        stage('build'){
            steps {
                sh 'clean api:assemble'
                }
        }
        stage('test') {
            steps {
                sh 'clean api:test'
            }
        }
    }
}