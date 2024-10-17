package nurse;

import java.sql.*;
import java.util.Scanner;

public class Nurse {
    Scanner sc = new Scanner (System.in);
    config cf= new config();
    
    public static void main(String[] args) {
    String res;
    Scanner sc = new Scanner (System.in);
    
        do{
        System.out.println("------------ NURSE APP ---------------");
        System.out.print("1. ADD"
                + "\n2. VIEW"
                + "\n3. UPDATE"
                + "\n4. DELETE"
                + "\n5. EXIT"
                + "\nEnter action: ");
        int act = sc.nextInt();
        System.out.println("--------------------------------------");
        Nurse ns = new Nurse();
        
        switch(act){
            case 1:
                ns.addNurse();
            break;
            
            case 2:
                ns.viewNurse();
            break;
            
            case 3:
                ns.viewNurse();
                ns.updateNurse();
                ns.viewNurse();
            break;
            
            case 4:
                ns.viewNurse();
                ns.deleteCustomer();
                ns.viewNurse();
            break;
            
            case 5:
                System.out.println("Exit.");
                System.exit(0);
            break;
            
            default:
                System.out.println("INVALID");
        }
        
         System.out.println("Still want to continue(y/n)?: ");
         res = sc.next();
         
     }while(res.equals("y") || res.equals("Y"));
        System.out.println("Cge Thank You!.");
    }
    
    public void addNurse(){
        System.out.print("First Name: ");
        String fn = sc.next();
        
        System.out.print("Last Name: ");
        String ln = sc.next();
        
        System.out.print("Department: ");
        String add = sc.next();
        
        System.out.print("Contact Number: ");
        int con = sc.nextInt();
        
        System.out.print("Shift ( Day or Night ): ");
        String gen = sc.next();
        
        String sql = "Insert Into Nurse (First_Name, Last_Name, Department, Contact_Number, Shift) Values (? ,? , ? , ? , ?)";
        
        cf.addRecord(sql , fn, ln, add, con, gen);
    }
    
    public void viewNurse(){
        String votersQuery = "SELECT * FROM Nurse";
        String[] votersHeaders = {"ID", "First_Name", "Last_Name", "Department", "Contact_Number", "Shift"};
        String[] votersColumns = {"Id", "First_Name", "Last_Name", "Department", "Contact_Number", "Shift"};

        cf.viewRecords(votersQuery, votersHeaders, votersHeaders);
    }
    
    public void updateNurse(){
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        
        System.out.print("New First Name: ");
        String nfn = sc.next();
        System.out.print("New Last Name: ");
        String nln = sc.next();
        System.out.print("New Department: ");
        String nadd = sc.next();
        System.out.print("New Contact Number: ");
        int ncon = sc.nextInt();
        System.out.print("New Shift ( Day or Night ): ");
        String ngen = sc.next();
        
        String qry = "UPDATE Nurse SET First_Name = ?, Last_Name = ?, Department = ?, Contact_Number = ?, Shift = ? Where ID = ?";
        
        cf.updateRecord(qry, nfn, nln, nadd, ncon, ngen, id);
    }
    
    private void deleteCustomer () {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM Nurse WHERE ID = ?";
        
        cf.deleteRecord(qry, id);
    }
}
