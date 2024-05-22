package AccessModifier;

public class Circle {
    private double radius  ;
    private String color ;


    public Circle(){
        this.radius = 1.0 ;
        this.color = "red";
    }
    public Circle(double radius){
        this.radius = radius ;
        this.color = "red";
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }
}
