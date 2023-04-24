import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final List<Robot> robots = new ArrayList<>();
    public final int index;
    private final SharedMemory mem;
    public final ExplorationMap map;

    public Exploration(int n) {
        this.index = n;
        this.mem = new SharedMemory(index);
        this.map = new ExplorationMap(index, mem);
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void start() {
        for (Robot robot : robots) {
            robot.setExplore(this);
            new Thread(robot).start();
            System.out.println("Robot " + robot.getName() + " started");
        }
    }

    public void pause() {
        for (Robot robot : robots) {
            try {
                robot.doStop();
            } catch (Exception e) {
                System.out.println("eroare la intrupere robot");
            }


        }
    }
}
