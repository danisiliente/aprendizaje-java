package pruebaSuma;

import java.util.Scanner;

public class pruebaSuma {

    public static void main(String[] args) {
        // TODO code application logic here
        
        int numero1 = 0;
        int numero2 = 0;
        int numero3 = 0;
        
        Scanner miteclado = new Scanner(System.in);
        System.out.println("Digite el primer número: ");
        numero1 = miteclado.nextInt();
        System.out.println("Usted digitó: " + numero1);
        
        System.out.println("Digite el segundo número: ");
        numero2 = miteclado.nextInt();
        System.out.println("Usted digitó: " + numero2);
        
        System.out.println("Digite el segundo número: ");
        numero3 = miteclado.nextInt();
        System.out.println("Usted digitó: " + numero3);
        
        int resuma = numero1 + numero2 + numero3;
        System.out.println("La suma es igual a: " + resuma);
        
        int reresta = numero1 - numero2 - numero3;
        System.out.println("la resta es igual a: " + reresta);
        
        int remultiplicacion = numero1 * numero2 * numero3;
        System.out.println("la multiplicación es igual a: " + remultiplicacion);
        
        int redivision = numero1 / numero2 / numero3;
        System.out.println("la división es igual a: " + redivision);
        
    }

}
