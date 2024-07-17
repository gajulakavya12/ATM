public class Intro{
    public static void main(String [] args){
        displayIntro();
        ATM obj=new ATM();
        obj.checkPin();
    }
    public static void displayIntro(){
        System.out.println("***************************************************************");
        System.out.println("            Welcome to the ATM Project !");
        System.out.println("***************************************************************");
    }
}