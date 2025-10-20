package lab07;

import java.util.*;
import java.util.regex.*;

public class SocialNetwork {

    /**
     * Infers who follows whom based on @-mentions in tweets.
     *
     * @param tweets list of tweets
     * @return a map where each key is a user, and each value is a set of people they follow
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
        Map<String, Set<String>> graph = new HashMap<>();
        Pattern mentionPattern = Pattern.compile("@(\\w+)");

        for (Tweet tweet : tweets) {
            String author = tweet.getAuthor().toLowerCase();
            Matcher matcher = mentionPattern.matcher(tweet.getText());

            while (matcher.find()) {
                String mentionedUser = matcher.group(1).toLowerCase();
                if (!mentionedUser.equals(author)) {
                    graph.putIfAbsent(author, new HashSet<>());
                    graph.get(author).add(mentionedUser);
                }
            }
        }
        return graph;
    }

    /**
     * Returns list of influencers (users with most followers first).
     *
     * @param followsGraph map from user to set of followed users
     * @return list of influencers sorted by follower count (descending)
     */
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
        Map<String, Integer> followerCount = new HashMap<>();

        for (Set<String> followedUsers : followsGraph.values()) {
            for (String followed : followedUsers) {
                followerCount.put(followed, followerCount.getOrDefault(followed, 0) + 1);
            }
        }

        List<String> influencers = new ArrayList<>(followerCount.keySet());
        influencers.sort((a, b) -> followerCount.get(b) - followerCount.get(a));
        return influencers;
    }
}
