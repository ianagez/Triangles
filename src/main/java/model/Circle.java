package model;

import Util.CommonUtil;

public class Circle extends GeometricFigure{
    private final double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
        super.setArea(calculateArea());
    }

    public String getName() {
        return super.getName();
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double calculateArea() {
        return CommonUtil.roundNumber((Math.PI * this.radius), 2);
    }
}
