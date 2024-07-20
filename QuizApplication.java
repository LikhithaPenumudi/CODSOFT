import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private String[] questions = {
        "What is the capital of France?",
        "What is 2 + 2?",
        "What is the largest planet in our solar system?"
    };
    private String[][] choices = {
        {"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"},
        {"1. 3", "2. 4", "3. 5", "4. 6"},
        {"1. Earth", "2. Jupiter", "3. Mars", "4. Venus"}
    };
    private int[] correctAnswers = {3, 2, 2};

    private int currentQuestionIndex = 0;
    private int score = 0;
    private static final int TIME_LIMIT = 15; // 15 seconds for each question
    private Timer timer;
    private boolean timeUp = false;

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        while (currentQuestionIndex < questions.length) {
            System.out.println(questions[currentQuestionIndex]);
            for (String choice : choices[currentQuestionIndex]) {
                System.out.println(choice);
            }

            timeUp = false;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                    showNextQuestion();
                }
            }, TIME_LIMIT * 1000);

            System.out.print("Your answer (enter the number): ");
            int answer = scanner.nextInt();
            timer.cancel();

            if (timeUp) continue;

            checkAnswer(answer);
            showNextQuestion();
        }

        showResult();
        scanner.close();
    }

    private void checkAnswer(int answer) {
        if (answer == correctAnswers[currentQuestionIndex]) {
            score++;
        }
    }

    private void showNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            System.out.println();
        }
    }

    private void showResult() {
        System.out.println("Quiz Completed!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }

    public static void main(String[] args) {
        QuizApplication quiz = new QuizApplication();
        quiz.startQuiz();
    }
}


