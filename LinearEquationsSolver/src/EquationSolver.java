class EquationSolver {

    private double[][] left;
    private double[] right;
    private double[] ans;
    private int n;
    private boolean isNotSolution;

    EquationSolver(double[][] matrix){
        n = matrix.length;
        left = new double[n+1][n+1];
        right = new double[n+1];
        ans = new double[n];
        isNotSolution = false;

        for (int i = 0; i < n; i++){
            System.arraycopy(matrix[i], 0, left[i + 1], 1, n);
            right[i+1] = matrix[i][n];
        }
    }

    double[] solve() throws SolverException{

        step1(n);

        if (isNotSolution){
            if (right[n] == 0){
                throw new SolverException("Infinitely many solutions");
            } else {
                throw new SolverException("No Solution");
            }
        }
        step2(n);

        return ans;
    }

    private void step1(int n) throws SolverException {
        double d;
        boolean isSwapRow = false;
        for (int k = 1; k <= n; k++) {
            if (left[k][k] == 0){
                isSwapRow = swapRow(k, n);
                if (!isSwapRow) {
                    isNotSolution = true;
                        swapCol(k, n);
                }
            }
            for (int j = k + 1; j <= n; j++) {
                d = left[j][k] / left[k][k];
                for (int i = k; i <= n; i++) {
                    left[j][i] = left[j][i] - d * left[k][i];
                }
                right[j] = right[j] - d * right[k];
            }
        }
    }

    private void step2(int n) {
        double s, d;
        for (int k = n; k >= 1; k--)
        {
            d = 0;
            for (int j = k + 1; j <= n; j++)
            {
                s = left[k][j] * ans[j-1];
                d = d + s;
            }
            ans[k-1] = (right[k] - d) / left[k][k];
        }
    }

    private boolean swapRow(int k, int n){
        boolean isSwap = false;
        for (int j = k + 1; j <= n; j++){
            if (left[j][k] != 0){
                double[] temp = left[k];
                left[k] = left[j];
                left[j] = temp;

                double tem = right[k];
                right[k] = right[j];
                right[j] = tem;
                isSwap = true;
                break;
            }
        }
        return isSwap;
    }

    private void swapCol(int k, int n) throws SolverException {
        double temp;
        boolean isSwap = false;
        for (int j = k + 1; j <= n; j++){
            if (left[k][j] != 0){
                for (int i = k; i <= n; i++){
                    temp = left[i][k];
                    left[i][k] = left[i][j];
                    left[i][j] = temp;
                }
                isSwap = true;
                break;
            }
        }
        if (!isSwap){
            if (right[k] == 0){
                throw new SolverException("Infinitely many solutions");
            }
            else { throw new SolverException("No solution");}
        }
    }
}
