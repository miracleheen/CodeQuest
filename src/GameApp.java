import java.util.Scanner;

public class GameApp {
    private final Scanner scanner;
    private final GameEngine gameEngine;

    public GameApp() {
        this.scanner = new Scanner(System.in);
        this.gameEngine = new GameEngine(new Player());
    }

    public void start() {
        while (true) {
            displayMainMenu();
            int choice = getUserChoice();
            if (handleMainMenuChoice(choice)) break;
        }
    }

    private void displayMainMenu() {
        System.out.println("""
            1. Начать игру
            2. Загрузить прогресс
            3. Выйти
            """);
    }

    private int getUserChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private boolean handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1 -> startGame();
            case 2 -> loadProgress();
            case 3 -> {
                exitGame();
                return true;
            }
            default -> System.out.println("Неправильный выбор. Попробуйте снова.");
        }
        return false;
    }

    private void startGame() {
        System.out.println("Выберите уровень:");
        gameEngine.showLevels();
        int levelChoice = Integer.parseInt(scanner.nextLine()) - 1;
        gameEngine.startGame(levelChoice);
        gameLoop();
    }

    private void loadProgress() {
        gameEngine.loadProgress();
        System.out.println("Прогресс загружен успешно.");
        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            displayGameMenu();
            int choice = getUserChoice();
            if (handleGameMenuChoice(choice)) break;
        }
    }

    private void displayGameMenu() {
        System.out.println("""
            1. Выбрать ответ
            2. Сохранить прогресс
            3. Показать ранг
            4. Перейти к следующему уровню
            5. Выйти
            """);
    }

    private boolean handleGameMenuChoice(int choice) {
        switch (choice) {
            case 1 -> submitAnswer();
            case 2 -> gameEngine.saveProgress();
            case 3 -> gameEngine.showRank();
            case 4 -> gameEngine.nextLevel();
            case 5 -> {
                exitGame();
                return true;
            }
            default -> System.out.println("Неправильный выбор. Попробуйте снова.");
        }
        return false;
    }

    private void submitAnswer() {
        System.out.println("Введите ваш ответ:");
        String answer = scanner.nextLine();
        gameEngine.submitAnswer(answer);
    }

    private void exitGame() {
        System.out.println("Спасибо за игру!");
        System.exit(0);
    }
}
