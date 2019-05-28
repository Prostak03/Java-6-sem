import FractionPolynom.Fraction;
import FractionPolynom.FractionList;
import FractionPolynom.Polynom;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Fraction frac = new Fraction(2, 3);
        Fraction frac1 = new Fraction(1, 3);
        Fraction frac2 = new Fraction(4, 3);
        Fraction frac3 = new Fraction(3, 3);

        FractionList fractionList = new FractionList();
        fractionList.insert(frac).insert(frac1).insert(frac2).insert(frac3, 0).remove(2);
        fractionList.insert(new Fraction(2));
        System.out.println(fractionList);

        System.out.println("Max is " + fractionList.getMaxFraction());
        System.out.println("Min is " + fractionList.getMinFraction());
        System.out.println("Larger then " + frac1 + ": "  + fractionList.countLargerThan(frac1));
        System.out.println("Less then " + frac3 + ": "  + fractionList.countLessThan(frac3));

        FractionList fractionListFromFile = new FractionList();
        fractionListFromFile.insertFromFile(new File("resources/list.txt"));
        System.out.println(fractionListFromFile);

        FractionList fractionArray = new FractionList();
        fractionArray.insert(frac1).insert(frac2).insert(new Fraction(3));

        Polynom p1 = new Polynom(fractionList);
        Polynom p2 = new Polynom(fractionListFromFile);
        Polynom polynomSumma = p1.addPolynom(p2);
        System.out.println(String.format("%s + %s = %s", p1, p2, polynomSumma));
    }
}
