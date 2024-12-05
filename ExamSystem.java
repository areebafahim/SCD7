
import java.util.ArrayList;
import java.util.List;
public class ExamSystem {
  public static void main(String[] args) {
        // Create shared Exam and ResultProcessor instances
        Exam exam = new Exam();
        ResultProcessor resultProcessor = new ResultProcessor();

        // Create student threads
        int numStudents = 5;
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= numStudents; i++) {
            students.add(new Student("Student " + i, exam, resultProcessor));
        }

        // Start all student threads
        System.out.println("The exam is starting...");
        for (Student student : students) {
            student.start();
        }

        // Wait for all threads to complete
        for (Student student : students) {
            try {
                student.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Display final results
        System.out.println("\nThe exam has concluded for all students.");
        resultProcessor.displayResults();
    }  
}
