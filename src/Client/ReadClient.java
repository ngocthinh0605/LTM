/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author ngoct
 */



import Data.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadClient {
    private Socket socket;
    public static Student stu = null;
    public ReadClient(Socket socket){
        this.socket = socket;
    }
    
    public void Start(){
        try {
           
            try {
                stu = (Student) Client.ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Server Sent : "+ stu.getBirthplace());
        } catch (IOException ex) {
            Logger.getLogger(ReadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
