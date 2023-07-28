package classesandobjects;

public class ff {
    private int poly[];
    private int d;
    public void setCoefficient(int degree, int coeff){
        if(degree>d){
            increaseCapacity(degree);
        }
        poly[degree] = coeff;
    }

    // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of d.
    public void print(){
        if(d==0)
            return;
        for(int i=0;i<poly.length;i++){
            if(poly[i]!=0){
                System.out.print(poly[i]+"x"+i+" ");
            }
        }
    }


    // Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p){
        int size = Math.max(this.poly.length, p.poly.length);
        Polynomial add = new Polynomial();
        if(this.poly.length<size)
            increaseCapacity(size);
        for(int i=0;i<p.poly.length;i++){
            this.poly[i]+=p.poly[i];
        }
        return add;
    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p){
        int size = Math.max(this.poly.length, p.poly.length);
        Polynomial sub = new Polynomial(size);

        for(int i=0;i<this.poly.length;i++){
            sub.poly[i]= this.poly[i];
        }
        for(int i=0;i<p.poly.length;i++){
            sub.poly[i]-=p.poly[i];
        }
        return sub;
    }

    private void increaseCapacity(int deg){
        int[] temp = poly;
        poly = new int[deg+1];
        for(int i=0;i<deg+1;i++){
            poly[i]=0;
        }
        for(int i = 0; i<temp.length;i++){
            poly[i]=temp[i];
        }
        d=deg;
    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p){
        int size = this.poly.length + p.poly.length - 1;
        Polynomial p3 = new Polynomial(size);
        for(int i=0;i<this.poly.length;i++){
            for(int j=0;j<p.poly.length;j++){
                p3.poly[i+j]+=this.poly[i]*p.poly[j];
            }
        }
        return p3;
    }

}
