/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngoct
 */
public class DataWeb {
    private String id;
    public static Student stu;

    public DataWeb(String id, Student stu) {
        this.id = id;
        this.stu = stu;
    }
    
    public DataWeb() {
        this.id = null;
    }
    public DataWeb(String id) {
        this.id = id;
    }
    
    public DataWeb(Student stu){
        this.stu= stu;
    }
    
    public Student getOneStudentInfo(String id){
        stu = new Student();
        try {
           
            if (id == null) {
                throw new Error("Missing ID Student");
            }
            final WebClient webClient = new WebClient();
            final URL url = new URL("http://thongtindaotao.sgu.edu.vn/default.aspx?page=nhapmasv&flag=XemDiemThi");
            // turn off warning html unit
            java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.setCssErrorHandler(new SilentCssErrorHandler());
            
            
            
            try {
                final HtmlPage page = webClient.getPage(url);
                
                HtmlInput searchMSSV = (HtmlInput) page.getElementById("ctl00_ContentPlaceHolder1_ctl00_txtMaSV");
                searchMSSV.type(id);
                stu.setStudenID(id);
                System.out.println("search mssv"+ searchMSSV);
                
                
                HtmlInput submitDataMssv = (HtmlInput) page.getElementById("ctl00_ContentPlaceHolder1_ctl00_btnOK");
                HtmlPage inforStudent =  submitDataMssv.click();
                
                HtmlSpan nameStudent = (HtmlSpan) inforStudent.getElementById("ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblTenSinhVien");
                System.out.println("name " + nameStudent.asXml());
                stu.setNameStudent(nameStudent.asText());
                
                HtmlSpan sex = (HtmlSpan) inforStudent.getElementById("ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblPhai");
                stu.setSex(sex.asText());
                
                HtmlSpan birthplace = (HtmlSpan) inforStudent.getElementById("ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblNoiSinh");
                stu.setBirthplace(birthplace.asText());
                
                
                
                

                
                DomNodeList<DomNode> listNameSubjectAndPoint = inforStudent.querySelectorAll(".row-diemTK .Label");
                
                for (DomNode nameSubjectAndPoint : listNameSubjectAndPoint) {
                      
//                      System.out.println("list" + nameSubjectAndPoint.asText());
                      if(nameSubjectAndPoint.getIndex() % 2 != 0) {
                          System.out.println("if "+nameSubjectAndPoint.asText());
                          System.out.println("line "+ nameSubjectAndPoint.getEndLineNumber());
                      }
//                    if(nameSubjectAndPoint.getIndex() % 2 != 0) {
//                        //System.out.print(" - "+nameSubjectAndPoint.asText());
//                        if(nameSubjectAndPoint.getEndLineNumber()==11){
//                            stu.setR1(nameSubjectAndPoint.asText()); 
//                        }
//                        if(nameSubjectAndPoint.getEndLineNumber()==9){
//                            stu.setR2(nameSubjectAndPoint.asText());
//                        }
//                        if(nameSubjectAndPoint.getEndLineNumber()==7){
//                            stu.setR3(nameSubjectAndPoint.asText());                           
//                        }
//                        if(nameSubjectAndPoint.getEndLineNumber()==5){
//                            stu.setR4(nameSubjectAndPoint.asText());                           
//                        }
//                        if(nameSubjectAndPoint.getEndLineNumber()==3){
//                            stu.setR5(nameSubjectAndPoint.asText());                            
//                        }
//                        if(nameSubjectAndPoint.getEndLineNumber()==1){
//                            stu.setR6(nameSubjectAndPoint.asText());                            
//                        }
//                    }
                }
                
            } catch (IOException | FailingHttpStatusCodeException ex) {
                Logger.getLogger(DataWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(DataWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stu;
    }
    
    public static void main(String[] args) {
    }
    
}
