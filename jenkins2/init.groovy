//Credentials
//TODO inform your credentials here, changing user and password
Credentials c = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,"janaparimal.jana@gmail.com", "India@2019", System.getenv()['USER_NAME'], System.getenv()['USER_PWD'])
SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), c)

