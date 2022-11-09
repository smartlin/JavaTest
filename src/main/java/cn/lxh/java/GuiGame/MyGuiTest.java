package cn.lxh.java.GuiGame;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by starlin
 * on 2015/10/12 10:23.
 */
public class MyGuiTest extends JFrame implements MouseListener{
    public MyGuiTest(){
        this.setTitle("五子棋");
        this.setSize(700,600);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口结束程序
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation((width - 200) / 2, (height - 200) / 2);//设置窗体初始位置
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
//        g.drawString("123",60,60);
//        g.drawRect(90,90,20,20);//绘制空心的矩形
//        g.fillRect(100,90,20,20);//绘制实心的矩形
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("d:" + File.separator + "1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image,100,100,this);
        g.drawOval(100,100,20,20);//绘制空心的圆
        g.fillOval(80,80,20,20);//绘制实心的圆
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标点击");
        JOptionPane.showMessageDialog(this,"鼠标点击");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

