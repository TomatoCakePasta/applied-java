import java.io.Serializable;

public class Department implements Serializable {
    private String name;
    private Employee leader;

    public Department(String name, Employee leader) {
        this.name = name;
        this.leader = leader;
    }

    public String getDepartmentName() {
        return name;
    }

    public String getEmployee() {
        return "Name: " + leader.getName() + ", Age : " + leader.getAge();
    }
}