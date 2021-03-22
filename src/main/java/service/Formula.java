package service;

public interface Formula {
    double calculateArea ();

    default double sqrt(double a){
        return Math.sqrt(a);
    }
}
