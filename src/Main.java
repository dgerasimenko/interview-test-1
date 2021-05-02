import pojo.MatcherResult;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 1. The main module - reads a large text file in parts (e.g. 1000 lines in each part) and
 * sends each part (as string) to a ​ matcher ​ . After all matchers completed, it calls the
 * aggregator ​ to combine and print the results
 */
public class Main {

    private static final int MAX_NUMBER_OF_ROWS = 1000;

    private final String inputFilePath;
    private final List<String> englishNames;
    private final Aggregator aggregator;
    private final ExecutorService executorService;

    public Main(String inputFilePath, List<String> englishNames) {
        this.inputFilePath = inputFilePath;
        this.englishNames = englishNames;
        aggregator = new Aggregator();
        executorService = Executors.newFixedThreadPool(10);
    }

    public void doMain() {
        try (FileInputStream fileInputStream = new FileInputStream(inputFilePath)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            List<Future<MatcherResult>> matcherResults;
            long rowIndex = 1;
            int tmpNumberOfRows = 0;
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                matcherResults = new ArrayList<>(MAX_NUMBER_OF_ROWS);
                while ((row != null) && tmpNumberOfRows < MAX_NUMBER_OF_ROWS) {
                    MatcherTask matcherTask = new MatcherTask(rowIndex, row, englishNames);
                    Future<MatcherResult> matcherResultFuture = executorService.submit(matcherTask);
                    matcherResults.add(matcherResultFuture);
                    tmpNumberOfRows++;
                    rowIndex++;
                    row = bufferedReader.readLine();
                }

                Iterator<Future<MatcherResult>> resultIterator = matcherResults.iterator();
                while (resultIterator.hasNext()) {
                    aggregator.aggregate(resultIterator.next());
                }
                tmpNumberOfRows = 0;
            }
            aggregator.pintResult();
        } catch (FileNotFoundException e) {
            System.err.println("Could not found file:" + inputFilePath);
        } catch (Exception e) {
            System.err.println("Exception while parse file:" + inputFilePath);
        } finally {
            executorService.shutdown();
        }
    }
}
