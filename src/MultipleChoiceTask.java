import java.util.Map;

public class MultipleChoiceTask implements Task {
    private final String prompt;
    private final Map<Integer, String> options;
    private final int correctOption;

    public MultipleChoiceTask(String prompt, Map<Integer, String> options, int correctOption) {
        this.prompt = prompt;
        this.options = options;
        this.correctOption = correctOption;
    }

    @Override
    public String getPrompt() {
        StringBuilder sb = new StringBuilder(prompt + "\n");
        options.forEach((key, value) -> sb.append(key).append(". ").append(value).append("\n"));
        return sb.toString();
    }

    @Override
    public Feedback checkAnswer(String answer) {
        try {
            int selectedOption = Integer.parseInt(answer);
            boolean isCorrect = selectedOption == correctOption;
            return new Feedback(isCorrect, isCorrect ? "Правильно!" : "Неправильно, попробуйте еще раз.");
        } catch (NumberFormatException e) {
            return new Feedback(false, "Неверный формат ответа. Пожалуйста, введите номер варианта.");
        }
    }
}
