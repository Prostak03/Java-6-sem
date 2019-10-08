import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        double[][] matrix;
        double[] ans;

        try {
            matrix = DataWorker.readFromFile("resources/in.txt");
            /*for (int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println("------------------");
            }*/
            EquationSolver solver = new EquationSolver(matrix);
            ans = solver.solve();

            DataWorker.writeToData("resources/out.txt", ans);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolverException e) {
            try {
                DataWorker.writeToData("resources/out.txt", e.getMessage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
