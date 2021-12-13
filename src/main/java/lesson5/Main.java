package lesson5;

import java.io.*;

public class Main {

    public static final String SEPARATOR = ";";
    public static final String FILE_PATH = "src/main/java/file.csv";

    public static void main(String[] args) throws Exception {

        AppData appData = new AppData();

        // данные для записи в файл
        String[] header = new String[3];    // 3 столбца
        header[0] = "NewValue1";
        header[1] = "NewValue2";
        header[2] = "NewValue3";

        int[][] data = new int[2][header.length]; // 2 строки
        data[0][0] = 111;
        data[0][1] = 222;
        data[0][2] = 333;
        data[1][0] = 444;
        data[1][1] = 555;
        data[1][2] = 777;

        // заполняем поля объекта данных для записи
        appData.setHeader(header);
        appData.setData(data);

        // записываем изменения в файл
        writeFile(appData);

        // читаем файл в объект
        AppData fileData = readFile();

        System.out.println("Результат чтения файла: " + fileData);

    }

    private static void writeFile(AppData fileData) {
        FileWriter     fw = null;
        BufferedWriter bw = null;
        PrintWriter    pw = null;

        try {
            // открываем файл на запись
            fw = new FileWriter(Main.FILE_PATH, false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            // пишем заголовок
            String[] header     = fileData.getHeader();
            int      headerSize = header.length;

            String joinedHeader = String.join(SEPARATOR, header);
            pw.println(joinedHeader);

            // пишем данные построчно
            int[][] data = fileData.getData();
            for (int[] rowArray : data) {

                // строку для записи формируем в цикле
                StringBuilder rowString = new StringBuilder();
                for (int j = 0; j < headerSize; j++) {
                    rowString.append(rowArray[j]).append(SEPARATOR);
                }
                pw.println(rowString);
            }
            System.out.println("Файл записан: " + Main.FILE_PATH);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static AppData readFile() throws Exception {
        BufferedReader    br  = null;
        InputStreamReader isr = null;
        FileInputStream   fis = null;
        try {

            // открываем файл на чтение
            File file = new File(Main.FILE_PATH);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            // читаем заголовок
            String   fileHeader   = br.readLine();
            String[] header       = fileHeader.split(SEPARATOR);
            int      columnsCount = header.length;    // размер заголовка, мы не будем читать больше столбцов чем в заголовке

            // создаем временный большой массив и читаем в него числа построчно
            // ведь мы не знаем сколько строк в файле до того как его прочитаем
            int[][] temporaryArray = new int[65000][columnsCount];

            int    rowsCount = 0; // количество прочитанных строк
            String fileRow;

            while ((fileRow = br.readLine()) != null) {
                String[] row = fileRow.split(SEPARATOR);

                for (int columnIndex = 0; columnIndex < columnsCount; columnIndex++) {

                    String cellValue = row[columnIndex];
                    temporaryArray[rowsCount][columnIndex] = Integer.parseInt(cellValue);
                }
                rowsCount++;
            }

            // создаем массив для данных нужного размера
            int[][] data = new int[rowsCount][columnsCount];

            // копируем временный массив в нормальный
            for (int i = 0; i < rowsCount; i++) {
                System.arraycopy(temporaryArray[i], 0, data[i], 0, columnsCount);
            }
            return new AppData(header, data);

        } catch (IOException ioe) {
            System.out.println("Ошибка IOException: " + ioe.getMessage());
            throw ioe;
        } catch (NumberFormatException nfe) {
            System.out.println("Ошибка парсинга: " + nfe.getMessage());
            throw nfe;
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
            e.printStackTrace();
            throw e;

        } finally {
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }


}

