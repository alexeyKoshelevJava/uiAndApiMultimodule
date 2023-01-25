pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage("checkout") {
             branch: 'master'
             url: 'https://github.com/alexeyKoshelevJava/uiAndApiMultimodule.git'
        }
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