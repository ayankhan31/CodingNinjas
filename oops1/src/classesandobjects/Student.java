package classesandobjects;

public class Student {
    public String name;
    final private int rollNumber;
    double cgpa;
    static private int numStudents;
    public static final double CONVERSIONFACTOR=0.95;

    public Student(String name){
        this.name=name;
        numStudents++;
        this.rollNumber=numStudents;

    }
//    public Student(){
//        name = "abc";
//        rollNumber = 10;
//    }
    public static int getNumStudent(){
        return numStudents;
    }
    public int getRollNumber(){
        return rollNumber;
    }
//    public void setRollNumber(int rollNumber){
//        //parameter rollNumber is a local variable
//        if(rollNumber<=0){
//            return;
//        }
//        System.out.println("this "+this);
//        //using this makes the rollNumber to be used as an object variable
////        this.rollNumber = rollNumber;
//    }
}
