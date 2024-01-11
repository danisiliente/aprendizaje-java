package pruebaSuma;

import java.util.Scanner;

public class conversorMoneda {

    public static void main(String[] args) {
        // TODO code application logic here
        
        float dolarPeso = 4139.39f;
        float dolarEuro = 4609.38f;
        
        Scanner miteclado = new Scanner(System.in);
        System.out.println("Digite la cantidad de pesos para convertir a Dólares y Euros: ");
        float pesos = miteclado.nextFloat();
        
        float dolares = pesos / dolarPeso;
        float euros = pesos / dolarEuro;
        
        System.out.println("La cantidad de " + pesos + " pesos, equivale a: " + dolares + " dolares");
        System.out.println("La cantidad de " + pesos + " pesos, equivale a: " + euros + " euros");
    
    }

}
