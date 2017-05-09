/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import com.sun.corba.se.spi.activation.Server;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class HangmanServer extends Thread{

    private final ServerSocket Server;
    
    public static void main(String[] args) throws Exception{
        new HangmanServer();
    }
    
    public HangmanServer() throws Exception
    {
        Server = new ServerSocket(4000);
        System.out.println("Il Server è in attesa sulla porta 4000.");
        this.start();
    }
    
    /**
     *
     */
    @Override
    public void run()
    {   
        //Avvenuta la connessione con un client gli crea la Socket
        while(true){
    
            try {
                System.out.println("In attesa di Connessione.");
                Socket client = Server.accept();
                System.out.println("Connessione accettata da: "+
                client.getInetAddress());
                Connect c = new Connect(client);
            }
            catch(Exception e) {}
        }
    }
}
