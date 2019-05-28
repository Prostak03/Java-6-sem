/*
���������� �����, ����������� ��������� �������������� �������� ������� �� �������� ��������� �� ������� ����� ���������������.

������� ������ ��������, ����������� ��������� java.util.function.DoubleUnaryOperator. ��� ����� applyAsDouble() ��������� �������� ��������� � ���������� �������� ������� � �������� �����.

�������� �������������� �������� ��� ��������� ������� a � b, ������ a<=b. ��� ��������� ���������� ������� ���������� ����������� ��� ����� �� ������ 10?6.

������. �����

integrate(x -> 1, 0, 10)
������ ���������� �������� 10.
*/

public static double integrate(DoubleUnaryOperator f, double a, double b) {
    int i;
    int n = 1000000;
    double result, h;
    result = 0;
    h = (b - a) / n; //��� �����

    for(i = 0; i < n; i++) {
        result += f.applyAsDouble(a + h * (i + 0.5)); //��������� � ������� ����� � ��������� � �����
    }

    result *= h;

    return result;
    //return f.applyAsDouble(a)*(b-a);
}