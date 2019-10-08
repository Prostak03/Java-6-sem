import java.io.*;

public class DataWorker {
    static double[][] readFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String firstLine = br.readLine();
        int NumOfEq = Integer.parseInt(firstLine);
        double[][] SystemOfEquation = new double[NumOfEq][NumOfEq];

        for (int i = 0; i < NumOfEq; i++){
            String str = br.readLine();
            SystemOfEquation[i] = fromStringToNums(str);
        }
        br.close();
        return SystemOfEquation;
    }

    static void writeToData(String filename, double[] answer) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (double ans : answer){
            bw.write(ans + "\n");
            System.out.print(ans + "\n");
        }
        bw.close();
    }

    static void writeToData (String filename, String answer) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write(answer);
        bw.close();
    }



    private static double[] fromStringToNums(String str) {
        String[] Sternums = str.split(" ");
        double[] numbs = new double[Sternums.length];
        for (int i = 0; i < Sternums.length; i++){
            numbs[i] = Double.parseDouble(Sternums[i]);
        }
        return numbs;
    }
}
