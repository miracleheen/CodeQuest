public class Player {
    private int progress;

    public Player() {
        this.progress = 0;
    }

    public int getProgress() {
        return progress;
    }

    public void incrementProgress() {
        this.progress++;
    }
}
