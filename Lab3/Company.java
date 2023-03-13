import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company implements Node, Comparable<Company>{
    private String name;
    //Hashmap-ul care contine toate relatiile companiilor
    public static Map<Node, List<String>> relationshipsCompany=new HashMap<>();
    //functia adauga in hashmap-ul companiilor persoana (functia) din relatia persoana-companie
    public void addNodex(Node node,String position){
        //in cazul in care avem mai multe persoane angajate la aceeasi companie
        if(relationshipsCompany.containsKey(node)){
            relationshipsCompany.get(node).add(position);
        }
        else{
            List<String> list = new ArrayList<>();
            relationshipsCompany.put(node, list);
            relationshipsCompany.get(node).add(position);
        }
    }
    //returneaza numele companiilor si functiile
public void getValues(){
    System.out.println(relationshipsCompany);
}
    public Company(String name) {
        this.name = name;
    }
    public int getRelationships(Node node){
        return relationshipsCompany.get(node).size();
    }
    public int getRelationships(){
        return relationshipsCompany.get((Node)this).size();
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

@Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
}