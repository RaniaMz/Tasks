import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class TwitterApp {

    private static String authoKey;
    private static String secretKey;
    private static String accessToken;
    private static String accessTokenSecret;

    public static Twitter getTwitterinstance() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(authoKey)
                .setOAuthConsumerSecret(secretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = twitterFactory.getSingleton();

        twitter = TwitterFactory.getSingleton();
        return twitter;
    }

    public static String postTweet(String tweet) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Status status = twitter.updateStatus("[+] The app posted = " + tweet);
        return status.getText();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("[+] Enter the account Key ..");
        authoKey = reader.readLine();
        System.out.println("[+] Enter the account secret key ..");
        secretKey = reader.readLine();
        System.out.println("[+] Enter the Access token ..");
        accessToken = reader.readLine();
        System.out.println("[+] Enter the Access token secret ..");
        accessTokenSecret = reader.readLine();

        System.out.println("\n[+] Enter status text ..");
        String status = reader.readLine();
        String tweet = postTweet(status);
        System.out.println("\n[+] The tweeted post is = " + tweet);
    }
}
