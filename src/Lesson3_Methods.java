public class Lesson3_Methods {

    //1 пункт
    public static boolean sumIsFrom10To20 (int firstInt, int secondInt) {
        if (firstInt + secondInt > 10 && firstInt + secondInt <= 20) return true;
        else return false;
        /* В задании не написано, что нужно включить 10 в нужный интервал
           поэтому я сделал условие строго больше 10 */
    }

    //2 пункт
    public static void printSignOfNumber (int intToCheck){
        if (intToCheck >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    //3 пункт
    public static boolean numberIsNegative (int numberToCheck) {
        return numberToCheck < 0;
    }

    //4 пункт
    public static void printTextSeveralTimes (String textToPrint, int timesToPrint) {
        if (timesToPrint > 0) {
            for (int i = 0; i < timesToPrint; i++) {
                System.out.println(textToPrint);
            }
        } else System.out.println("Введите число больше 0");
    }

    //5 пункт
    public static boolean isItLeapYear (int yearToCheck) {
        boolean leapYear;
        leapYear = yearToCheck % 4 == 0 && yearToCheck % 100 != 0
                || yearToCheck % 400 == 0;
        return leapYear;
    }

    public static void main(String[] args) {
        //1 пункт
        System.out.println("1 пункт : " + sumIsFrom10To20(10,10));
        //2 пункт
        System.out.print("2 пункт : ");
        printSignOfNumber(-5);
        //3 пункт
        System.out.println("3 пункт : " + numberIsNegative(1));
        //4 пункт
        System.out.println();
        printTextSeveralTimes("Hello", 2);
        System.out.println();
        //5 пункт
        System.out.println("5 пункт : " + isItLeapYear(1200));
    }
}
