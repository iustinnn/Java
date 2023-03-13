import java.util.ArrayList;
import java.util.List;

public class Network {
    private String name;
    public Network(String name){
        this.name=name;
    }
    public List<Node> nodes = new ArrayList<>();
    //adauga nod in network
    public void addNode(Node node) {

        this.nodes.add(node);
    }

    //afiseaza numere nodurile din network
    public void getNodes() {
        for(Node node : nodes){
            System.out.println(node.getName());
        }
    }
//afiseaza numarul de relatii ale nodului node
    public int numberRelationships(Node node){
        return node.getRelationships();
}

//sorteaza nodurile retelei dupa nr de relatii
    public void nodeImportance(){
nodes.sort((node1,node2) -> numberRelationships(node1)-numberRelationships(node2));
    }
}
