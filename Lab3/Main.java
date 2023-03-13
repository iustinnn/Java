import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Network retea = new Network("Graf 1");
        Person p1 = new Person("Alex", new Date(2000, 7, 31));
        Person p2 = new Person("Mihai", new Date(1976, 5, 10));
        Person p3 = new Person("Vlad", new Date(1979, 3, 11));
        Person p4 = new Person("Calin", new Date(1976, 8, 19));
        Person p5 = new Person("Alexa", new Date(1999, 9, 21));
        Person p6 = new Person("Andu", new Date(1988, 1, 8));
        Company c1 = new Company("Bytex");
        Company c2 = new Company("Bydtex");
        Company c3 = new Company("Bydtdex");
        p1.addRelationship(p2, "Frate");
        p1.addRelationship(p3, "Sora");
        p1.addRelationship(c1, "CEO");
        p2.addRelationship(c1, "Sef");
        p5.addRelationship(c1, "Angajat");
        p6.addRelationship(c1, "Employee");
        p2.addRelationship(c2, "Intern");
        p1.addRelationship(c3, "Intern");
        c1.getValues();
        System.out.println(c1.getRelationships(c1));
        System.out.println(c2.getRelationships(c2));
        System.out.println(p1.getRelationships());
        retea.addNode(p1);
        retea.addNode(p4);
        retea.addNode(c2);
        retea.nodeImportance();//sorteaza nodurile retelei
        retea.getNodes();
        System.out.println("P1 are relatii cu:");
        p1.getRelationshipsName();

    }


}