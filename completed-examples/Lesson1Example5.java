public class Lesson1Example5 {
    public static void main(String[] args) {
        String saludo = "Hola, Java";
        int[] numeros = {1, 2, 3, 4, 5};

        System.out.println(saludo);
        System.out.println("Primer número: " + numeros[0]);
        System.out.println("Lista completa:");
        for(int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
}
