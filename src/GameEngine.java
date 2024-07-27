import java.util.List;

public class GameEngine {
    private Player player;
    private Level currentLevel;
    private Task currentTask;
    private final RankSystem rankSystem;
    private final LevelLoader levelLoader;

    public GameEngine(Player player) {
        this.player = player;
        this.rankSystem = new RankSystem();
        this.levelLoader = new LevelLoader();
    }

    public void showLevels() {
        List<Level> levels = levelLoader.loadLevels();
        for (int i = 0; i < levels.size(); i++) {
            System.out.println((i + 1) + ". Уровень " + (i + 1));
        }
    }

    public void startGame(int levelIndex) {
        List<Level> levels = levelLoader.loadLevels();
        if (levelIndex >= 0 && levelIndex < levels.size()) {
            currentLevel = levels.get(levelIndex);
            startTask(0);
        } else {
            System.out.println("Неверный индекс уровня.");
        }
    }

    public void submitAnswer(String answer) {
        if (currentTask != null) {
            Feedback feedback = currentTask.checkAnswer(answer);
            System.out.println(feedback.message());
            if (feedback.correct()) {
                player.incrementProgress();
                moveToNextTask();
            }
        }
    }

    public void saveProgress() {
        ProgressSaver.save(player);
        System.out.println("Прогресс сохранен.");
    }

    public void loadProgress() {
        player = ProgressSaver.load();
        System.out.println("Прогресс загружен.");
    }

    public void showRank() {
        String rank = rankSystem.getRank(player.getProgress());
        System.out.println("Ваш ранг: " + rank);
    }

    public void nextLevel() {
        if (currentLevel != null) {
            int currentLevelIndex = levelLoader.getLevelIndex(currentLevel);
            if (currentLevelIndex + 1 < levelLoader.loadLevels().size()) {
                startGame(currentLevelIndex + 1);
            } else {
                System.out.println("Вы уже на последнем уровне.");
            }
        }
    }

    private void startTask(int taskIndex) {
        if (currentLevel != null && taskIndex < currentLevel.tasks().size()) {
            currentTask = currentLevel.tasks().get(taskIndex);
            System.out.println("Задача: " + currentTask.getPrompt());
        }
    }

    private void moveToNextTask() {
        if (currentLevel != null) {
            int currentTaskIndex = currentLevel.tasks().indexOf(currentTask);
            if (currentTaskIndex + 1 < currentLevel.tasks().size()) {
                startTask(currentTaskIndex + 1);
            } else {
                System.out.println("Вы завершили уровень!");
                nextLevel();
            }
        }
    }
}
