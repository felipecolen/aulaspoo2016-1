package calculoraio;

import java.util.Scanner;

/**
 *
 * @author felipe
 */
public class CalculoRaio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declarar duas variaveis. 
        double pi,raio,total;
        //pegar o valor do raio
        System.out.println("Digite o valor do raio:");
        Scanner valor = new Scanner(System.in);
        raio=valor.nextDouble(); 
        pi= 3.14;
//        total= 2*pi*raio;
        System.out.print("O total da area é igual ");
        System.out.println(2*pi*raio);
    }
    
}
