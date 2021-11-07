/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngoct
 */
public class Send {
    private Socket Socketofclient;
    private String input;
    public Send(Socket Socketofclient, String input) {
        this.Socketofclient = Socketofclient;
        this.input = input;
    }
    
    public void start(){
        try {
            Client.out.write(input);
            Client.out.newLine();
            Client.out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
