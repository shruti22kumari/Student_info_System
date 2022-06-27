
package studentadmin;

import java.io.Serializable;

import java.io.Serializable;

public class Student implements Serializable {
    private int roll;
    private String fname;
    private String lname;
    private String addr;
    private String branch;
    private String sem;
    private String contact;
    private String dob;
    public Student (int roll,String fname,String lname,String addr,String branch,String sem,String contact,String dob)
    {
        this.roll=roll;
        this.fname=fname;
        this.lname=lname;
        this.addr=addr;
        this.branch=branch;
        this.sem=sem;
        this.contact=contact;
        this.dob=dob;
    }
    public void showDetails()
    {
        System.out.println("____________________________________________________");
        System.out.println("ROLL NUMBER : "+roll);
        System.out.println("FIRST NAME : "+fname);
        System.out.println("LAST NAME : "+lname);
        System.out.println("ADDRESS : "+addr);
        System.out.println("BRANCH : "+branch);
        System.out.println("SEMESTER : "+sem);
        System.out.println("CONTACT NUMBER : "+contact);
        System.out.println("DATE OF BIRTH : "+dob);
        System.out.println("____________________________________________________");
    }

}