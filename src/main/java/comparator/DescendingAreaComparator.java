package comparator;

import model.GeometricFigure;

import java.util.Comparator;

public class DescendingAreaComparator<T extends GeometricFigure> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.getArea() - o2.getArea() == 0){
           return o1.getName().compareTo(o2.getName());
        }
        else if (o1.getArea() < o2.getArea())
            return 1;
        else
            return -1;
    }
}
