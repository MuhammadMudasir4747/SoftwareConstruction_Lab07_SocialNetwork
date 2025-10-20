package lab07;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.Instant;
import java.util.*;

/**
 * Tests for the SocialNetwork class.
 */
public class SocialNetworkTest {

    private static final Instant time1 = Instant.parse("2020-01-01T10:00:00Z");
    private static final Instant time2 = Instant.parse("2020-01-01T11:00:00Z");

    private static final Tweet tweet1 = new Tweet(1, "alice", "Hello everyone", time1);
    private static final Tweet tweet2 = new Tweet(2, "bob", "Hey @alice and @charlie!", time2);

    // 1. Empty list of tweets -> empty graph
    @Test
    public void testEmptyListReturnsEmptyGraph() {
        Map<String, Set<String>> graph = SocialNetwork.guessFollowsGraph(Collections.emptyList());
        assertTrue(graph.isEmpty());
    }

    // 2. Tweets without mentions -> empty graph
    @Test
    public void testTweetsWithoutMentions() {
        List<Tweet> tweets = Arrays.asList(tweet1);
        Map<String, Set<String>> graph = SocialNetwork.guessFollowsGraph(tweets);
        assertTrue(graph.isEmpty());
    }

    // 3. Single mention -> creates a following link
    @Test
    public void testSingleMention() {
        List<Tweet> tweets = Arrays.asList(tweet2);
        Map<String, Set<String>> graph = SocialNetwork.guessFollowsGraph(tweets);

        assertTrue(graph.containsKey("bob"));
        assertTrue(graph.get("bob").contains("alice"));
        assertTrue(graph.get("bob").contains("charlie"));
    }

    // 4. Empty graph -> influencers empty
    @Test
    public void testEmptyInfluencers() {
        List<String> influencers = SocialNetwork.influencers(Collections.emptyMap());
        assertTrue(influencers.isEmpty());
    }

    // 5. Single influencer
    @Test
    public void testSingleInfluencer() {
        Map<String, Set<String>> graph = new HashMap<>();
        graph.put("bob", Set.of("alice"));
        List<String> influencers = SocialNetwork.influencers(graph);

        assertEquals(List.of("alice"), influencers);
    }
}
