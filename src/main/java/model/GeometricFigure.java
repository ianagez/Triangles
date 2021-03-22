package model;


public abstract class GeometricFigure {
    private String name;
    private double area;

    public GeometricFigure(String name){
        this.name=name;
    }
    public GeometricFigure(String name,double area){
        this.name=name;
        this.area=area;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getArea() {
        return this.area;
    }
    public void setArea(double area) {
        this.area = area;
    }

    public String toString() {
        return String.format("[%s]: %f сm",name,getArea());
    }
}
