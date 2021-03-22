package model;

import jdk.jshell.execution.Util;
import service.Formula;
import Util.CommonUtil;

public class Rectangle extends GeometricFigure implements Formula {
    private final double sideA;
    private final double sideB;

    public Rectangle(String name, double sideA, double sideB) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        super.setArea(calculateArea());
    }

    public String getName() {
        return super.getName();
    }
    public double getSideA() {
        return sideA;
    }
    public double getSideB() {
        return sideB;
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double calculateArea() {
        return CommonUtil.roundNumber(( sideB * sideA),2); }
}
