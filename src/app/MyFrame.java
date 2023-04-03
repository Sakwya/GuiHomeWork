package app;
import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame{
    private GridBagLayout gbl = new GridBagLayout();//网格包布局管理器
    private GridBagConstraints gbc = new GridBagConstraints();
    private void addComponent(Component comp){
        gbl.setConstraints(comp,gbc);
        this.add(comp);
    }
    private MenuBar initMenu(){
        //菜单栏
        MenuBar mb = new MenuBar();
        //添加菜单
        Menu mSelect = new Menu("Select");
        Menu mHelp = new Menu("Help");
        mb.add(mSelect);
        mb.add(mHelp);
        //添加菜单选单-曲线选择
        MenuItem miSin = new MenuItem("Sin");
        MenuItem miCos = new MenuItem("Cos");
        MenuItem miX = new MenuItem("X");
        MenuItem miLn = new MenuItem("Ln");
        mSelect.add(miSin);
        mSelect.add(miCos);
        mSelect.add(miX);
        mSelect.add(miLn);
        //添加菜单选单-帮助
        MenuItem miHelp = new MenuItem("Help");
        MenuItem miQuit = new MenuItem("Quit");
        mHelp.add(miHelp);
        mHelp.add(miQuit);
        return mb;
    }
    public MyFrame(){
        this.setBounds(100, 100, 400, 300);
        this.setLayout(gbl);
        /**流式布局管理器FlowLayout()
         * 边框布局管理器BorderLayout()
         * 网格布局管理器GridLayout()
         * 卡片布局管理器CardLayout() */
        this.setMenuBar(initMenu());

        gbc.fill = GridBagConstraints.BOTH;
        //NONE：不调整组件大小。
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
        //VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
        //BOTH：使组件完全填满其显示区域。
        gbc.weighty=1;
        gbc.weightx=1;
        Button but1 = new Button("sinX");
        Button but2 = new Button("cosX");
        Button but3 = new Button("tanX");
        Button but4 = new Button("lnX");
        addComponent(but1);
        addComponent(but2);
        addComponent(but3);
        addComponent(but4);
        Button[] bt=new Button[10];
        for(int i=0;i<10;i++){
            bt[i]=new Button("btn"+i);
        }
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        addComponent(bt[0]);
        gbc.gridwidth = 1;
        addComponent(bt[1]);
        gbc.weightx=2;
        addComponent(bt[2]);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addComponent(bt[3]);

        but1.setBackground(Color.white);
        but2.setBackground(Color.white);
        but3.setBackground(Color.white);
        but4.setBackground(Color.white);

        this.setVisible(true);//显示
    }
}
