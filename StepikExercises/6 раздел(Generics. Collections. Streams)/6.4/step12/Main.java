import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/*
Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.

Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

minMaxConsumer.accept(min, max);

Если стрим не содержит элементов, то вызовите

minMaxConsumer.accept(null, null);
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("6.4 Stream API – Шаг 12");
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
//        ArrayList<Integer> arrayList = new ArrayList<>();
        Stream integerStream = arrayList.stream();
        findMinMax(integerStream, new IntComparator(), new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println(" " + integer + " " + integer2);
            }
        });
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Object[] arr = new Object[2];
        stream.forEach(n -> {
//            System.out.println(n);
            arr[0] = order.compare(arr[0] == null ? n : (T) arr[0], n) < 0 ? arr[0] : n;
            arr[1] = order.compare(arr[1] == null ? n : (T) arr[1], n) > 0 ? arr[1] : n;
        });
//        System.out.println("count=" + i);
        minMaxConsumer.accept((T) arr[0], (T) arr[1]);
    }
}
