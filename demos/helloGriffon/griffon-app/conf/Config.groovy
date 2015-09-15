application {
    title = 'helloGriffon'
    startupGroups = ['helloGriffon']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "helloGriffon"
    'helloGriffon' {
        model      = 'com.tz.HelloGriffonModel'
        view       = 'com.tz.HelloGriffonView'
        controller = 'com.tz.HelloGriffonController'
    }
}