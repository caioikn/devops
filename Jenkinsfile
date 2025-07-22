pipeline {
	// Define que a pipeline pode ser executado em qualquer agente
	agent any
	
	tools {
		jdk 'JAVA_HOME'
		maven 'MAVEN_HOME'
	}
	
	parameters {
		string(name: 'TAGS', defaultValue: '@login', description: 'Tags Cucumber a executar')
	}
	
	environment {
		MAVEN_OPTS = "-Dcucumber.filter.tags=${params.TAGS}" // MAVEN_OPTS -> Variável do Jenkins
	}
	
	stage('Checkout') {
		steps {
			git url: '', branch: 'main'
		}
	}
	
	stage('Executar testes') {
		steps {
			"mvn clean test -Dtest=runner.RunCucumberTest -Dcucumber.filter.tags=${params.TAGS}"
		}
	}
	
	stage('Public Relatório HTML') {
		steps {
			publishHTML(target: [
				reportDir: 'target',
				reportFiles: 'Cucumber-report.html',
				reportName: 'Cucumber Report'
			])
		}
	}
	
	post {
		always {
			script {
				try {
					archiveArtifacts artifacts: 'target/evidencias/**/*.png', fingerprint: true
				} catch(err) {
					echo "Nenhuma evidência encontrada para arquivar."
				}
			}
		}
	}
}
