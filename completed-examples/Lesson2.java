// Example 1
public class IfElseExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read one integer from input
        System.out.print("Ingresa un número entero: ");
        int x = sc.nextInt();

        // If–else: check parity (even/odd)
        if (x % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }

        sc.close();
    }
}

// Example 2
public class ForExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read n and print 1..n using a for loop
        System.out.print("Ingresa n para imprimir del 1 al n: ");
        int n = sc.nextInt();

        // Classic for: init; condition; update
        for (int i = 1; i <= n; i++) {
            System.out.println(i); // print current counter
        }

        sc.close();
    }
}

// Example 3
public class WhileExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read integers until 0; count how many are positive
        System.out.println("Ingresa enteros; termina con 0. Contaremos cuántos son positivos.");
        int positivos = 0;

        // Read the first value before entering the while-loop
        int value = sc.nextInt();

        // Repeat while the condition holds (value != 0)
        while (value != 0) {
            // Decision inside the loop
            if (value > 0) {
                positivos++; // increase counter if positive
            }

            // Update the control variable to avoid infinite loops
            value = sc.nextInt();
        }

        System.out.println("Cantidad de positivos: " + positivos);

        sc.close();
    }
}
