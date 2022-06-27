
package studentadmin;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.io.IOException;
import java.util.Scanner;


public class Operation {
    int user_id;
    HashMap<Integer,String>hm=new HashMap();
    int login_id;
    
   
    public int registerUser()      
    {
      try{   
        Scanner sc=new Scanner(System.in);
        System.out.println("**REGISTRATION**");
        System.out.print("Enter UserID : ");
         user_id=sc.nextInt();
        System.out.print("Enter Password : ");
        char c[]=System.console().readPassword();
        String password=new String(c);
        File f=new File("login.txt");
        if(f.exists())
          {
              FileInputStream fis=new FileInputStream(f);
              ObjectInputStream ois=new ObjectInputStream(fis);
              hm=(HashMap<Integer,String>)ois.readObject();
              while(hm.containsKey(user_id))
              {
                  System.out.println("User ID already exists!Please enter unique user id");
                  System.out.println("Enter user Id");
                  user_id=sc.nextInt();
              }
              ois.close();
              fis.close();
          }
        hm.put(user_id, password);
        FileOutputStream fos1=new FileOutputStream("login.txt");
        ObjectOutputStream oos1=new ObjectOutputStream(fos1);
        oos1.writeObject(hm);
        oos1.close();
        fos1.close();
        int roll=user_id;
        System.out.println("Enter the first name");
        String fname=sc.next();
        System.out.println("Enter the last name");
        String lname=sc.next();
        System.out.println("Enter the address");
        String addr=sc.next();
        System.out.println("Enter the branch");
        String branch=sc.next();
        System.out.println("Enter the semester");
        String sem=sc.next();
        System.out.println("Enter the contact number");
        String contact=sc.next();
        System.out.println("Enter Date of birth");
        String dob=sc.next();
        Student st=new Student(roll,fname,lname,addr,branch,sem,contact,dob);
        FileOutputStream fos=new FileOutputStream(roll+".txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(st);
        oos.close();
        fos.close();
        return 1;
}catch(Exception e)
{
    System.out.println("Registration "+e);
    return 2;
}   
    }
    
 
    public int loginUser()
       {
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter User Id");
          user_id=sc.nextInt();
          System.out.println("Enter Password");
          char c[]=System.console().readPassword();
          String password=new String(c);
          if((user_id==1001)&&(password.equals("rcpl@123")))
          {
              return 1;
          }
          
          HashMap<Integer,String>hm=new HashMap<>();
          try{
              File f=new File("login.txt");
              if(f.exists())
               {
                     FileInputStream fis=new FileInputStream(f);
                     ObjectInputStream ois=new ObjectInputStream(fis);
                     hm=(HashMap<Integer,String>)ois.readObject();
                     ois.close();
                     fis.close();
               }   
             if(hm.containsKey(user_id))
                 {
                    if(hm.get(user_id).equals(password))
                          return 2;
                 }
               
            }catch(Exception e)
                {
                   System.out.println(e);
                   return 3;     
                }
                  return 3;
       }
 
      public void showProfile()
              {
                  try{
                          FileInputStream fis2=new FileInputStream(user_id+".txt");
                          try (ObjectInputStream ois2 = new ObjectInputStream(fis2)) {
                            Student s=(Student)ois2.readObject();
                              s.showDetails();
                        }
                    }catch(Exception e)
                       {
                           System.out.println(e);
                       }
              }
  
        public void update()
             {
                try{  
                        Scanner sc=new Scanner(System.in);
                        System.out.println("Enter your user Id");
                        int roll=sc.nextInt();
                        File f=new File(roll+".txt");
      
                       if(f.exists())
                             {
                                System.out.println("**UPDATE**");
                                System.out.println("Enter the first name");                                 
                                String fname=sc.next();                              
                                System.out.println("Enter the last name");
                                String lname=sc.next();
                                System.out.println("Enter the address");
                                String addr=sc.next();
                                System.out.println("Enter the branch");
                                String branch=sc.next();
                                System.out.println("Enter the semester");
                                String sem=sc.next();
                                System.out.println("Enter the contact number");
                                String contact=sc.next();
                                System.out.println("Enter Date of birth");
                                String dob=sc.next();
                                Student st=new Student(roll,fname,lname,addr,branch,sem,contact,dob);
                                FileOutputStream fos=new FileOutputStream(roll+".txt");
                                ObjectOutputStream oos=new ObjectOutputStream(fos);
                                oos.writeObject(st);
                                System.out.println("**UPDATED**");
                                oos.close();
                                fos.close();      
                             }
                    }catch(IOException e)
                           {
                                System.out.println(e);
                           }
                }
  
               public void change() 
                   {
                       Scanner sc=new Scanner(System.in);
                       System.out.println("Enter  your user Id");
                       user_id=sc.nextInt();
                       HashMap<Integer,String>hm=new HashMap<>();
                       try{
                              File f=new File("login.txt");
                             if(f.exists())
                              { 
                                      FileInputStream fis=new FileInputStream(f);
                                      ObjectInputStream ois=new ObjectInputStream(fis);
                                      hm=(HashMap<Integer,String>)ois.readObject();
                                     
                                  
                                  if(hm.containsKey(user_id))
                                    {                                        
                                            System.out.println("Enter new password");
                                            char c[]=System.console().readPassword();
                                            String password=new String(c);
                                            hm.put(user_id, password);  
                                            FileOutputStream fos=new FileOutputStream("login.txt");
                                            ObjectOutputStream oos=new ObjectOutputStream(fos);
                                            oos.writeObject(hm);
                                            oos.close();
                                            fos.close();
                                            System.out.println("**PASSWORD CHANGED**");
                                            
                                    }
                                   ois.close();
                                   fis.close();
                                 
                              }
                          }catch(Exception e)
                          {
                              System.out.println(e);
                          }
                   }
              
               public void del()
               {
                   Scanner sc=new Scanner(System.in);
                   System.out.println("Enter the roll of student you want to delete");
                   user_id=sc.nextInt();
                   int roll=user_id;
                   File f=new File(roll+".txt");
                   if(f.exists())
                   {
                       f.delete();
                       System.out.println("**PROFILE DELETED**");
                   }
                   else
                   {
                       System.out.println("Student not registered");
                   }
               }
               public void showAll()
               {
                     try{
                        
                          File f1=new File("C:\\Users\\shrut\\OneDrive\\Documents\\NetBeansProjects\\StudentAdmin");
                          File f2[]=f1.listFiles();
                          for(File f3:f2)
                          {
                              if(f3.toString().endsWith(".txt"))
                              {
                                  FileInputStream fis=new FileInputStream(f3);
                                  ObjectInputStream ois=new ObjectInputStream(fis);
                                  Student st=(Student)ois.readObject();
                                  st.showDetails();
                                  ois.close();
                                  fis.close();
                              }
                         }
                        }catch(Exception e)
                            {
                                System.out.println(e);
                            }
               
                 }
               
               
             public void del1()
               {
                   try{
                   Scanner sc=new Scanner(System.in);
                   System.out.println("Enter your User ID");
                   user_id=sc.nextInt();                 
                   File f=new File(user_id+".txt");
                   f.delete();
                   hm.remove(user_id);
                   FileOutputStream fos=new FileOutputStream("login.txt");
                   ObjectOutputStream oos=new ObjectOutputStream(fos);
                   oos.writeObject(hm);
                   System.out.println("Student file deleted");
               }catch(Exception e)
               {
                   System.out.println(e);
               }
               }
             public void delAll()
             {
                       boolean z;
                       try{
                          File f=new File("C:\\Users\\shrut\\OneDrive\\Documents\\NetBeansProjects\\StudentAdmin");
                          File filelist[]=f.listFiles();
                          if(filelist!=null)
                          {                            
                          
                          for(File f1:filelist)
                          {
                              if(f1.toString().endsWith(".txt"))
                              {   
                                      if(f1.exists())
                                      {
                                          f1.delete();
                                      }
                                 
                              }
                           }
                          }
                          f=new File("C:\\Users\\shrut\\OneDrive\\Documents\\NetBeansProjects\\StudentAdmin\\build\\classes");
                          if(f.exists())
                          {
                            f.delete();
                          }
                              
                        }catch(Exception e)
                            {
                                System.out.println("cannot fetch details");
                            }
                  }
             public void recover()
             {
                 try{
                     Scanner sc=new Scanner(System.in);
                     System.out.println("Enter User id");
                     user_id=sc.nextInt();
                     HashMap<Integer,String>hm=new HashMap();
                     File f=new File("login.txt");
                     if(f.exists())
                     {
                         FileInputStream fis=new FileInputStream(f);
                         ObjectInputStream ois=new ObjectInputStream(fis);
                         hm=(HashMap<Integer, String>)ois.readObject();
                         if(hm.containsKey(user_id))
                         {
                             Object password=hm.get(user_id);
                             System.out.println("Password : "+password);
                             
                         }
                         ois.close();
                         fis.close();
                     }
                 }catch(Exception e)
                 {
                     System.out.println(e);
                 }
             }
                        
          }              
		  
		  
