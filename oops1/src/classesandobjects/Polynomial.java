package classesandobjects;

public class Polynomial {

    private int[] poly;
    private int degree;
    public Polynomial(int deg){
        poly = new int[deg+1];
        degree = deg;
        for(int i=0;i<deg+1;i++){
            poly[i]=0;
        }
    }
    public int size(){
        return degree;
    }
    public boolean isEmpty(){
        return degree == 0;
    }

    public int get(int i){
        if(i<degree){
            return poly[i];
        }
        else
            return -1;
    }

    public void setCoefficient(int i, int value){
        if(i>degree){
            increaseCapacity(i);
        }
        poly[i] = value;
    }

    public void add(Polynomial p){
        int size = Math.max(this.poly.length, p.poly.length);
        if(this.poly.length<size)
            increaseCapacity(size);
        for(int i=0;i<p.poly.length;i++){
            this.poly[i]+=p.poly[i];
        }
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
        degree=deg;
    }
    public void print(){
        if(degree==0)
            return;
        for(int i=0;i<poly.length;i++){
            if(poly[i]!=0){
                System.out.print(poly[i]+"x^"+i+" + ");
            }
        }
    }
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

    public Polynomial multiply(Polynomial p){
        int size = this.poly.length + p.poly.length - 1;
        System.out.println();
        System.out.println(this.poly.length+", "+size+ ", "+p.poly.length);
        Polynomial p3 = new Polynomial(size);
        for(int i=0;i<this.poly.length;i++){
            for(int j=0;j<p.poly.length;j++){
                p3.poly[i+j]+=this.poly[i]*p.poly[j];
            }
        }
        return p3;
    }

}
