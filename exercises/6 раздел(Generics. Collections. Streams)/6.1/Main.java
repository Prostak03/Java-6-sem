/*
Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий
элементам принимать значение null.

Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
Конструктор должен быть закрытым (private).

С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:

Pair<Integer, String> pair = Pair.of(1, "hello");
Integer i = pair.getFirst(); // 1
String s = pair.getSecond(); // "hello"

Pair<Integer, String> pair2 = Pair.of(1, "hello");
boolean mustBeTrue = pair.equals(pair2); // true!
boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!


Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("6.1 Generics – Шаг 12");

        Pair<Integer, String> pair = Pair.of(1, "hello");
        System.out.println("pair = " + pair);

        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.println("i = " + i + " s = " + s);


        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        System.out.println("pair2 = " + pair2);

        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println("pair == pair2 "+mustBeTrue);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println("pair.hashCode() == pair2.hashCode() " + mustAlsoBeTrue);

        pair = Pair.of(null,"another pair");
        System.out.println("pair = " + pair);
        pair2 = Pair.of(null,"another pair");
        System.out.println("pair2 = " + pair2);
        mustBeTrue = pair.equals(pair2); // true!
        System.out.println("pair == pair2 "+mustBeTrue);

    }
}
