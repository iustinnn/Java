import java.util.ArrayList;
import java.util.List;

public class ExplorationMap {
    int index;
    public final Object[][] matrix;
    public SharedMemory sharedMemory;

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
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (((List<Token>) matrix[row][col]).isEmpty()) {
                List<Token> extractedTokens = sharedMemory.extractTokens(5);
                matrix[row][col] = extractedTokens;
                //   and store the tokens in the cell (it becomes visited)
                System.out.println("Celula" + row + " " + col + "vizitata si token salvat");
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                s = s + matrix[i][j] + " ";
            }
            s=s+"\n";
        }
        return s;
    }
}