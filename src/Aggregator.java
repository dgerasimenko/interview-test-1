import pojo.Location;
import pojo.MatcherResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 3. The aggregator - aggregates the results from all the matchers and prints the results.
 */
public class Aggregator {

    private final Map<String, Set<Location>> result;

    public Aggregator() {
        this.result = new HashMap<>();
    }

    public void aggregate(Future<MatcherResult> matcherResultFuture) throws ExecutionException, InterruptedException {
        MatcherResult matcherResult = matcherResultFuture.get();

        for (Map.Entry<String, Set<Location>> entry : matcherResult.getResult().entrySet()) {
            Set<Location> nameLocations = result.get(entry.getKey());
            if (nameLocations == null) {
                nameLocations = new TreeSet<>();
            }
            nameLocations.addAll(entry.getValue());
            result.put(entry.getKey(), nameLocations);
        }
    }

    public void pintResult() {
        for (Map.Entry<String, Set<Location>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}
