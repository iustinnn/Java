import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {
    public String name;
    private Date birthDay;
    public Map<Node, String> relationships;
    //adauga
    public void addRelationship(Node node, String value) {

        relationships.put(node, this.name);

    }
    public void addRelationship(Company node, String value) {

        relationships.put(node, this.name);
        //in cazul in care avem un nod care e de tip company, il adaugam si in vectorul de relatii ale companiilor
        if(node instanceof Company){
           node.addNodex(node,this.name);
        }
    }
    public int getRelationships(){

        return relationships.size();
    }
    public void getRelationshipsName(){

      for(Map.Entry<Node,String> entry : relationships.entrySet()){
          System.out.println(entry.getKey().getName());
      }
    }
    public Person(String name,Date birthDay) {
        this.name = name;
        this.birthDay=birthDay;
        this.relationships=new HashMap<>();
    }
public Map<Node, String> getRelationshipsNames(){
        return relationships;
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

}