import java.io.*;
import java.util.ArrayList;

/*
 Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal. Массив байт устроен
 следующим образом. Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size). Далее
 подряд записано указанное количество объектов типа Animal, сериализованных при помощи
 ObjectOutputStream.writeObject(animal).

 Если вдруг массив байт не является корректным представлением массива экземпляров Animal, то метод должен бросить
 исключение java.lang.IllegalArgumentException.

 Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и посмотрите,
 какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить.
 Если что-то забудете, то проверяющая система подскажет. Главное не глотать никаких исключений, т.е. не оставлять
 нигде пустой catch.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(" 5.4 Продвинутые возможности – Шаг 8");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(byteArrayOutputStream);
        Integer integer = 6;
        os.writeInt(integer);
        Animal a1 = new Animal("a1");
        Animal a2 = new Animal("a2");
        Animal a3 = new Animal("a3");
        Animal a4 = new Animal("a4");
        Animal a5 = new Animal("a5");
        os.writeObject(a1);
        os.writeObject(a2);
        os.writeObject(a3);
        os.writeObject(a4);
        os.writeObject(a5);

        Animal[] animals = deserializeAnimalArray(byteArrayOutputStream.toByteArray());
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }


    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals=null;
        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))){
            Integer numAnimals = ois.readInt();
            animals = new Animal[numAnimals];
            for (int i = 0; i < numAnimals; i++) {
                animals[i] = (Animal) ois.readObject();
            }
        } catch (EOFException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassCastException e){
            throw new IllegalArgumentException(e);
        }
        return animals;
    }
}
