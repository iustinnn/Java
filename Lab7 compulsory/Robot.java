import java.util.Random;

public class Robot implements Runnable {
    SharedMemory sharedMemory;
    private String name;
    private boolean running;
    Exploration explore;
    public Robot(String name) {
        this.name = name;
    }

    public void run() {

    Random rand=new Random();
        while(running){
            int randRow=rand.nextInt(explore.map.matrix.length);
            int randCol=rand.nextInt(explore.map.matrix.length);
            explore.map.visit(randRow,randCol,this);
        }



    }
}