import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExplorationMap {
    int index;
    public final Object[][] matrix;
    public SharedMemory sharedMemory;
    public int visitedCellsCount = 0;
    public boolean statusFinished = false;
    public Map<String, Integer> myMap = new HashMap<>();

    public ExplorationMap(int n, SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
        this.index = n;
        matrix = new Object[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new ArrayList<Token>();
            }
        }
    }

    //Cell should be a wrapper or alias for List<Token>
    public void visit(int row, int col, Robot robot) {


        List<Token> extractedTokens = sharedMemory.extractTokens(5);
        matrix[row][col] = extractedTokens;
        if(!myMap.containsKey(robot.getName())){
            myMap.put(robot.getName(),5);
        }
        else{
            int k=myMap.get(robot.getName());
            myMap.put(robot.getName(),k+5);
        }
        visitedCellsCount++;
        //   and store the tokens in the cell (it becomes visited)
        System.out.println("Celula" + row + " " + col + "vizitata si token salvat de" + robot.getName() + " " + visitedCellsCount);
        System.out.println(visitedCellsCount + " " + index);
        if (visitedCellsCount == index * index) {
            statusFinished = true;
            System.out.println("Vizitare finalizata!");

        }
        System.out.println(statusFinished);


    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                s = s + matrix[i][j] + " ";
            }
            s = s + "\n";
        }
        return s;
    }
}