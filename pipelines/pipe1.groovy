[
     [region: 'UK'],

].each { Map params ->
   [
       [environment: 'qa', branch: 'master', project: 'qa-app-project'],  
   ].each { Map paramsEnv ->
       pipelineJob("${params.region}/${paramsEnv.environment}/${paramsEnv.project}/app-demo2") {
            parameters{
               stringParam("Environment", "qa")
            }
    
    def repo = 'https://github.com/jenkinsci/pipeline-examples'       
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                           url(repo)
                           //github('jenkinsci/pipeline-examples')
                        }
                        branches("${paramsEnv.branch}")
                        scriptPath('declarative-examples/simple-examples/environmentInStage.groovy')
                        extensions {}
                     }
                  }
                }
            }
        }
    }
}
