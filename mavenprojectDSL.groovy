job('First-Maven-DSL-Job') {
    description("First Maven job generated by the DSL on ${new Date()}")
    scm {
        github('https://github.com/mackey720/web-rest-api.git', 'master')
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven('clean package', 'pom.xml')
    }
    publishers {
        archiveArtifacts('**/*.jar')
    }
}