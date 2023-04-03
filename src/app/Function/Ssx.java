package app.Function;

public class Ssx extends Function {
    @Override
    double get_y(double x) {
        return Math.exp(x)/100;
    }
    Ssx(double Min,double Max,double Foot){
        super(Min,Max,Foot);
    }
}
