package Discussion461B;

/**
 * Created by davidwang on 3/3/15.
 */
public class Cat extends Animal {

    public Cat(String name, int age){

        super(name, age);
        this.noise = "Meow!";

    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + "says: " + makeNoise());
    }
}
