class Vehicles {
    static Long value = 100L;
    public static Object vehicle(){
        System.out.println("This is the Vehicle Class");
        return Vehicles.value;
    }
    public Object allVehicles(){
        System.out.println("Parent Static method");
        return Vehicles.value;
    }
}
class FourWheelerVehicle extends Vehicles{

    public void bus(){
        System.out.println("This is Bus method");
    }
    public void car(){
        System.out.println("This is Car method");
    }
    public void van(){
        System.out.println("This is van method");
    }
    public static String vehicle(){
        System.out.println("This is overridden");
        return "Hi";
    }

    @Override
    public String allVehicles() {
        System.out.println("allVehicles methods overridden");
        return "Hello";
    }

    /*public  void vehicle(){
        System.out.println("This is bus");
    }*/

}

class ThreeWheelerVehicle extends Vehicles{
    public void auto(){
        System.out.println("This is Auto method");
    }
}

class TwoWheeler extends Vehicles {
    public void byke() {
        System.out.println("This is Byke mehtod");
    }

    public void cycle() {
        System.out.println("This is cycle method");
    }
}

public class MainClass{
    public static void main(String[] args){
        Vehicles fourWheeler = new FourWheelerVehicle();
        fourWheeler.vehicle();

        Vehicles threeVehicles = new ThreeWheelerVehicle();
        threeVehicles.vehicle();

        Vehicles twoVehicles = new TwoWheeler();
        twoVehicles.vehicle();

        System.out.println("--------------------------------");

        System.out.println("Four Wheeler Methods ");
        FourWheelerVehicle fourWheelerVehicle = new FourWheelerVehicle();
        fourWheelerVehicle.bus();
        fourWheelerVehicle.car();
        fourWheelerVehicle.van();
        FourWheelerVehicle.value=200L;
        Vehicles.vehicle();
        FourWheelerVehicle.vehicle();

    }
}