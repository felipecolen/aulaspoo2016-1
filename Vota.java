package doprofessor;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/*
 * @author Jann
ADICIONADO:
    - Pedido de nome;
    - Contagem de regulares e irregulares
    - Rodar mais de uma vez caso o usuário queira
    - Comentários super explicativos; Heheh~ 
 */
public class Vota {
    public static void main(String[] args) {
    	// obtem a data e hora atuais
        LocalDate data = LocalDate.now();
        String fazer = "sim";   
        int irr =0, reg=0; 
        String verif = "", nome = "";
        Scanner entrada = new Scanner(System.in);   
        
        //Verificar se a pessoa gostaria de fazer novamente após fazer
        //pela primeira vez
        while(fazer.equals("sim")){
            //Nome do meliante
            System.out.println("Entre com seu nome: ");
            nome = entrada.nextLine();
            //Idade da pessoa
            System.out.println("\nDigite a sua data de Nascimento");
            System.out.println("no formato 01/01/1991");
            String dtnasc = entrada.nextLine();
            //Faz uso da classe boleana verifica          
            boolean verifica = VerificaClasseEleitoral(dtnasc, data);
            //Caso o resultado de verifica for TRUE, vai executar o if abaixo
            if(verifica){
                System.out.println("\nVocê votou na última eleição, " + nome + 
                        "? \n Digite sim ou nao");
                verif = entrada.nextLine();
                //Comparação de respostas
                //caso for sim, irá incrementar a variável reg, que serve
                //como contagem para os regulares
                if(verif.equals("sim"))
                    reg++;
                //Tentei fazer verif.equals("não") só que mesmo respondendo não,
                //ele não cai nesse else if
                //caso a resposta for nao, irá incrementar a variável irr
                //que é a contagem para os irregulares
                else if(verif.equals("nao"))
                    irr++;
                //SE o usuário não digitar sim ou nao... irá cair no else
                //que irá pedir para ele digitar conforme o pedido
                else
                    System.out.println("Digite conforme pedido");
            }  
            //Caso resposta da classe for FALSE, irá cair neste else
            else
                System.out.println("Tudo bem, amiguinho?");
            
            //Aqui a variável 'fazer' irá receber fim ou sim
            //Caso receba fim, irá sair do laço do WHILE
            System.out.println("\nGostaria de fazer de novo? \n Digite sim caso"
                    + " queira \n Digite fim caso não queira\n");
            fazer = entrada.nextLine();
        }
        //Finalizando o aplicativo, agradecemos o uso pelo mesmo e indicamos a
        //quantidade de regulares e irregulares 
        System.out.println("\n Agradecemos por usar nosso sistema! "
                + "\n Quantidade de regulares = " + reg + 
                " \n quantidade de irregulares = " + irr);
    }
    public static boolean VerificaClasseEleitoral(String dtnasc, LocalDate data){
        // agora, a var do tipo vetor dtsplit, recebe a dtnasc digitada e dividida em 3 partes, 
        // o método split ira quebrar a string sempre que houver o /
        
        //o MÉTODO SPLIT irá quebrar a String DTNASC nas partes que envolver
        //a barra ( / ), se o usuário digitar sua data corretamente
        //o vetor DTSPLIT irá receber três valores em cada posição
        //posição 0 recebe o dia : dtsplit[0]
        //posição 1 recebe o mês : dtsplit[1]
        //posição 2 recebe o ano : dtsplit[2]
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
	        
                //Calculo para descobrir se o voto é obrigatorio, facultativo ou
                //que não precisa votar
                
                /* AQUI É UMA PARTE MUITO IMPORTANTE, leia e releia para compreender
                Como o nosso método retorna tipo BOOLEAN então só poderá retornar
                TRUE ou FALSE. Note que nem todos os if, else if e else estão retornando
                algo, simplesmente não há necessidade porque existe um RETURN FALSE
                após todas as verificações.
                CASO a variável 'anos' atenda uma das comparações que retornam TRUE
                irá automaticamente sair DESTE MÉTODO, voltando para o principal 
                e retornando TRUE;
                CASO a variável 'anos' não atenda as comparações citadas, o método
                irá continuar funcionando ATÉ achar um 'return', que no caso será
                o RETURN FALSE do fim.
                */
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
