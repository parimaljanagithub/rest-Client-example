#!groovy
import hudson.security.*
import jenkins.model.*
import hudson.model.*
import hudson.security.csrf.DefaultCrumbIssuer
import org.jenkinsci.plugins.scriptsecurity.scripts.*
import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;


def instance = Jenkins.getInstance()

instance.setNumExecutors(5)

instance.setCrumbIssuer(new DefaultCrumbIssuer(true))

def hudsonRealm = new HudsonPrivateSecurityRealm(false)

//Credentials
//TODO inform your credentials here, changing user and password
Credentials c = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,"git_openapiv2", "openapiv2","janaparimal.jana@gmail.com","India@2019")
SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), c)

