import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(new Company("Dell"));
        nodes.add(new Person("Alex"));
        nodes.add(new Person("Vlad"));
        nodes.add(new Person("Mihail"));
        nodes.add(new Person("Dell"));
        nodes.add(new Company("HP"));
      //  Collections.sort(nodes);
        for (Node nod : nodes)
        {
            System.out.println(nod.getName());

        }
    }



}