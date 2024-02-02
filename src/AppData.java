import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    //сохранение данных в csv файл
    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //записываем заголовок
            for (int i = 0; i < header.length; i++) {
                writer.append(header[i]);
                if (i < header.length - 1) {
                    writer.append(";");
                } else {
                    writer.append("\n");
                }
            }

            //записываем данные
            for (int[] datum : data) {
                for (int j = 0; j < datum.length; j++) {
                    writer.append(String.valueOf(datum[j]));
                    if (j < datum.length - 1) {
                        writer.append(";");
                    } else {
                        writer.append("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //загрузка данных из csv файла
    public static AppData load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            //читаем первую строку
            String[] header = reader.readLine().split(";");

            //определяем количество строк и столбцов в файле
            int numRows = 0;
            int numCols = header.length;
            while (reader.readLine() != null) {
                numRows++;
            }
            reader.close();

            //читаем данные
            int[][] data = new int[numRows][numCols];
            BufferedReader newReader = new BufferedReader(new FileReader(fileName)); //открываем файл снова, чтобы начать с самого начала
            newReader.readLine(); //пропускаем строку заголовка
            String line;
            int row = 0;
            while ((line = newReader.readLine()) != null) {
                String[] values = line.split(";");
                for (int i = 0; i < values.length; i++) {
                    data[row][i] = Integer.parseInt(values[i]);
                }
                row++;
            }
            return new AppData(header, data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {
                {100, 200, 123},
                {300, 400, 500},
                {40, 267, 1025}
        };
        AppData appData = new AppData(header, data);

        //сохраняем данные в файл
        appData.save("data.csv");

        //загружаем данные из файла
        AppData loadedData = AppData.load("data.csv");
        if (loadedData != null) {
            for (String element : loadedData.header) {
                System.out.print(element + "  ");
            }
            System.out.println();
            for (int[] row : loadedData.data) {
                for (int element : row) {
                    System.out.print(element + "  ");
                }
                System.out.println();
            }
        }
    }
}
