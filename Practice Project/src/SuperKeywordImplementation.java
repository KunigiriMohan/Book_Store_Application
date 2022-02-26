class AnimalsSounds{
    String colour = " White ";
    public void display(){
        System.out.println("This is Animal Class");
    }

}
class Dog extends AnimalsSounds{
    void view(){
        System.out.println(super.colour);
        super.display();
    }
}
public class SuperKeywordImplementation {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.view();
    }
}
