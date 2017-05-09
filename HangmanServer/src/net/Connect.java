/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author cl427511
 */
public class Connect extends Thread{
    private Socket client = null;
    BufferedReader in = null;
    PrintStream out = null;
    public Connect() {}
    public Connect(Socket clientSocket){
        client = clientSocket;
        try{
            in = new BufferedReader(
            new InputStreamReader(client.getInputStream()));
            out = new PrintStream(client.getOutputStream(), true);
        }
        catch(Exception e1){
            try { client.close(); }
            catch(Exception e) { System.out.println(e.getMessage());}
            return;
        }
        this.start();
    }
    
    @Override
    public void run(){
        try{
            out.println("Generico messaggio per il Client");
            out.flush();
            // chiude gli stream e le connessioni
            out.close();
            in.close();
            client.close();
        }
        catch(Exception e) {}
    }
}