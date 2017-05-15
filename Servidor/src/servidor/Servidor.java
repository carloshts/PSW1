/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ra21605876
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ServerSocket server = null;
  try {
             server = new ServerSocket( 1234 );  //Cria um novo Socket na porta informada

        while(true) {

         	Socket socket = server.accept();  //Interrompe a execu��o esperando um cliente
                
                
                
 //Prepara as classes para leitura dos dados
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isReader = new InputStreamReader( inputStream );
            BufferedReader inputReader = new BufferedReader( isReader );


            System.out.println("Enviado pelo cliente:");
            System.out.println("----------------------------------");

            //L� os dados at� o fim
            String lido = null;
            boolean frita = false;
            do{
                lido = inputReader.readLine();
                if(lido.indexOf("frita")>0)frita=true;
                
            
            }while(!lido.equals(""));
            System.out.println(lido); //Exibe o que foi recebido na tela

            System.out.println("----------------------------------");
            System.out.println("Fim do conteudo enviado pelo cliente.");
    
            
            
              
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter outputWriter =
                    new PrintWriter(
                            new OutputStreamWriter( outputStream ));
            outputWriter.println("HTTP/1.0 302 ok");
            outputWriter.println("Location: http://wohuuu.com");
            if(frita){
                outputWriter.println("Evite frituras");
            } else {
                outputWriter.println("OH O GAAAAAS");
            }
            outputWriter.println(); // The empty line

            

            outputWriter.close();

            
            
           
                socket.close();
                
                
                
                

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
}
