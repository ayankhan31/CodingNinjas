package classesandobjects;

public class Fraction {

    private int numerator;
    private int denominator;
    public Fraction(){
        numerator = 1;
        denominator = 1;
    }
    public  Fraction(int numerator,int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int gcd = 1;
        for(int i=2;i<Math.min(numerator,denominator);i++){
            if(numerator%i==0 && denominator%i==0){
                gcd = i;
            }
        }
        numerator = numerator/gcd;
        denominator = denominator/gcd;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        if(numerator==0){
            return;
        }
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if(denominator == 0){
            denominator = 1;
        }
        this.denominator = denominator;
    }
    public void print(){
        System.out.println(numerator+"/"+denominator);
    }
    public void increment(){
        numerator = numerator+denominator;
        simplify();
    }
    public static Fraction add(Fraction fr1, Fraction fr2){
        Fraction fr3 = new Fraction();
        fr3.numerator = fr1.numerator*fr2.denominator + fr1.denominator*fr2.numerator;
        fr3.denominator = fr1.denominator*fr2.denominator;
        fr3.simplify();
        return fr3;
    }
}
