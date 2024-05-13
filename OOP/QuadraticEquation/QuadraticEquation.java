package OOP.QuadraticEquation;

public class QuadraticEquation {
    private double a,b,c;
    double delta,r1,r2;
    public QuadraticEquation(double a,double b,double c ) {
        this.a = a ;
        this.b = b ;
        this.c = c ;
        this.delta = b*b - 4*a*c ;
    }
    public double getA(){
       return this.a = a ;
    }
    public double getB(){
        return this.b = b ;
    }
    public double getC(){
        return this.c = c ;
    }
    public double getDiscriminant(){
        return this.delta ;
    }
    public double getR1(){
        r1=(-b + Math.sqrt(b*b - 4*a*c)/2*a);
        return r1;
    }
    public double getR2(){
        r2=(-b - Math.sqrt(b*b - 4*a*c)/2*a);
        return r2;
    }
}
