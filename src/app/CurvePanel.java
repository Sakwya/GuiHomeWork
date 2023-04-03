package app;

import javax.swing.*;
import java.awt.*;

public class CurvePanel extends JPanel {
    double[] xl;
    double[] yl;
    public void init(double[] x,double[] y){
        xl=x;
        yl=y;
    }
    static  int cx(double x){
        return  (int)Math.round(600+x*100);
    }
    static  int cy(double y){
        return (int)Math.round(400-y*100);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类的方法完成初始化

        g.drawLine(0,400,1200,400);
        g.drawLine(600,0,600,800);
        g.setColor(Color.RED);

        for(int i=1;i<xl.length;i++){
            g.drawLine(cx(xl[i-1]),cy(yl[i-1]),cx(xl[i]),cy(yl[i]));
        }
    }

}