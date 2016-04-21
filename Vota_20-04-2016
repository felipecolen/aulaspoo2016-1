import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class Vota {

    public static void main(String[] args) {

        LocalDate data = LocalDate.now();
                        
        System.out.println("Digite a data de Nasc: ");
        Scanner entrada = new Scanner(System.in);
                
        String dtnasc = entrada.nextLine();
        String[] dtsplit;  
        dtsplit = dtnasc.split("/");
        dtnasc = dtsplit[2] +"-"+ dtsplit[1] +"-"+ dtsplit[0];		
        LocalDate datanasc = LocalDate.parse(dtnasc);
        Period idade = Period.between(datanasc, data);
        
        System.out.println("Sua idade é " + idade.getYears() + " anos, "
        		+ idade.getMonths() + " meses" 
        		+ " e " + idade.getDays() + " dias.");
        int anos = idade.getYears();
        if (anos >= 16 && anos < 18 || anos >= 65) {
            System.out.println("Voto facultativo! Idade informada: " + anos);
        }
        else if (anos >= 18 && anos < 65) {
            System.out.println("Voto obrigatório! Idade informada: " + anos);
        } 
        else {
            System.out.println("Desculpe, você não pode votar! Idade informada: " + anos);
        }
    }
}
