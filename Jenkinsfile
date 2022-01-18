node {
     def giturl= "https://ShreeTalla@bitbucket.org/ShreeTalla/gateway.git"
    stage("Workspace clear"){
        cleanWs()
    }
    stage("code checkout"){ 
    checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
 doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], 
 userRemoteConfigs: [[url: giturl]]])
    }
	stage('Clean Stage') {
        bat "mvn clean"
    }
	stage('Compile Stage') {
        bat "mvn compile"
    }
    stage('Test Stage') {
        bat "mvn test"
    }
    stage('Build Artifact Stage') {
        bat "mvn install -DskipTests"
    }
}