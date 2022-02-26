class Employee{
    String name;
    Long id;
    static String company = "BridgeLabz";

    Employee(String name,Long id,String company){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +", Company=" + company +
                '}';
    }

    static Long salary(){
        return 100000L;
    }
}



public class StaticImplementation {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Mohan",1234L,"BridgeLabz");
        Employee employee2 = new Employee("Raju",554321L,"Infosys");

        System.out.println(employee1.toString()+Employee.salary());
        System.out.println(employee2.toString()+Employee.salary());
    }
}
