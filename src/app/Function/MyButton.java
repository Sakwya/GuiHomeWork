package app.Function;

import app.CurvePanel;
import app.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyButton extends JPanel {
    public static class CustomMouseListener implements MouseListener {
        static MyButton selected;
        MyButton parent;

        CustomMouseListener(MyButton parent) {
            this.parent = parent;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (selected != null)
                selected.setBackground(MyFrame.DEFAULT);
            selected = parent;
            selected.setBackground(MyFrame.SELECT);
            CurvePanel.setF(parent.f.init());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            parent.setBackground(MyFrame.HOVER);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (parent.equals(selected)) return;
            parent.setBackground(MyFrame.DEFAULT);
        }
    }

    public static MyButton getSelect() {
        return CustomMouseListener.selected;
    }

    public static void setSelect(MyButton select) {
        CustomMouseListener.selected = select;
    }

    public JLabel MAIN;
    public Function f;

    public MyButton(String text, Function f) {
        super(new BorderLayout());
        MAIN = new JLabel(text);
        add(MAIN);
        MAIN.setFont(MyFrame.EN);
        this.f = f;
        setBackground(MyFrame.DEFAULT);
        addMouseListener(new CustomMouseListener(this));
    }
}
