package model;

import Util.CommonUtil;

import java.util.Objects;

public class Triangle extends GeometricFigure{
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(String name, double side1, double side2, double side3) {
        super(name);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        super.setArea(calculateArea());
    }

    public String getName() { return super.getName(); }
    public double getArea() {
        return super.getArea();
    }

    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() {
        return side3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.getSide1(),
                getSide1()) == 0 && Double.compare(triangle.getSide2(),
                getSide2()) == 0 && Double.compare(triangle.getSide3(), getSide3()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSide1(), getSide2(), getSide3());
    }

    public double calculateArea() {
        double p = (side1 + side2 + side3) / 2;
        double area;
        try{
             area=CommonUtil.roundNumber((Math.sqrt(p * (p - side1) * (p - side2) * (p - side3))),2);
             if(area==0){
                 throw new IllegalArgumentException();
             }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("It is impossible to create a triangle with this sides.");
        }
        return area;
    }
}
