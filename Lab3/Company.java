public class Company implements Node, Comparable<Company>{
private String name;

    @Override
    public String getName() {
        return name;
    }

    public Company(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Company o) {
        return this.getName().compareTo(o.getName());
    }


}
