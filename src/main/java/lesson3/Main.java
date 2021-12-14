package lesson3;


public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        Box<Orange> emptyOrangeBox = new Box<>();

        System.out.println("appleBox weight: " + appleBox.getWeight());
        System.out.println("orangeBox weight: " + orangeBox.getWeight());

        System.out.println("Compare: " + orangeBox.compare(appleBox));

        orangeBox.moveFruit(emptyOrangeBox);



        // Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        Integer[] intArr = {1, 2, 23, 4, 5};
        Long[] longArr = {4L, 5L, 6L, 7L, 89L, 4L, 3L, 6L};

        swap(intArr, 1, 3);
        swap(longArr, 2, 4);

    }

    private static <T> void swap(T[] array, int firstIndex, int secondIndex) {
        T tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }


}


