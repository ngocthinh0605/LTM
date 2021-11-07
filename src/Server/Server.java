/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.bcel.generic.AALOAD;

/**
 *
 * @author ngoct
 */
public class Server {
    private int port;
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    
    
    public Server(int port){
        this.port = port;
    }
    
    public void start(){
        try {
            serverSocket  = new ServerSocket(port);
            System.out.println("Server is running");
            
            socket = serverSocket.accept();
            
            ReadSocketServer read = new ReadSocketServer(socket);
            System.out.println("connnected "+ socket);

            read.start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Server server = new Server(9999);
        server.start();
       
    }
}
