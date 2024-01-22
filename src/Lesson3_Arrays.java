import java.util.Arrays;

public class Lesson3_Arrays {
    //пункт 10
    public  static int[] createArray (int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return  array;
    }

    public static void main(String[] args) {

        //В выводе в консоли пункты разделены пустой строкой

        //пункт 6
        int[] array6 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array6));
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] % 2 == 0) array6[i] = 1;
            else array6[i] = 0;
        }
        System.out.println(Arrays.toString(array6));
        System.out.println();

        //пункт 7
        int[] array7 = new int[100];
        for (int i = 0; i < array7.length; i++) {
            array7[i] = i + 1;
        }
        System.out.println(Arrays.toString(array7));
        System.out.println();

        //пункт 8
        int[] array8 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array8.length; i++) {
            if (array8[i] < 6) array8[i] *= 2;
        }
        System.out.println(Arrays.toString(array8));
        System.out.println();
        
        //пункт 9
        int n = 7;
        int[][] array9 = new int[n][n];
        for (int i = 0; i < array9.length; i++) {
            for (int j = 0; j < array9[i].length; j++) {
                if(i == j) array9[i][j] = 1;
                if(j == array9[i].length - i - 1)
                    array9[i][array9[i].length - 1 - i] = 1;
                System.out.print(array9[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();

        //пункт 10
        int len = 5, initialValue = 3;
        System.out.println(Arrays.toString(createArray(len, initialValue)));
    }
}
