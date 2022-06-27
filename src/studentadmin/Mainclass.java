
package studentadmin;

import java.util.Scanner;

    public class Mainclass {
    public static void main(String[] args) {
        try{
        Operation operation=new Operation();
        try (Scanner sc = new Scanner(System.in)) {
            while(true)
            {
                
                                    
                System.out.println("*****MENU*****");
                System.out.println("1 . LOGIN");
                System.out.println("2 . REGISTER");
                System.out.println("3 . EXIT");
                System.out.println("**************");
                System.out.print("ENTER CHOICE : ");
                int ch=sc.nextInt();
               
                switch(ch)
                {
                    case 1:
                            /*final String os=System.getProperty("os.name");
                             if(os.contains("Windows"))
                                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                             else
                                    Runtime.getRuntime().exec("clear");*/
                                    
                             int b=operation.loginUser();
                             boolean x=true;
                             if(b==1)
                               {
                                   while(x)
                                   {
                                       System.out.println("****ADMIN MENU****");
                                       System.out.println("1 . SHOW ALL");
                                       System.out.println("2 . DELETE ALL");
                                       System.out.println("3 . RECOVER USER PASSWORD");
                                       System.out.println("4 . DELETE A STUDENT");
                                       System.out.println("5 . LOGOUT");
                                       System.out.println("**************");
                                       System.out.println("Enter Choice");
                                       int choice=sc.nextInt();
                                       switch(choice)
                                       {
                                           case 1:
                                               operation.showAll();
                                               break;
                                           case 2:
                                               operation.delAll();
                                               break;
                                           case 3:
                                               operation.recover();
                                               break;
                                           case 4:
                                               operation.del();
                                               break;
                                           case 5:
                                               x=false;
                                               break;
                                           default:
                                               System.out.println("Enter correct choice");
                                               
                                       }
                                               
                                   }
                               }
                             else if(b==2)
                                {
                                 while(x)
                                    {
                                        System.out.println("****USER MENU****");
                                        System.out.println("1 . SHOW PROFILE");
                                        System.out.println("2 . DELETE PROFILE");
                                        System.out.println("3 . UPDATE PROFILE");
                                        System.out.println("4 . CHANGE PASSWORD");
                                        System.out.println("5 . LOGOUT");
                                        System.out.println("**************");
                                        System.out.println("Enter choice");
                                        int ch1=sc.nextInt();
                                        
                                        switch(ch1)
                                             {
                                       
                                               case 1:
                                                      operation.showProfile();
                                                      break;
                                               case 2:
                                                      operation.del1();
                                                      break;
                                               case 3:
                                                      operation.update();
                                                      break;
                                               case 4:
                                                      operation.change();
                                                      break;
                                               case 5:
                                                      x=false;
                                                      break;
                                               default:
                                                      System.out.println("Invalid Choice!Enter correct choice");
                                        
                                              }
                                         } 
                                     }
                    
                                  else
                                        {
                                            System.out.println("User Authentication problem !");
                                            break;
                                        }
                           break;
                
                 case 2:
                        int status=operation.registerUser();
                        if(status==1)
                           {
                                System.out.println("REGISTRATION DONE !!");
                           }
                        else if(status==2)
                           {
                                System.out.println("REGISTRATION FAILED !!");
                           }
                           break;
               case 3:
                        System.exit(1);
                        break;
               default:
                        System.out.println("Invalid choice : Try again");
                }
      
   }
        }
}catch(Exception e)
{
    System.out.println(e);
}
}
}   
    

