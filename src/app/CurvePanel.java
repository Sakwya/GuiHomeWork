package app;

import app.Function.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CurvePanel extends JPanel implements Runnable {
    private static int AXIS_HEIGHT = 0;
    private static int PANEL_WIDTH = 0;
    public static double FOOT = 0.01;
    public static int TIMES = 100;
    private static MyFrame Parent;
    public static Function f;

    static int cx(double x) {
        return (int) Math.round(PANEL_WIDTH - x * TIMES);
    }

    static int cy(double y) {
        return (int) Math.round(AXIS_HEIGHT - y * TIMES);
    }

    static void setTIMES(int times) {
        TIMES = times;
        Function.SIZE = (int) Math.round(2000 / (FOOT * TIMES));
    }

    static void setFOOT(double foot) {
        FOOT = foot;
        f.init();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);//调用父类的方法完成初始化
        AXIS_HEIGHT = Parent.getHeight() / 2;
        PANEL_WIDTH = (int) Math.round(0.95 * Parent.getWidth());
        g.drawLine(0, AXIS_HEIGHT, PANEL_WIDTH, AXIS_HEIGHT);
        g.setColor(Color.orange);
        ArrayList<Double> Data = (ArrayList<Double>) f.DATA.clone();
        for (int i = Data.size() - 1, j = 0; i > 0; ) {
            //g.drawLine(cx(++j*FOOT),cy(Data.get(--i)),cx(j*FOOT),cy(Data.get(i)));
            g.drawLine(cx(j * FOOT), cy(Data.get(i)), cx(++j * FOOT), cy(Data.get(--i)));
            g.drawLine(cx(--j * FOOT), cy(Data.get(++i)) - 1, cx(++j * FOOT), cy(Data.get(--i)) - 1);
        }
        {
            double y = Data.get(Data.size() - 1);
            y *= 1000000;
            y = Math.round(y);
            y /= 1000000;
            Parent.y.setText(y + "");
        }
    }

    public CurvePanel(MyFrame mf) {
        setBackground(new Color(240, 240, 240));
        Parent = mf;
        repaint();
        new Thread(this, "CurvePanel").start();
    }

    public static void setF(Function f) {
        CurvePanel.f = f;
    }

    private void update() {
        while (true) {
            removeAll();
            updateUI();
            try {
                Thread.sleep(100);
                f.run(10);
            } catch (Exception e) {
                System.out.println("Got Exception");
            }
        }
    }

    @Override
    public void run() {
        update();
    }
}