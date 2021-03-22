package model;

import Util.CommonUtil;
import service.Formula;

public class Triangle extends GeometricFigure implements Formula {
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

    public double calculateArea() {
        double p = (side1 + side2 + side3) / 2;
        return CommonUtil.roundNumber(
                (sqrt(p * (p - side1) * (p - side2) * (p - side3))),2);
    }
}
