public class Matrix {
    private int m;
    private int n;
    private double[] values;

    public Matrix(int m, int n) {
        this(m, n, new double[m * n]);
    }

    public Matrix(int m, int n, double[] values) {
        this.m = m;
        this.n = n;
        this.values = values;
    }

    public int m() {
        return m;
    }

    public int n() {
        return n;
    }

    public double get(int y, int x) {
        return values[y * n + x];
    }

    public void set(int y, int x, double value) {
        values[y * n + x] = value;
    }

    public void print() {
        for (int y = 0; y < m; ++y) {
            for (int x = 0; x < n; ++x) {
                System.out.print(get(y, x) + " ");
            }
            System.out.println();
        }
    }

    public Matrix multiply(Matrix other) {
        double[] nValues = new double[m() * other.n()];

        for (int y = 0; y < m(); ++y) {
            for (int x = 0; x < other.n(); ++x) {
                for (int i = 0; i < n(); ++i) {
                    nValues[y * n() + x] += get(y, i) * other.get(i, x);
                }
            }
        }

        return new Matrix(m, other.n, nValues);
    }
}
