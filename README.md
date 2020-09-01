# oauth2-spring-demo

OAuth-2 is a delegation protocol, just like delegating a car parking to a hotel assistant. 

OAuth-2 is about authorization alone,  just like a master key and a valet key. It authorizes the assistnt a limited permission to start the car so as to park it for its owner. 

OAuth is mainly for authorization between services, especially between microservices.  It is called Client Credentials Flow(one of three OAuth flow), when the client is well trusted (confidential clients).  

Ther code here illustrates the flow 3. microservice(guest-app), asking for guests from another microservice(guests-service), which is protected by a Auth-server. 
(1) guest-app asking auth-server for an access-token by client-id and secret. (2) auth-server validtes and then sends back a token.
(3) guest-app using the token to invoke the guest-service and retreiving guests. 

Demo Spring Security OAuth 2 

It needs to understand terms first and then knowing parties involved in the OAuth-2; then may reduce confusions. 

*Terms*
* Resource owner: for instance: an owner who owns a google dirver, where he may store a lot of photoes, and owner's profile data
* Resource sever: fx: a Google driver, it hosts the protected data for the owner. it is responsible for making sure the accessing photoes that must be authenticated and authorized.  
* Client(thrid party): on the behalf of resource owner to access photoes stored in the Google drive, so as to print them out. 
* Authorization Server: the server issuing access token to the client. 

*Token types*

* Access token: the secret and often a short-lived token that uniquely identifies a user
* Referesh token: it is a longer-lived token used to refresh access token; for instance, an access token lasts one day; but an refresh token may last a week; after one week, you have to apply for a new access token.
* Scope: associated with the access token, providing rights: meaning that permissions, auhtorities. 

*Grants*

In OAuth 2.0, the term “grant type” refers to the way an application gets an access token. 

* Authorisation code grant
* Implicit is common web apps and mobile apps
* Client credentials grant is useful in system-to-system com. 

*CommonOAuth2Provider*
* Provides native support for connecting to Okta, Google, Github, and Facebook; those auth providers. 
* Property-based configuration in Spribg boot. 
* Client-side OAuth integration, fx: third party login operation, then clients don't need keep sensitive profile data by themselves; released from the risks being hacked. 

*Authorization Server* 
* Provides authorization service; many company may need to have internally. 
* `@EnableAuthorizationServer`
* Customer Auth-configuation is plugged into Spring framework via Adapter, i.e. `AuthorizationServerConfigurerAdapter`
* Supporting differnt grant types by the same configuration

*Resource Serverr*
* the host that stored the protected data
* Configuring a resource server: `@EnableResourceServer`

*OAuth-2 Client*
* Full client-side support
* `@EnableOauth2Client`
* Using specific resttemplate(`Oauth2RestTemplate`) to connecting to 



