package lesson3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float sum = 0;
        for (Fruit fruit : fruits) {
            sum = sum + fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> box) {
       return this.getWeight() == box.getWeight();
    }
    public void moveFruit(Box<T> box) {
        for (T fruit: fruits) {
            box.addFruit(fruit);
        }
        fruits.clear();
    }
}
