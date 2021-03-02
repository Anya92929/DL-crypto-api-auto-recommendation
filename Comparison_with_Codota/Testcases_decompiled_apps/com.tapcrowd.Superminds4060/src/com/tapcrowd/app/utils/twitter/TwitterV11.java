package com.tapcrowd.app.utils.twitter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapcrowd.app.utils.twitter.TwitterDialog;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterV11 {
    private Context context;
    private TwitterDialog.OnLoginListener listener;
    private SharedPreferences sharedPreferences;

    public TwitterV11(Context context2, TwitterDialog.OnLoginListener listener2) {
        this.context = context2;
        this.listener = listener2;
        this.sharedPreferences = context2.getSharedPreferences(TwitterConst.PREFERENCE_NAME, 0);
    }

    public void login(boolean doLogin) {
        String oauthAccessToken = this.sharedPreferences.getString("oauth_token", "");
        String oAuthAccessTokenSecret = this.sharedPreferences.getString("oauth_token_secret", "");
        if (!oAuthAccessTokenSecret.equals("") && !oauthAccessToken.equals("")) {
            Twitter twitter = new TwitterFactory(new ConfigurationBuilder().setOAuthConsumerKey(TwitterConst.CONSUMER_KEY).setOAuthConsumerSecret(TwitterConst.CONSUMER_SECRET).setOAuthAccessToken(oauthAccessToken).setOAuthAccessTokenSecret(oAuthAccessTokenSecret).build()).getInstance();
            if (this.listener != null) {
                this.listener.onLogin(twitter);
            }
        } else if (doLogin) {
            new TwitterDialog(this.context, this.listener).show();
        } else {
            this.listener.onError();
        }
    }
}
