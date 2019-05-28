package FractionPolynom;

public class Polynom {

    private int degree;
    /**
     * polynom:         1/2*x^2 + 0*x + 3/7 = 0
     * coefficients:    1/2, 0/1, 3/7
     * */
    private FractionList coefficients;

    public Polynom() {}

    public Polynom(FractionList fractionList){
        this.coefficients = fractionList;
        this.degree = fractionList.length() - 1;
    }

    public int getDegree() {
        return degree;
    }

    /** Return a fraction value at position */
    public Fraction getCoefficient(int part){
        return coefficients.getFraction(part);
    }

    /** Change a fraction coefficient at position */
    public void changeCoefficient(Fraction fraction, int part){
        this.coefficients.remove(part);
        this.coefficients.insert(fraction, part);
    }

    /** Addition of two polynoms */
    public Polynom addPolynom(Polynom polynom){

        FractionList polynomSumList = new FractionList();
        int minDegree;
        if (polynom.getDegree() > this.degree) {
            minDegree = this.degree;
            for (int i = 0; i < polynom.getDegree() - minDegree; i++) {
                polynomSumList.insert(polynom.getCoefficient(i), i);
            }
        } else {
            minDegree = polynom.getDegree();
            for (int i = 0; i < this.degree - minDegree; i++) {
                polynomSumList.insert(this.getCoefficient(i), i);
            }
        }

        for (int i = 0; i <= minDegree; i++) {
            polynomSumList.insert(
                    this.getCoefficient(this.degree - i).add(polynom.getCoefficient(polynom.getDegree() - i)),
                    minDegree - 1
            );
        }

        return new Polynom(polynomSumList);
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < coefficients.length(); i++) {
            if (i < coefficients.length() - 2) {
                toReturn += coefficients.getFraction(i) + "x^" + (coefficients.length() - 1 - i);
            } else if (i < coefficients.length() - 1) {
                toReturn += coefficients.getFraction(i) + "x";
            } else {
                toReturn += coefficients.getFraction(i);
            }

            if (i != coefficients.length() - 1) toReturn += " + ";
        }
        return "Polynom{" + toReturn + '}';
    }
}
