package app.Function;

abstract public class Function {
    private static double foot = 0.1;
    private static double min = -6;
    private static double max =6;
    public double[] x;
    public double[] y;
    public double step = 0;
    public int len;
    private void init(){
        len = (int) ((max-min)/foot);
        x = new double[len];
        y = new double[len];
        for(int i=0;i<len;i++){
            x[i]=min+i*foot;
            y[i]=get_y(x[i]);
        }
    }
    public double[] step(){
        step+=foot;
        for(int i=0;i<len;i++){
            y[i]=get_y(x[i]+step);
        }
        return y;
    }
    double get_y(double x){
        System.out.println("Error");
        return 0;
    }
    public Function(){
        init();
    }
    public Function(double Min,double Max,double Foot){
        min=Min;
        max=Max;
        foot=Foot;
        init();
    }
}
