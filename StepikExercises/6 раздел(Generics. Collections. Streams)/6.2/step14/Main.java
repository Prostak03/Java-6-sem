import java.util.HashSet;
import java.util.Set;

/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.

Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример

Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("6.2 Коллекции – Шаг 14");
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        Set<Integer> s2 = new HashSet<>();
        s2.add(0);
        s2.add(1);
        s2.add(2);
        Set<Integer> s3 = symmetricDifference(s1, s2);
        s3.forEach(System.out::println);

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setOut = new HashSet<>();
        for (T t:set1){
            if(!set2.contains(t)){
                setOut.add(t);
            }
        }
        for (T t:set2){
            if(!set1.contains(t)){
                setOut.add(t);
            }
        }
        return setOut;
    }
}
