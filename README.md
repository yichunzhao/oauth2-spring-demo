# oauth2-spring-demo

Demo Spring Security OAuth 2 

It needs to understand terms first and then knowing parties involved in the OAuth-2; then may reduce confusions. 

*Terms*
* Resource owner: for instance: an owner who owns a google dirver, where he may store a lot of photoes, and owner's profile data
* Resource sever: fx: a Google driver, it hosts the protected data for the owner. it is responsible for making sure the accessing photoes that must be authenticated and authorized.  
* Client(thrid party): on the behalf of resource owner to access photoes stored in the Google drive, so as to print them out. 
* Authorization Server: the server issuing access token to the client. 

*Token types*

*Access token-the secret and often short-lived token that uniquely identifies a user
*Referesh token-it is used to refresh access token having a longer-lived token; for instance, an access token lasts one day; but an refresh token may last a week; after one week, you have to apply for a new access token.
*Scope it is associated with the access token, providing rights like permissions, auhtorities. 

*Grants*

* Authorisation code grant
* Implicit is common web apps and mobile apps
* Client credentials grant is useful in system-to-system com. 

*CommonOAuth2Provider*
* Provides native support for connecting to Okta,Google,Github,and Facebook;those auth providers. 
* Property-based configuration in Spribg boot. 
* Client-side OAuth integration, fx: third party login operation service, then clients don't need keep client profile data by themselves; released from the risks being hacked. 
