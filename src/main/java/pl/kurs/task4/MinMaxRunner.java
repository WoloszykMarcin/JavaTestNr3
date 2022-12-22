package pl.kurs.task4;

import java.util.Arrays;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,9,8,7,6,15,4,3,2,1);
        List<String> stringList = Arrays.asList("sosna", "dąb", "brzoza", "hebanowiec");
        List<Double> doubles = Arrays.asList();

        Person student1 = new Person("Maciej", "Kowalski", 4);
        Person student2 = new Person("Katarzyna", "Kowalska", 15);
        Person student3 = new Person("Anna", "Kowalska", 26);

        List<Person> people = Arrays.asList(student1, student2, student3);

        MinMax<Person> minMax = MinMaxService.getMinAndMax(people);
//        MinMax<String> minMax = MinMaxService.getMinAndMax(stringList);
//        MinMax<Integer> minMax = MinMaxService.getMinAndMax(numbers);
        System.out.println("min: " + minMax.getMin());
        System.out.println("max: " + minMax.getMax());

        try{
            System.out.println(MinMaxService.getMinAndMax(people));
//            System.out.println(MinMaxService.getMinAndMax(numbers));
//            System.out.println(MinMaxService.getMinAndMax(stringList));
//            System.out.println(MinMaxService.getMinAndMax(doubles));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
