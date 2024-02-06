public class Main {
    //Этот метод не из дз
    //Его я сделал, чтобы поупражняться в алгоритмах
    public static boolean isDimensionCorrect (String[][] arrayToCheck) {
        boolean flag = false;
        if (arrayToCheck.length == 4) flag = true;
        for (int i = 0; i < arrayToCheck.length; i++) {
            if (arrayToCheck[i].length == 4) flag = true;
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int sumArrElements (String[][] array) throws RuntimeException {
        //Решение проверки размера массива в лоб проще и занимает меньше места
        //if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4)
        if (!isDimensionCorrect(array))
            throw new ArraySizeException("Размер массива должен быть 4х4");
        
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Неверные данные в элементе с индексами: [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
        };

        try {
            int result = sumArrElements(array);
            System.out.println("Сумма всех элементов массива: " + result);
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
