public class Main
{
    public static int add(int a, int b) {
        return a + b;
    }

    public static void showSum(int a, int b) {
        System.out.println("The sum is: " + (a + b));
    }

    public static double calculateAverage(double x, double y, double z) {
        return (x + y + z) / 3.0;
    }

    public static void main(String[] args) {
        
        int num1 = 5;
        int num2 = 7;
        int result = add(num1, num2);
        System.out.println("Result of add: " + result);

        showSum(10, 20);

        double avg = calculateAverage(6.0, 8.0, 10.0);
        System.out.println("Average: " + avg);
    }
}
