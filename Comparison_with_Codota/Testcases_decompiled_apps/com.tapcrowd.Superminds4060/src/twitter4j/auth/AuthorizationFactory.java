package twitter4j.auth;

public final class AuthorizationFactory {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: twitter4j.auth.OAuthAuthorization} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: twitter4j.auth.BasicAuthorization} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static twitter4j.auth.Authorization getInstance(twitter4j.conf.Configuration r9) {
        /*
            r2 = 0
            java.lang.String r3 = r9.getOAuthConsumerKey()
            java.lang.String r4 = r9.getOAuthConsumerSecret()
            if (r3 == 0) goto L_0x002e
            if (r4 == 0) goto L_0x002e
            twitter4j.auth.OAuthAuthorization r5 = new twitter4j.auth.OAuthAuthorization
            r5.<init>(r9)
            java.lang.String r0 = r9.getOAuthAccessToken()
            java.lang.String r1 = r9.getOAuthAccessTokenSecret()
            if (r0 == 0) goto L_0x0026
            if (r1 == 0) goto L_0x0026
            twitter4j.auth.AccessToken r8 = new twitter4j.auth.AccessToken
            r8.<init>(r0, r1)
            r5.setOAuthAccessToken(r8)
        L_0x0026:
            r2 = r5
        L_0x0027:
            if (r2 != 0) goto L_0x002d
            twitter4j.auth.NullAuthorization r2 = twitter4j.auth.NullAuthorization.getInstance()
        L_0x002d:
            return r2
        L_0x002e:
            java.lang.String r7 = r9.getUser()
            java.lang.String r6 = r9.getPassword()
            if (r7 == 0) goto L_0x0027
            if (r6 == 0) goto L_0x0027
            twitter4j.auth.BasicAuthorization r2 = new twitter4j.auth.BasicAuthorization
            r2.<init>(r7, r6)
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.auth.AuthorizationFactory.getInstance(twitter4j.conf.Configuration):twitter4j.auth.Authorization");
    }
}
