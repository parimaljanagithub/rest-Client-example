String getDate() { return new Date().format('yyyyMMdd') }

String getPomVersion() {
    return readMavenPom(file: '../pom.xml').project.version
}


