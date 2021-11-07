/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngoct
 */
public class Client {
    private String host;
    private int port;
    public static Socket socketOfClient;
    public static BufferedWriter out = null;
    public static ObjectInputStream ois = null;
//    public static BufferedReader in = null;
    public Client(String host, int port){
        this.host = host;
        this.port = port;
    }
    
    public void excute(){
        try {
            socketOfClient = new Socket(host, port);
            System.out.println("Connected");
            InputStream is = socketOfClient.getInputStream();
            ois = new ObjectInputStream(is);
//            in = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
                
            out = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
