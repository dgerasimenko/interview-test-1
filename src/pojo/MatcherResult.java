package pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MatcherResult {

    private final Map<String, Set<Location>> result;

    public MatcherResult() {
        result = new HashMap<>();
    }

    public void putLocation(String name, Location location) {
        Set<Location> locations = result.get(name);
        if (locations == null) {
            locations = new TreeSet<>();
        }
        locations.add(location);
        result.put(name, locations);
    }

    public Map<String, Set<Location>> getResult() {
        return result;
    }
}
