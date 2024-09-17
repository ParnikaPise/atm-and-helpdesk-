import java.util.HashMap;
import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        ATMoperation ATMoperation = new ATMoperation();

    }
}

class Data{
    float balance;
}

class ATMoperation{

    Scanner sc=new Scanner(System.in);
    HashMap<Integer, Data> map=new HashMap<>();
    ATMoperation(){
        System.out.println("**************************************");
        System.out.println("Welcome to ATM");
        anotheraccount();
    }
    public void  anotheraccount(){
        System.out.println("**************************************");
        System.out.println("Enter your Pin");
        int pincode=sc.nextInt();

        if(map.containsKey(pincode)==true){
            Data obj=map.get(pincode);
            menu(obj);
            System.out.println("**************************************");
        }
        else {
            System.out.println("*******************************");
            System.out.println("Please Create Account");
            System.out.println("Set your pin");
            int pin=sc.nextInt();
            Data obj=new Data();
            map.put(pin , obj);
            menu(obj);
        }

    }

    public void menu(Data obj){
        System.out.println("**************************************");
        System.out.println("Please Enter valid number:");
        System.out.println("1.Check balance");
        System.out.println("2.Deposit money");
        System.out.println("3.Withdraw money");
        System.out.println("4.Check another account");
        System.out.println("5.Exit");

        int  x=sc.nextInt();


        if(x==1){
            check_balance(obj);
        } else if (x==2) {
            deposit(obj);
        } else if (x==3) {
            withdraw(obj);
        } else if (x==4) {
            anotheraccount();
        } else if (x==5) {
            System.out.println("Thankyou!!");
        }
        else {
            System.out.println("Enter Valid Number");
            menu(obj);
        }
    }
   public void check_balance(Data obj){
       System.out.println("**************************************");
       System.out.println("Your Balance"+obj.balance);

       menu(obj);
   }
   public void  deposit(Data obj){
       System.out.println("**************************************");
       System.out.println("Enter your Amount");
       float amount= sc.nextFloat();
       obj.balance=obj.balance+amount;
       System.out.println("Amount Deposited Successfully");

       menu(obj);
   }
   public void withdraw(Data obj){
       System.out.println("**************************************");
       System.out.println("Enter your Amount");
       float amount= sc.nextFloat();
       if(obj.balance>=amount) {
           obj.balance = obj.balance - amount;
           System.out.println("Amount Withdrawed Successfully");
       }else{
           System.out.println("Insuficient Balance!!!");
       }

       menu(obj);
        }


}