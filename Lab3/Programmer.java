import java.util.Date;

public class Programmer extends Person {
public int yearsExperience;
public String mainTechnology;

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "yearsExperience=" + yearsExperience +
                ", mainTechnology='" + mainTechnology + '\'' +
                '}';
    }

    public Programmer(String name, Date birthDay, int yearsExperience, String mainTechnology){
    super(name,birthDay);
    this.yearsExperience=yearsExperience;
    this.mainTechnology=mainTechnology;

}
}
