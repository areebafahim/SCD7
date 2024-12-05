
import java.util.Random;
public class Student extends Thread{
  private final String name;
    private final Exam exam;
    private final ResultProcessor resultProcessor;
    private int score;

    public Student(String name, Exam exam, ResultProcessor resultProcessor) {
        this.name = name;
        this.exam = exam;
        this.resultProcessor = resultProcessor;
        this.score = 0;
    }

    @Override
    public void run() {
        System.out.println(name + " has started the exam.");
        while (true) {
            String question = exam.fetchQuestion();
            if (question == null) {
                System.out.println(name + " has no more questions to answer.");
                break;
            }
            System.out.println(name + " is answering: " + question);
            try {
                Thread.sleep(new Random().nextInt(1500) + 500); // Simulate time to answer (0.5 to 2 seconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            score += new Random().nextInt(2); // Random score: 0 or 1
        }
        System.out.println(name + " completed the exam with a score of " + score + ".");
        resultProcessor.recordResult(name, score);
    }  
}
