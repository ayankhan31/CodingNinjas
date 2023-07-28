package classesandobjects;

public class StudentUse {
    public static void main(String[] args) {
        Student s1 = new Student("Ayan");
        s1.name = "Ayan";
//      s1.rollNumber = 20;
//        s1.setRollNumber(100);
        Student s2 = new Student("Areeba");

        System.out.println("s1 "+s1);
        System.out.printf("%s %d%n", s1.name, s1.getRollNumber());
        System.out.println("Number of Students Created "+Student.getNumStudent());
    }

}
