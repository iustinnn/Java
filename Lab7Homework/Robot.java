import java.util.List;
import java.util.Random;

public class Robot implements Runnable {
    private final String name;
    private boolean running = true;
    private Exploration explore;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public void run() {
        int firstRand = 0;
        int randCol = -1;
        int randRow = -1;
        Random rand = new Random();
        while (running && explore.map.visitedCellsCount < explore.index * explore.index) {
            if (firstRand == 0) {
                firstRand++;
                randRow = rand.nextInt(explore.map.matrix.length);
                randCol = rand.nextInt(explore.map.matrix.length);
                synchronized (explore.map.matrix[randRow][randCol]) {
                    if (((List<Token>) explore.map.matrix[randRow][randCol]).isEmpty()) {
                        explore.map.visit(randRow, randCol, this);
                    }
                }

            } else {
                boolean found = false;
                if (randRow < explore.map.index - 1) {
                    randRow = randRow + 1;
                }
                synchronized (explore.map.matrix[randRow][randCol]) {
                    if (((List<Token>) explore.map.matrix[randRow][randCol]).isEmpty()) {
                        found = true;
                        explore.map.visit(randRow, randCol, this);
                    }
                }
                if (found == false) {
                    if (randCol < explore.map.index - 1) {
                        randCol = randCol + 1;
                    }
                    synchronized (explore.map.matrix[randRow][randCol]) {
                        if (((List<Token>) explore.map.matrix[randRow][randCol]).isEmpty()) {
                            found = true;
                            explore.map.visit(randRow, randCol, this);
                        }
                    }
                    if (found == false) {
                        if (randRow < explore.map.index - 1) {
                            randRow = randRow + 1;
                        }
                        synchronized (explore.map.matrix[randRow][randCol]) {
                            if (((List<Token>) explore.map.matrix[randRow][randCol]).isEmpty()) {
                                found = true;
                                explore.map.visit(randRow, randCol, this);
                            }

                        }
                        if (found == false) {
                            if (randCol < explore.map.index - 1) {
                                randCol = randCol + 1;
                            }
                            synchronized (explore.map.matrix[randRow][randCol]) {
                                if (((List<Token>) explore.map.matrix[randRow][randCol]).isEmpty()) {
                                    found = true;
                                    explore.map.visit(randRow, randCol, this);
                                }
                            }
                            if (found == false) {
                                if (randCol > 2 && randRow > 3) {
                                    randCol = randCol - 1;
                                    randRow = randRow - 2;
                                }
                                synchronized (explore.map.matrix[randRow][randCol]) {
                                    if (((List<Token>) explore.map.matrix[randRow][randCol]).isEmpty()) {
                                        found = true;
                                        explore.map.visit(randRow, randCol, this);
                                    }
                                }
                                if (found == false) {
                                    randRow = rand.nextInt(explore.map.matrix.length);
                                    randCol = rand.nextInt(explore.map.matrix.length);
                                    synchronized (explore.map.matrix[randRow][randCol]) {
                                        if (((List<Token>) explore.map.matrix[randRow][randCol]).isEmpty()) {
                                            explore.map.visit(randRow, randCol, this);
                                        }
                                    }
                                }
                            }
                        }

                    }

                }

                // System.out.println(Thread.currentThread().getName()+"fafa\n");
            }
        }

    }

    public void start() {
        this.running = true;
    }

    public void doStop() {
        this.running = false;
        System.out.println(this.getName() + " Stopped");
    }
}

