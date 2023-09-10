package pruebaSuma;

import java.util.Scanner;

public class area {

    public static void main(String[] args) {
        // TODO code application logic here
        
        int base = 0;
        int altura = 0;
        int area = 0;
        
        Scanner miteclado = new Scanner(System.in);
        System.out.println("Digite la base del triángulo: ");
        base = miteclado.nextInt();
        
        System.out.println("Digite la altura del triángulo: ");
        altura = miteclado.nextInt();

        area = (base * altura) / 2;
        
        System.out.println("El área del triángulo es: " + area);
        
    }
     
}
