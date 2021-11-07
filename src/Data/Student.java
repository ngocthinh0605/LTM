/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;

/**
 *
 * @author ngoct
 */
public class Student implements Serializable{
    private String studenID;
//    private String key;
//    private String faculty; 
//    private String branch;
//    private String classs;
    private String nameStudent;
    private String sex;
    private String birthplace;
//    private String specialized;
//    private String educate;
//    private String course;
//    private String consultant;
//    private String birthday;
//    private String r1;
//    private String r2;
//    private String r3;
//    private String r4;
//    private String r5;
//    private String r6;
//    private String AllPoint;

    public Student(String studenID, String nameStudent, String sex, String birthplace) {
        this.studenID = studenID;
        this.nameStudent = nameStudent;
        this.sex = sex;
        this.birthplace = birthplace;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

   

    public Student() {
    }

    public String getStudenID() {
        return studenID;
    }

    public void setStudenID(String studenID) {
        this.studenID = studenID;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

  
}
