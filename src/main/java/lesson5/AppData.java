package lesson5;

import java.util.Arrays;

public class AppData {

    private String[] header;
    private int[][]  data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public AppData() {

    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        System.out.println();
        System.out.println("Заголовок: ");
        System.out.println(Arrays.toString(header));
        System.out.println();
        System.out.println("Данные: ");
        printData(data);
        System.out.println();
        return super.toString();
    }


    private void printData(int[][] data) {
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }
    }
}
