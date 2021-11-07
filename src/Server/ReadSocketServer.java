/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.Send;
import Data.DataWeb;
import Data.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngoct
 */
public class ReadSocketServer {
    
    private Socket socket;
    public static BufferedReader in = null;
//    public static BufferedWriter out = null;
    private String c = null;
    
    public ReadSocketServer(Socket socket){
        this.socket = socket;
    }
    
    public void start(){
        try {
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
//            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true){
                c = in.readLine();
                System.out.println("server receive "+ c);
                DataWeb dataweb = new DataWeb(c);
                Student stu = dataweb.getOneStudentInfo(c);
                
                System.out.println("tesst "+ stu.getNameStudent());
                
//                out.write("server sent " + dataweb.stu.getNameStudent());
//                out.write("server sent " + dataweb.stu.getBirthplace());
//                out.newLine();
//                out.flush();
//                System.out.println("server " + dataweb.stu.getNameStudent());
                oos.writeObject(stu);
                if(c.equals("exit")){
                    System.out.println("Server disconnected!!");
                    in.close();
                    oos.close();
                    socket.close();
                    break;
                }
            }
        } catch (IOException ex) {
            
            try {
                Logger.getLogger(ReadSocketServer.class.getName()).log(Level.SEVERE, null, ex);
                socket.close();
            } catch (IOException ex1) {
                System.out.println("Disconnected");
                Logger.getLogger(ReadSocketServer.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    
}
