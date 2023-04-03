package app.Function;

public class Sin extends Function {
    @Override
    double get_y(double x) {
        return Math.cos(x);
    }
}
