package lesson2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String value, int row, int col) {
        super("Неверные данные '" + value + "' в строка:" + row + " столбец:" + col);
    }
}
