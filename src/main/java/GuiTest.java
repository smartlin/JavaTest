import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by starlin
 * on 2015/10/08 9:45.
 */
public class GuiTest {
    private JPanel panel1;
    private JButton btnOK;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;

    public GuiTest() {

        btnOK.addMouseListener(new MouseAdapter() {
            @Override
            //鼠标点击事件顺序：mousePressed > mousePressed > mouseClicked(判断按下与抬起是否在同一位置    )
            public void mouseClicked(MouseEvent e) {//鼠标点击
                super.mouseClicked(e);
                System.out.println("鼠标点击事件");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("鼠标按下");
                System.out.println("点击位置：x---->" + e.getX());//getX()取得鼠标的横向坐标
                System.out.println("点击位置：y---->" + e.getY());//getY()取得鼠标的纵向坐标
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println("鼠标松开");
            }

            @Override
            public void mouseEntered(MouseEvent e) {//鼠标进入
                super.mouseEntered(e);
                System.out.println("鼠标进入事件");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                System.out.println("鼠标离开事件");
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });


    }

    public void paint(Graphics g){
        g.drawString("游戏",20,40);
        g.drawOval(20,40,40,40);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GuiTest");
        frame.setContentPane(new GuiTest().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口结束程序
        frame.pack();
        frame.setVisible(true);//设置窗体是否显示
        frame.setTitle("测试");//设置标题
        //      frame.setSize(200,200);//设置窗体大小
//        frame.setLocation(500,200);//设置窗体初始位置
        frame.setResizable(true);//设置窗体大小是否可以改变 false：不能；true：可以
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//        System.out.println(width + "===" +height);
        frame.setLocation((width-200)/2,(height-200)/2);//设置窗体初始位置

//        int result =  JOptionPane.showConfirmDialog(frame,"我的确认信息");//
//        System.out.println(result);
//        if(result == 0 ){
//            JOptionPane.showMessageDialog(frame,"开始");//弹出信息，主要用来提示信息
//        }else if(result == 1){
//            JOptionPane.showMessageDialog(frame,"结束");//弹出信息，主要用来提示信息
//        }else{
//            JOptionPane.showMessageDialog(frame,"重新选择");//弹出信息，主要用来提示信息
//        }

        String username = JOptionPane.showInputDialog("请输入姓名： ");//showInputDialog()显示一个输入对话框
        if(username!=null){
            System.out.println(username);
            JOptionPane.showMessageDialog(frame,"输入的姓名：" + username);
        }else{
            JOptionPane.showMessageDialog(frame,"请重新输入的姓名");
        }





    }
}
