/**
 * 
 * @author course 20441 staff
 * @version 17/10/2023 (2024a)
 */
public class PersonStudentTester {
    public static void main(String[] args) {
        System.out.println("********** Test Person - Started **********");
        System.out.println("\n1. Testing Constructors and toString:");
        Person p1 = new Person("Israel Israeli", 22, 10, 1993, "123456789");
        System.out.println("p1 :\n" + p1);
        Person p2 = new Person(p1);
        System.out.println("p2 :\n" + p2);

        System.out.println("\n2. Testing accessors and mutators:");
        String name = p1.getName();
        Date date = p1.getDateOfBirth();
        String id = p1.getId();
        System.out.println("\tName of p1 = " + name);
        System.out.println("\tId of p1 = " + id);
        System.out.println("\tDate of birth of p1 = " + date);
       
        p1.setName("Miriam Levi");
        p1.setId("121212");
        p1.setDateOfBirth(new Date(19, 9, 1981));
        System.out.println("p1 :\n" + p1);
 
        System.out.println("\n3. Testing equals method:");
        Person p3 = new Person("Yossef Ben Avrham", 5, 3, 1998, "123123123");
        Person p4 = new Person("Yossef Ben Avrham", 5, 3, 1998, "321321321");
        System.out.println("p3 :\n" + p3);
        System.out.println("p4 :\n" + p4);
        if(p3.equals(p4))
             System.out.println("\tp3 is the same person as p4");
        else 
             System.out.println("\tp3 isn't the same person as p4");

        System.out.println("\n4. Testing compare method:");
        System.out.println("p1 :\n" + p1);
        System.out.println("p3 :\n" + p3);
        if(p1.compareTo(p3) > 0)
            System.out.println("\tp1 is older than p3");
        else if (p1.compareTo(p3) < 0)
            System.out.println("\tp1 is younger than p3");
        else
            System.out.println("\tp1 as the same age as p3");
        System.out.println("********** Test Person - Ended **********");
    }
}
