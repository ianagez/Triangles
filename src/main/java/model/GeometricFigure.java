package model;


import java.util.Objects;

public abstract class GeometricFigure {
    private String name;
    private double area;

    public GeometricFigure(String name){
        this.name=name;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getArea() {
        return this.area;
    }
    public void setArea(double area) {
        this.area = area;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeometricFigure)) return false;
        GeometricFigure figure = (GeometricFigure) o;
        return Double.compare(figure.getArea(),
                getArea()) == 0 && getName().equals(figure.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getArea());
    }

    public abstract double calculateArea();

    public String toString() {
        return ("["+name+"]: "+getArea()+" сm");
    }
}
