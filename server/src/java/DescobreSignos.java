
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class DescobreSignos {
     public static Signo verificaSigno(String data){
        
// Define formato para validação da data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        try {
            // Validaação da Data de Nascimento
            Date dData = sdf.parse(data);
            
            // Seleciona o dia da Data de Nascimento
            String sDia = data.substring(0, 2);
            int dia = Integer.parseInt(sDia);
            
            // Seleciona o mês da Data de Nascimento
            String mes = data.substring(3, 5);

                if ( (mes.equals("01") && dia >= 21) ||
                     (mes.equals("02") && dia <= 19) ) return Signo.AQUARIO;
                if ( (mes.equals("02") && dia >= 20) ||
                     (mes.equals("03") && dia <= 20) ) return Signo.PEIXES;        
                if ( (mes.equals("03") && dia >= 21) ||
                     (mes.equals("04") && dia <= 20) ) return Signo.ARIES; 
                if ( (mes.equals("04") && dia >= 21) ||
                     (mes.equals("05") && dia <= 20) ) return Signo.TOURO;         
                if ( (mes.equals("05") && dia >= 21) ||
                     (mes.equals("06") && dia <= 20) ) return Signo.GEMEOS;   
                if ( (mes.equals("06") && dia >= 21) ||
                     (mes.equals("07") && dia <= 21) ) return Signo.CANCER;
                if ( (mes.equals("07") && dia >= 22) ||
                     (mes.equals("08") && dia <= 22) ) return Signo.LEAO;  
                if ( (mes.equals("08") && dia >= 23) ||
                     (mes.equals("09") && dia <= 22) ) return Signo.VIRGEM;  
                if ( (mes.equals("09") && dia >= 23) ||
                     (mes.equals("10") && dia <= 22) ) return Signo.LIBRA;  
                if ( (mes.equals("10") && dia >= 23) ||
                     (mes.equals("11") && dia <= 21) ) return Signo.ESCORPIAO;  
                if ( (mes.equals("11") && dia >= 22) ||
                     (mes.equals("12") && dia <= 21) ) return Signo.SAGITARIO;  
                if ( (mes.equals("12") && dia >= 22) ||
                     (mes.equals("01") && dia <= 20) ) return Signo.CAPRICORNIO;  
        } catch(Exception e) {
           e.printStackTrace();
        }
        return null;
    } 
}
