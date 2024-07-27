import java.io.*;

public class ProgressSaver {
    private static final String FILE_NAME = "progress.dat";

    public static void save(Player player) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(player);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении прогресса: " + e.getMessage());
        }
    }

    public static Player load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Файл прогресса не найден. Создается новый игрок.");
            return new Player();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Player) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке прогресса: " + e.getMessage());
            return new Player();
        }
    }
}
