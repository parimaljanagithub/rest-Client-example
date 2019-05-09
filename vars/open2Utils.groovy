String getDate() { 
    println('heloo inside open2utils')
    return new Date().format('yyyyMMdd')
}

String getPomVersion() {
    return readMavenPom(file: '../pom.xml').project.version
}

String increaseVersion(String version) {
    version = version.toInteger() + 1 
    println(version)
    return version
}


Boolean userInputWithComment(String title) {
    try {
        def userInput = input(message: title, parameters: [
                choice(name: 'Select', choices: 'Yes\nNo', description: 'Confirm to promote the deployment to PROD?'),
                text(name: 'Comment', defaultValue: '', description: 'Please do a comment if necessary here')])
        echo("Comment: ${userInput.Comment}")
        return userInput.Select == 'Yes'
    } catch (err) { // input false
        def user = err.getCauses()[0].getUser()
        echo("Aborted by: [${user}]")
        return false
    }
}

