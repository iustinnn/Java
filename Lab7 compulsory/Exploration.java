
import java.util.ArrayList;
import java.util.*;
public class Exploration {
    public void Exploration(int n){
        index=n;
    }
    private final List<Robot> robots = new ArrayList<>();
    private int index;
    private final SharedMemory mem = new SharedMemory(index);
    public final ExplorationMap map = new ExplorationMap(index);
public void addRobot(Robot robot){
    robots.add(robot);
}
    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }
}