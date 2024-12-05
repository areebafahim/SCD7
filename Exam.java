import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Exam {
 private final List<String> questions;
    private final Object lock = new Object();

    public Exam() {
        questions = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            questions.add("Question " + i);
        }
    }

    public String fetchQuestion() {
        synchronized (lock) {
            if (!questions.isEmpty()) {
                return questions.remove(0);
            }
            return null;
        }
    } 
}
