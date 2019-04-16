String getDate() { return new Date().format('yyyyMMdd') }

String getPomVersion() {
    return readMavenPom(file: '../pom.xml').project.version
}

String increaseVersion(String version) {
    version.toInteger() + 1 
    println(version)
    return version
}


