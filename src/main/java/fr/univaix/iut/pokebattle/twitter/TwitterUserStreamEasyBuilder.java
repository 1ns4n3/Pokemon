package fr.univaix.iut.pokebattle.twitter;

import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;
import fr.univaix.iut.pokebattle.tuse.UserStreamAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.UserStreamListener;

public class TwitterUserStreamEasyBuilder {
    private final static Logger logger = LoggerFactory.getLogger(TwitterBot.class);
    private Credentials credentials;
    private Twitter twitter;
    private Bot bot;

    public TwitterUserStreamEasyBuilder(Credentials credentials, Twitter twitter, Bot bot) {
        this.credentials = credentials;
        this.twitter = twitter;
        this.bot = bot;
    }

    public TwitterUserStreamEasy build() {
        UserStreamListener listener = new UserStreamAdapter() {
            @Override
            public void onStatus(Status status) {
                logger.info("TwitterUserStreamEasyExample.onStatus()");
                try {
                    processNewQuestion(status, bot);
                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        };
        return new TwitterUserStreamEasy(listener, credentials);
    }

    private void processNewQuestion(Status status, Bot bot) throws TwitterException {
        if (isNotANewQuestion(status)) {
            logger.info("Ignored status change");
            return;
        }

        String response = bot.ask(new Tweet(status.getText(),status.getUser().getScreenName(),  twitter));

        if (response != null) {
            twitter.updateStatus(response);
        }
    }

    private boolean isNotANewQuestion(Status status) throws TwitterException {
        return isTweetOfMe(status) || !isTweetForMe(status);
    }

    private boolean isTweetForMe(Status status) throws TwitterException {
        return status.getText().toLowerCase().contains(twitter.getScreenName().toLowerCase());
    }

    private boolean isTweetOfMe(Status status) throws TwitterException {
        return status.getUser().getId() == twitter.getId();
    }
}