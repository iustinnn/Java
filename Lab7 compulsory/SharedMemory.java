import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SharedMemory {
    private final List<Token> tokens = new ArrayList<>();
    public SharedMemory(int n) {
        for(int i=0; i<n*n*n; i++){
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        Random rand = new Random();
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            int randomIndex = rand.nextInt(tokens.size());
            extracted.add(tokens.get(randomIndex));
            tokens.remove(randomIndex);
        }
        return extracted;
    }
}