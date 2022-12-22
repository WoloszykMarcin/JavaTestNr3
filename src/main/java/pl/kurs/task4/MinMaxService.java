package pl.kurs.task4;

import java.util.List;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) throws IllegalArgumentException {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("List must contain at least one element");
        }

        MinMax<T> minMax = new MinMax<>(elements.get(0), elements.get(0));

        for (T element : elements) {
            if (element.compareTo(minMax.getMin()) < 0)
                minMax.setMin(element);
            if (element.compareTo(minMax.getMax()) > 0)
                minMax.setMax(element);
        }
        return minMax;
    }
}
