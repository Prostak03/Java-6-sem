import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        test();
        convert(System.in,System.out);
    }

    private static void test() throws IOException {
        System.out.println("5.2 Потоки байт – Шаг 9");
        byte[] test = new byte[]{65, 13, 10, 10, 13};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(10);

        convert(new ByteArrayInputStream(test),outputStream );
        byte[] out = outputStream.toByteArray();
        for (int i: out) {
            System.out.println(i);
        }
    }

    private static void convert(InputStream inputStream,OutputStream outputStream) throws IOException {
        int buf1 = inputStream.read();
        int buf2;

        while(buf1 != -1){
            buf2 = inputStream.read();
            if (!(buf2 == 10 && buf1 == 13)){
                outputStream.write(buf1);
            }
            buf1 = buf2;
        }
        outputStream.flush();
    }
}