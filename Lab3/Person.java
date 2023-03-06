import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {
    private String name;
    private Map<Node, String> relationships = new HashMap<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }
}
