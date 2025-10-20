package lab07;

import java.time.Instant;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Tweet> tweets = Arrays.asList(
            new Tweet(1, "alice", "Hi @bob", Instant.now()),
            new Tweet(2, "bob", "Hello @charlie @dave", Instant.now()),
            new Tweet(3, "charlie", "Hey @alice", Instant.now())
        );

        Map<String, Set<String>> graph = SocialNetwork.guessFollowsGraph(tweets);
        System.out.println("Social Graph: " + graph);

        List<String> influencers = SocialNetwork.influencers(graph);
        System.out.println("Influencers: " + influencers);
    }
}
