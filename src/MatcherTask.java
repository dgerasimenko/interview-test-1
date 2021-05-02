import pojo.Location;
import pojo.MatcherResult;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. The matcher - gets a text string as input and searches for matches of a given set of
 * strings. The result is a map from a word to its location(s) in the text
 */
public class MatcherTask implements Callable<MatcherResult> {

    private static final Pattern PATTERN = Pattern.compile("\\w+");

    private final List<String> englishNames;
    private final long rowIndex;
    private final Matcher matcher;

    public MatcherTask(long rowIndex, String row, List<String> englishNames) {
        this.rowIndex = rowIndex;
        this.englishNames = englishNames;
        this.matcher = PATTERN.matcher(row);
    }

    @Override
    public MatcherResult call() {
        MatcherResult result = new MatcherResult();
        while (matcher.find()) {
            String word = matcher.group();
            for (String name : englishNames) {
                if (word.equals(name)) {
                    int startCharIndex = matcher.start() + 1;
                    result.putLocation(name, new Location(rowIndex, startCharIndex));
                }
            }
        }
        return result;
    }
}
