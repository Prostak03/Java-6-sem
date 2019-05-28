package FractionPolynom;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FractionList {

    private List<Fraction> fractions = new ArrayList<>();
    private Fraction maxFraction = null;
    private Fraction minFraction = null;

    public Fraction getMaxFraction() {
        return this.maxFraction;
    }

    public Fraction getMinFraction() {
        return this.minFraction;
    }

    public List<Fraction> getFractions() {
        return fractions;
    }

    public void insertFromFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] fractionsString = scanner.nextLine().split(" ");
                int n = Integer.parseInt(fractionsString[0]);
                int d = Integer.parseInt(fractionsString[1]);
                this.insert(new Fraction(n, d));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FractionList insert(Fraction fraction) {
        fractions.add(fraction);
        this.updateMinAndMax(fraction);

        return this;
    }

    public FractionList insert(Fraction fraction, int index) {
        if (index < 0 || index > fractions.size()) {
            System.out.println("Invalid index");
        } else {
            fractions.add(index, fraction);
            this.updateMinAndMax(fraction);
        }
        return this;
    }

    public FractionList insert(FractionList fractionList) {
        for (Fraction f : fractionList.getFractions()) {
            this.insert(f);
        }
        return this;
    }

    public Fraction getFraction(int index) {
        return fractions.get(index);
    }

    public FractionList remove(int index) {
        if (index < 0 || index > fractions.size()) {
            System.out.println("Invalid index");
        } else {
            fractions.remove(index);
            if (fractions.size() != 0) {
                for (Fraction f : fractions) {
                    this.updateMinAndMax(f);
                }
            } else {
                this.minFraction = null;
                this.maxFraction = null;
            }
        }
        return this;
    }

    public int length() {
        return fractions.size();
    }


    public int countLargerThan(Fraction fraction) {
        int count = 0;
        for (Fraction f : fractions) {
            if (f.compareTo(fraction) > 0) {
                ++count;
            }
        }

        return count;
    }

    public int countLessThan(Fraction fraction) {
        int count = 0;
        for (Fraction f : fractions) {
            if (f.compareTo(fraction) < 0) {
                ++count;
            }
        }
        return count;
    }

    private void updateMinAndMax(Fraction fraction) {
        if (this.maxFraction == null) {
            this.maxFraction = fraction;
            this.minFraction = fraction;
        } else {
            if (fraction.compareTo(this.maxFraction) > 0) {
                this.maxFraction = fraction;
            }
            if (fraction.compareTo(this.minFraction) < 0) {
                this.minFraction = fraction;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("FractionList{%s}", fractions);
    }
}
