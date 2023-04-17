pipeline {
  agent { label 'linux' }
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

  stages {
    stage('scan') {
      steps {
      withSonarQubeEnv(installationName:'sonarq'){
        sh './mvnw clean org.sonar.maven:sonar-maven-plugin:3.9.0.2155:sonar'
}
      }
    }
  }
}