public class Timekeeper extends Thread {

    private final long timeLimit;  // time limit in milliseconds
    private long startTime;  // start time of exploration
    private boolean explorationCompleted = false;
    private boolean running = true;
    public boolean indexApplied = true;

    public Timekeeper(long timeLimit) {
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
    }

    public void turnOn() {
        this.startTime = System.currentTimeMillis();
        setDaemon(true);  // set as daemon thread
    }

    public void run() {
        while (true && running) {

            long elapsedTime = System.currentTimeMillis() - startTime;
            if (explorationCompleted == true) {
                System.out.println("Exploration finished in: " + elapsedTime / 1000 + " seconds");
                this.running = false;
            }
            if (elapsedTime > timeLimit) {
                System.out.println("Exploration time limit reached. Stopping all robots.");
                System.exit(0);  // terminate program
            }
            //    System.out.println("Elapsed time: " + elapsedTime / 1000 + " seconds");
        }
    }


    public void finishTimer() {
        if (indexApplied) {
            System.out.println("Exploration succesfully in: " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
            indexApplied = false;
        }

    }

    public void setExplorationCompleted(boolean completed) {
        explorationCompleted = completed;
    }
}
