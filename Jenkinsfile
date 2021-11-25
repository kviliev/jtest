pipelineJob('github-demo1') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github('kviliev/jtest1')
                    }
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}
