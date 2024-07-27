import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LevelLoader {
    public List<Level> loadLevels() {
        List<Level> levels = new ArrayList<>();

        // Уровень 1
        List<Task> level1Tasks = List.of(
                new MultipleChoiceTask(
                        "Что такое обобщения (generics) в Java?",
                        Map.of(
                                1, "Механизм для обеспечения типобезопасности и повторного использования кода.",
                                2, "Метод, позволяющий выполнять операции с типами данных напрямую.",
                                3, "Класс, который наследуется от класса Object и является универсальным."
                        ),
                        1
                ),
                new MultipleChoiceTask(
                        "Какой из следующих методов является частью интерфейса Collection в Java?",
                        Map.of(
                                1, "add(Object o)",
                                2, "insert(Object o)",
                                3, "append(Object o)"
                        ),
                        1
                )
        );
        levels.add(new Level("Уровень 1", level1Tasks));

        // Уровень 2
        List<Task> level2Tasks = List.of(
                new MultipleChoiceTask(
                        "Что такое замыкания (closures) в Java?",
                        Map.of(
                                1, "Это объект, который содержит ссылку на свободные переменные, доступные в области видимости, в которой он был создан.",
                                2, "Это метод, который закрывает доступ к другим методам в классе.",
                                3, "Это специальный синтаксис для создания анонимных классов."
                        ),
                        1
                ),
                new MultipleChoiceTask(
                        "Какой из следующих вариантов является правильным способом создания потока в Java?",
                        Map.of(
                                1, "Thread t = new Thread(() -> System.out.println('Hello'));",
                                2, "Thread t = new Thread(System.out::println('Hello'));",
                                3, "Thread t = new Thread('Hello');"
                        ),
                        1
                )
        );
        levels.add(new Level("Уровень 2", level2Tasks));

        // Уровень 3
        List<Task> level3Tasks = List.of(
                new MultipleChoiceTask(
                        "Что такое синтаксический сахар в Java?",
                        Map.of(
                                1, "Это упрощения в языке программирования, которые делают код более читабельным, но не добавляют нового функционала.",
                                2, "Это синтаксис, который позволяет писать код быстрее и легче.",
                                3, "Это особая версия языка программирования Java для упрощения задач."
                        ),
                        1
                ),
                new MultipleChoiceTask(
                        "Какой из следующих методов используется для сериализации объектов в Java?",
                        Map.of(
                                1, "writeObject(Object o)",
                                2, "serialize(Object o)",
                                3, "save(Object o)"
                        ),
                        1
                )
        );
        levels.add(new Level("Уровень 3", level3Tasks));

        return levels;
    }

    public int getLevelIndex(Level level) {
        List<Level> levels = loadLevels();
        return levels.indexOf(level);
    }
}
