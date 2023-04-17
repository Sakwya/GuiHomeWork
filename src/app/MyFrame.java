package app;

import app.Function.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame {
    public static Color HOVER = new Color(200, 200, 200);
    public static Color DEFAULT = null;
    public static Color SELECT = new Color(200, 200, 200);
    public static Font EN = new Font("仿宋", 1, 20);
    final CurvePanel cp;
    final JLabel y;

    @Override
    public int getHeight() {
        return super.getHeight();
    }




    public MyFrame() {
        this.setSize(1200, 800);
        this.setMinimumSize(new Dimension(600, 400));
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;//水平拉伸占满

        this.setLayout(gbl);
        this.setTitle("曲线显示系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);

        Container c = new Container();//空容器用于放置按钮等
        GridLayout gl = new GridLayout(12, 1, 0, 10);
        c.setLayout(gl);

        cp = new CurvePanel(this);


        MyButton sin = new MyButton("SinX",new Sin());
        MyButton cos = new MyButton("CosX",new Cos());
        MyButton ln = new MyButton("lnX",new Ln());
        MyButton ex = new MyButton("eX",new Ex());
        MyButton ctm = new MyButton("自定义曲线",new Custom());
        c.add(sin);
        c.add(cos);
        c.add(ln);
        c.add(ex);
        c.add(ctm);
        JTextField ctmT = new JTextField();
        ctmT.setFont(EN);
        ctmT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() != '\n') {
                    return;
                }
                if (Custom.deCode(ctmT.getText()) == null) {
                    JOptionPane.showMessageDialog(null, "格式错误：", "提示", 1);
                } else {
                    MyButton.getSelect().setBackground(DEFAULT);
                    MyButton.setSelect(ctm);
                    ctm.setBackground(SELECT);
                    CurvePanel.setF(ctm.f.init(ctmT.getText()));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        JLabel timeL = new JLabel("大小(n*px:1)");
        timeL.setFont(EN);
        JTextField timeT = new JTextField();
        timeT.setFont(EN);
        timeT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() != '\n') {
                    return;
                }
                try {
                    int times = Integer.parseInt(timeT.getText());
                    CurvePanel.setTIMES(times);
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, "请输入正整数：", "提示", 1);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        JLabel footL = new JLabel("步长(n)");
        footL.setFont(EN);
        JTextField footT = new JTextField();
        footT.setFont(EN);
        footT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() != '\n') {
                    return;
                }
                try {
                    double foots = Double.parseDouble(footT.getText());
                    switch (JOptionPane.showConfirmDialog(null, "确定要更改步长为" + footT.getText() + "吗？", "确认", 1)) {
                        case 0:
                            CurvePanel.setFOOT(foots);
                            return;
                        case 1:
                            footT.setText(CurvePanel.FOOT + "");
                    }
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, "请输入正浮点型：", "提示", 1);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        JLabel yL = new JLabel("当前y值：");
        yL.setFont(EN);
        y = new JLabel();
        y.setFont(EN);
        c.add(ctmT);
        c.add(timeL);
        c.add(timeT);
        c.add(footL);
        c.add(footT);
        c.add(yL);
        c.add(y);
        gbc.weightx = 0.05;//按钮区域权重
        gbl.setConstraints(c, gbc);
        this.add(c);

        gbc.weightx = 0.95;//主画布权重
        gbl.setConstraints(cp, gbc);
        this.add(cp);

        this.setVisible(true);//显示
        CurvePanel.f = ctm.f.init();
        MyButton.setSelect(ctm);
        ctm.setBackground(HOVER);
        timeT.setText(CurvePanel.TIMES + "");
        footT.setText(CurvePanel.FOOT + "");
    }
}
