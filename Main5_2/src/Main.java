import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write numder as the seed for our Random object ");
        int seed = in.nextInt();

        Window window = new Window(seed);
        javax.swing.SwingUtilities.invokeLater(window);
    }
}

