public class Matrix {
    private final int m;
    private final int n;
    private final double[] values;

    public Matrix(final int m, final int n) {
        this(m, n, new double[m * n]);
    }

    public Matrix(final int m, final int n, final double[] values) {
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

    public double get(final int y, final int x) {
        return values[y * n + x];
    }

    public void set(final int y, final int x, final double value) {
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

    public Matrix multiply(final Matrix other) {
        final Matrix result = new Matrix(m, other.n);

        for (int y = 0; y < m(); ++y) {
            for (int x = 0; x < other.n(); ++x) {
                double sum = 0;
                for (int i = 0; i < n(); ++i) {
                    sum += get(y, i) * other.get(i, x);
                }
                result.set(y, x, sum);
            }
        }

        return result;
    }
}
