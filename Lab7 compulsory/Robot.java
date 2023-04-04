import java.util.Random;

public class Robot implements Runnable {
    private final String name;
    private boolean running=true;
    private Exploration explore;

    public Robot(String name) {
        this.name = name;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public void run() {
        Random rand = new Random();
        while (running) {
          //  System.out.println("gg");
            int randRow = rand.nextInt(explore.map.matrix.length);
            int randCol = rand.nextInt(explore.map.matrix.length);
            explore.map.visit(randRow, randCol, this);
        }
    }

    public void start() {
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }
}
