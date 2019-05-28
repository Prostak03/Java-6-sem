/*
 * В Григорианском календаре год является високосным в двух случаях: либо
 * он кратен 4, но при этом не кратен 100, либо кратен 400.
 * Реализуйте метод, вычисляющий количество високосных лет с начала нашей
 * эры (первого года) до заданного года включительно. На самом деле
 * Григорианский календарь был введен значительно позже, но здесь для
 * упрощения мы распространяем его действие на всю нашу эру.
 *
 * Ввод-вывод обеспечивает проверяющая система. Вам надо только
 * проанализировать переданное в метод значение и вернуть результат.
 * В программу всегда подается положительный номер года. Предполагается
 * решение без циклов. Вам надо придумать и записать несложную формулу,
 * использующую только арифметические операторы.
 *
 * В качестве примера написано заведомо неправильное выражение. Исправьте его.
 */
public class Stepic_2_1_8 {
    public static int leapYearCount(int year) {
        return year/4 - year/100 + year/400;
    }
}
