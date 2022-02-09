package br.ufes.inf.dishfy.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@CustomFormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(
    loginPage = "/login/login.xhtml", 
    useForwardToLogin = false, 
    errorPage = ""))
@DatabaseIdentityStoreDefinition(
  dataSourceLookup = "java:app/datasources/dishfy",
  callerQuery = "select senha from Usuario where email = ?",
  groupsQuery = "SELECT 'DefaultRole' as Role FROM Usuario where email = ?"
)
@FacesConfig
@ApplicationScoped
public class AppConfig {
    
}
