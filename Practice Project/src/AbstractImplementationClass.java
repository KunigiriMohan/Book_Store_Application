import java.lang.reflect.Array;

abstract class AbstractClass {
    abstract void abstractMethod();


    public static Object definedStaticMethod(){
        System.out.println("Static Defined Method in Abstract class");
        return new Array[0];
    }

    void abstractDefinedMethod(){
        System.out.println("public Declared method");
    }
}
class ExtendedClass extends AbstractClass{

    public static String definedStaticMethod() {
        return "Hello";
    }
    @Override
     void abstractMethod() {
        System.out.println("Abstract Method");
    }
}
public class AbstractImplementationClass{
    public static void main(String[] args){
        ExtendedClass extendedClass = new ExtendedClass();
        extendedClass.abstractMethod();
        extendedClass.abstractDefinedMethod();
        System.out.println(ExtendedClass.definedStaticMethod());

    }
}