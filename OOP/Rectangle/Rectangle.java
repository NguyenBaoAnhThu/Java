package OOP.Rectangle;

public class Rectangle {
    double width , height ;
    public Rectangle() {
    }
    public Rectangle(double width,double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return this.height * this.width;
    }
    public double getPermeter(){
        return (this.width + this.height)*2;
    }
    public String Display(){
        return "Retangle{" + "width" + width + ",height" + height + "}";
    }
}
