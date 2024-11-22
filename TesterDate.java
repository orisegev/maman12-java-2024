import java.util.Scanner;
public class TesterDate
{
    public static void main(String [] args)
    {
        /*
        for (int i = 0; i < 5; i++)
        {
            Scanner myObj = new Scanner(System.in);      
            System.out.println("enter day:");
            int d = myObj.nextInt();
            System.out.println("enter month:");
            int m = myObj.nextInt();
            System.out.println("enter year:");
            int y = myObj.nextInt();
            Date d1 = new Date(d,m,y);
            System.out.println("d1="+d1);
            System.out.println(d1.toString());
        }
        // 2020 , 2016
        Date d1 = new Date(28, 2, 2004);

        System.out.println("\td1:"+d1);
        System.out.println("\tday of d1:"+d1.getDay());
        System.out.println("\tmonth of d1:"+d1.getMonth());
        System.out.println("\tyear of d1:"+d1.getYear());
        */
        Person p1 = new Person(new String("Eyal Azulay"),14,10,2000,new String("044236780"));
        Person p2 = new Person(new String("Eyal Azulay"),14,10,2000,new String("044236780"));
        if(p1.equals(p2))
             System.out.println("\tp1 is the same person as p2");
        else 
             System.out.println("\tp1 isn't the same person as p2");

    }
}
