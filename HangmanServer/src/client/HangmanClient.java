/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
    package client;

/**
 *
 * @author cl427511
 */

    import java.io.*;
    import java.net.*;
    import java.util.*;
     
    public class HangmanClient{
    
        public static void main(String argv[]){
            BufferedReader in = null;
            PrintStream out = null;
            Socket socket = null;
            String message;
            try{
            // open a socket connection
            socket = new Socket("192.168.2.139", 4000);
            // Apre i canali I/O
            in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream(), true);
            // Legge dal server
            message = in.readLine();
            System.out.print("Messaggio Ricevuto : " + message);
            out.close();
            in.close();
        }
        catch(Exception e) { System.out.println(e.getMessage());}
        }
    }