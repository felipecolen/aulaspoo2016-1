/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doprofessor;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author Jann
 */
public class Vota {
    public static void main(String[] args) {
    	// obtem a data e hora atuais
        LocalDate data = LocalDate.now();
                        
        System.out.println("Digite a sua data de Nascimento");
        System.out.println("no formato 01/01/1991");

        Scanner entrada = new Scanner(System.in);
        // a variavel dtnasc recebe o conteudo digitado        
        String dtnasc = entrada.nextLine();
        
        boolean verifica = VerificaClasseEleitoral(dtnasc, data);
        if(verifica){
            System.out.println("Você votou na última eleição?");
        }  
        else
            System.out.println("Tudo bem, amiguinho?");
        
    }
    public static boolean VerificaClasseEleitoral(String dtnasc, LocalDate data){
          // agora, a var do tipo vetor dtsplit, recebe a dtnasc digitada e dividida em 3 partes, 
        // o método split ira quebrar a string sempre que houver o /
        String[] dtsplit = dtnasc.split("/");

        // para calcular corretamente, precisamos verificar se temos realmente uma data no padrão 01/01/1991
        // se sim, então temos um vetor com 3 casas
        if (dtsplit.length == 3) {        
	        // agora, usando a mesma variavel que recebeu a data digitada
	        // alteramos a ordem do conteúdo para o padrão americano "ano-mês-dia"
	        dtnasc = dtsplit[2] +"-"+ dtsplit[1] +"-"+ dtsplit[0];		
	        
	        // para que possamos calcular a idade, por meio da Period, criamos uma variavel do tipo LocalDate
	        // passando a data que foi digitada e ajustada 
	        LocalDate datanasc = LocalDate.parse(dtnasc);

	        // agora, com o método between (tradução "entre"), 
	        // temos o período no intervalo entre a data de nascimento e a data atual
	        Period idade = Period.between(datanasc, data);
	        
	        // exibimos a idade completa
	        System.out.println("Sua idade é " + idade.getYears() + " anos, "
	        		+ idade.getMonths() + " meses" 
	        		+ " e " + idade.getDays() + " dias.");
	        int anos = idade.getYears();
	        
	        if (anos < 0) {
	        	System.out.println("Data de nascimento inválida.");
	        }
	        else if (anos >= 16 && anos < 18 || anos >= 65) {
	            System.out.println("Voto facultativo!");
                    return true;
	        }
	        else if (anos >= 18 && anos < 65) {
	            System.out.println("Voto obrigatório!");
                   return true;
	        } 
	        else {
	            System.out.println("Desculpe, você não pode votar!");
	        }
	    }
	    // se não, pedimos para digitar novamente
	    else {
	    	System.out.println("Favor digitar a data de nascimento no padrão 01/01/1991.");
	    }  
        return false;
    }
}
