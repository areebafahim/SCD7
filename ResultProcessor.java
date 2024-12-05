
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ResultProcessor {
   private final List<Result> results;
    private final Object lock = new Object();

    public ResultProcessor() {
        results = Collections.synchronizedList(new ArrayList<>());
    }

    public void recordResult(String studentName, int score) {
        synchronized (lock) {
            results.add(new Result(studentName, score));
        }
    }

    public void displayResults() {
        System.out.println("\n--- Final Results ---");
        synchronized (lock) {
            for (Result result : results) {
                System.out.println(result.getStudentName() + ": " + result.getScore());
            }
        }
    } 
}
