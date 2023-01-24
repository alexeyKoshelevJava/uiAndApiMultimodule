node {
    stage("checkout repo"){
        git branch: 'master'
        url: 'https://github.com/alexeyKoshelevJava/uiAndApiMultimodule.git'
    }
    stage("build"){
       sh "./gradle clean api:assemble"
}
    stage("run api test"){
       sh "./gradle clean api:test"}
}