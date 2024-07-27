import java.util.Map;
import java.util.TreeMap;

public class RankSystem {
    private final Map<Integer, String> rankThresholds;

    public RankSystem() {
        rankThresholds = new TreeMap<>();
        rankThresholds.put(0, "Новичок");
        rankThresholds.put(3, "Любитель");
        rankThresholds.put(6, "Профессионал");
        rankThresholds.put(9, "Мастер");
    }

    public String getRank(int progress) {
        return rankThresholds.entrySet()
                .stream()
                .filter(entry -> progress >= entry.getKey())
                .reduce((first, second) -> second)
                .map(Map.Entry::getValue)
                .orElse("Неизвестный ранг");
    }
}
