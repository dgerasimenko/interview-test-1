import java.util.ArrayList;
import java.util.List;

public class App {

    private static final List<String> ENGLISH_FIRST_NAMES = new ArrayList<>(50);

    static {
        ENGLISH_FIRST_NAMES.add("James");
        ENGLISH_FIRST_NAMES.add("John");
        ENGLISH_FIRST_NAMES.add("Robert");
        ENGLISH_FIRST_NAMES.add("Michael");
        ENGLISH_FIRST_NAMES.add("William");
        ENGLISH_FIRST_NAMES.add("David");
        ENGLISH_FIRST_NAMES.add("Richard");
        ENGLISH_FIRST_NAMES.add("Charles");
        ENGLISH_FIRST_NAMES.add("Joseph");
        ENGLISH_FIRST_NAMES.add("Thomas");
        ENGLISH_FIRST_NAMES.add("Christopher");
        ENGLISH_FIRST_NAMES.add("Daniel");
        ENGLISH_FIRST_NAMES.add("Paul");
        ENGLISH_FIRST_NAMES.add("Mark");
        ENGLISH_FIRST_NAMES.add("Donald");
        ENGLISH_FIRST_NAMES.add("George");
        ENGLISH_FIRST_NAMES.add("Kenneth");
        ENGLISH_FIRST_NAMES.add("Steven");
        ENGLISH_FIRST_NAMES.add("Edward");
        ENGLISH_FIRST_NAMES.add("Brian");
        ENGLISH_FIRST_NAMES.add("Ronald");
        ENGLISH_FIRST_NAMES.add("Anthony");
        ENGLISH_FIRST_NAMES.add("Kevin");
        ENGLISH_FIRST_NAMES.add("Jason");
        ENGLISH_FIRST_NAMES.add("Matthew");
        ENGLISH_FIRST_NAMES.add("Gary");
        ENGLISH_FIRST_NAMES.add("Timothy");
        ENGLISH_FIRST_NAMES.add("Jose");
        ENGLISH_FIRST_NAMES.add("Larry");
        ENGLISH_FIRST_NAMES.add("Jeffrey");
        ENGLISH_FIRST_NAMES.add("Frank");
        ENGLISH_FIRST_NAMES.add("Scott");
        ENGLISH_FIRST_NAMES.add("Eric");
        ENGLISH_FIRST_NAMES.add("Stephen");
        ENGLISH_FIRST_NAMES.add("Andrew");
        ENGLISH_FIRST_NAMES.add("Raymond");
        ENGLISH_FIRST_NAMES.add("Gregory");
        ENGLISH_FIRST_NAMES.add("Joshua");
        ENGLISH_FIRST_NAMES.add("Jerry");
        ENGLISH_FIRST_NAMES.add("Dennis");
        ENGLISH_FIRST_NAMES.add("Walter");
        ENGLISH_FIRST_NAMES.add("Patrick");
        ENGLISH_FIRST_NAMES.add("Peter");
        ENGLISH_FIRST_NAMES.add("Harold");
        ENGLISH_FIRST_NAMES.add("Douglas");
        ENGLISH_FIRST_NAMES.add("Henry");
        ENGLISH_FIRST_NAMES.add("Carl");
        ENGLISH_FIRST_NAMES.add("Arthur");
        ENGLISH_FIRST_NAMES.add("Ryan");
        ENGLISH_FIRST_NAMES.add("Roger");
    }

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.err.println("Please specify input file!");
            return;
        }
        if (args.length > 1) {
            System.err.println("Wrong number of input parameters!");
            return;
        }
        long start = System.currentTimeMillis();
        System.out.println("Start text processing...");
        new Main(args[0], ENGLISH_FIRST_NAMES).doMain();
        System.out.println("Stop text processing. Total execution time: " + (System.currentTimeMillis() - start) + " millis");
    }
}
