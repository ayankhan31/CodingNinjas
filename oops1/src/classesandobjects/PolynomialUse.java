package classesandobjects;

public class PolynomialUse {
    public static void main(String[] args) {
        Polynomial p1=new Polynomial(3);
        p1.setCoefficient(0,5);
        p1.setCoefficient(2,10);
        p1.setCoefficient(3,6);
        System.out.println(p1.size());
        p1.print();
        Polynomial p2 = new Polynomial(3);
        p2.setCoefficient(0,1);
        p2.setCoefficient(1,2);
        p2.setCoefficient(2,4);

        System.out.println();
        p2.print();
        System.out.println();
        Polynomial p3 = p1.multiply(p2);
        p3.print();
    }
}
