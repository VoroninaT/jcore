package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[4][4];
        String[][] arr1 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arr2 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arr3 = {
                {"1", "2", "3"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arr4 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"AB", "2", "1", "4"},
                {"1", "2", "3", "2"}
        };
        try {
            int count = sumArrElements(arr4);
            System.out.println("Массив корректный, count=" + count);

        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Массив некорректный по размеру");

        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Массив некорректный по данным: " + e.getMessage());
        }
    }


    public static int sumArrElements(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(arr[i][j], i + 1, j + 1);
                }
            }

        }
        return count;
    }
}

