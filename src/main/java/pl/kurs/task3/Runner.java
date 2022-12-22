package pl.kurs.task3;

public class Runner {
    public static void main(String[] args) {
        System.out.println(getFibbonacciIndex(8));
    }

    public static int getFibbonacciIndex(int number) {
        if (number == 0) {
            return 0;
        }

        return getFibbonacciIndexRecursion(number, 0, 1, 0);
    }
    public static int getFibbonacciIndexRecursion(int number, int previous, int current, int index) {
        if (number < previous || number < current)
            return -1;

        if (number == previous || number == current)
            return index;

        return getFibbonacciIndexRecursion(number, current, previous + current, index + 1);
    }
}
