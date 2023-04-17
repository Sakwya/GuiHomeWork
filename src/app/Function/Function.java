package app.Function;

import app.CurvePanel;

import java.util.ArrayList;

abstract public class Function{
    private long TIME;
    public static double FOOT;
    public static ArrayList<Double> DATA =new ArrayList<>();;
    public static int SIZE;
    private static Function f;
    public Function init(String inCode){
        System.out.println("Error"+inCode);
        FOOT=CurvePanel.FOOT;
        TIME=0;
        SIZE =(int)Math.round(2000/(FOOT*CurvePanel.TIMES));
        DATA.clear();
        DATA.add(function(0));
        TIME++;
        f=this;
        return this;
    }
    public Function init(){
        FOOT=CurvePanel.FOOT;
        TIME=0;
        SIZE =(int)Math.round(2000/(FOOT*CurvePanel.TIMES));
        DATA.clear();
        DATA.add(function(0));
        TIME++;
        f=this;
        return this;
    }
    private void update(){
        while (DATA.size()>=SIZE) DATA.remove(0);
        DATA.add(function(TIME*FOOT));
        TIME++;
    }
    protected double function(double x){
        System.out.println("ERROR");
        return 0;
    }
    public Function(){
    }
    public void run(int i){
        for(;i>=0;i--){
            update();
        }
    }
}
