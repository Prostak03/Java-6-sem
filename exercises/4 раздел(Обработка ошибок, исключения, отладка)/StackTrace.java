/*
���������� �����, ����������� ������ ������� ������, ������ �� �������.

����� getCallerClassAndMethodName() ������ ���������� ��� ������ � ������, ������ ������ �����, ��������� ������ ��������� �����. ��� null (������� ������, � �� ������ "null"), ���� �����, ��������� getCallerClassAndMethodName() �������� ������ ����� � ���������, �.�. ��� ����� �� �������.

������

package org.stepic.java.example;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...
    }
}
��� ������� ��� ��������� ������ �������:
null
org.stepic.java.example.Test#main
P.S. ��� ������������ ���� ��������� � ����� ���������� �� ������ �������� ������ ���������: ������ null � ������ ������� ����� ��������� �����-�� ����������� ����� � �����. ��� ������� � ���, ��� ����� ���������� ������ ��������� �� ��� �����, � ���� �����������, ������� ����� ��� �������� ���. ����� ����� ��������, ���������� ��������� �������� "java" � ��������� ������.
*/

public static String getCallerClassAndMethodName() {
    StackTraceElement[] ste = new Exception().getStackTrace();
    if (ste.length < 3 ) {
            return null;
    } else {
            return ste[2].getClassName()+"#"+ste[2].getMethodName();
    }   
}