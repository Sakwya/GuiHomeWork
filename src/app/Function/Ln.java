package app.Function;

public class Ln extends Function{

    @Override
    protected double function(double x) {
        if(x==0)return -999999;
        return Math.log(x);
    }
}
