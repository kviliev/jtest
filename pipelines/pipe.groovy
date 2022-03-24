[
     [region: 'UK'],

].each { Map params ->
   [ 
       [environment: 'dev', branch: 'master', project: 'dev-app-project'],
       [environment: 'qa', branch: 'master', project: 'qa-app-project'],  
   ].each { Map paramsEnv ->
       pipelineJob("${params.region}/${paramsEnv.environment}/${paramsEnv.project}/app-demo") {
            parameters {
            choice(
                     name: 'ENV',
                     choices: ['dev', 'test']
              )
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
