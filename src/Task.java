public interface Task {
    String getPrompt();
    Feedback checkAnswer(String answer);
}
