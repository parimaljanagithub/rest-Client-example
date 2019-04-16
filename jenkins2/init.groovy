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

//**********
def dis = new hudson.model.JDK.DescriptorImpl();
dis.setInstallations( new hudson.model.JDK("JDK8", "/usr/lib/jvm/java-1.8-openjdk"));

def desc = instance.getDescriptor("hudson.tasks.Maven")
def minst =  new hudson.tasks.Maven.MavenInstallation("Maven", "/usr/lib/mvn");
desc.setInstallations(minst)
desc.save()
