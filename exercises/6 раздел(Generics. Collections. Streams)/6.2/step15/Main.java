/*
 Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
 затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в
 обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        // считываем числа
        while (scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        // удаляем четные
        Iterator<Integer> integerIterator = list.iterator();
        int i=0;
        while(integerIterator.hasNext()){
            integerIterator.next();
            if (i%2 == 0){
                integerIterator.remove();
            }
            i++;
        }
        // разворачиваем
        Collections.reverse(list);
        // вывод результата
        list.forEach(Main::printInt);
    }
    public static void printInt(Integer i){
        System.out.print(i+" ");
    }
}
