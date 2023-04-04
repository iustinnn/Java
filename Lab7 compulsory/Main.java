public class Main {

    public static void main(String args[]) {
        Exploration explore = new Exploration(5);
        Robot robot1 = new Robot("Wall-E");
        Robot robot2 = new Robot("R2D2");
        Robot robot3 = new Robot("Optimus Prime");

        robot1.setExplore(explore);
        robot2.setExplore(explore);
        robot3.setExplore(explore);

        explore.addRobot(robot1);
        explore.addRobot(robot2);
        explore.addRobot(robot3);

        explore.start();
explore.stop();
        System.out.println(explore.map.toString());
    }

}