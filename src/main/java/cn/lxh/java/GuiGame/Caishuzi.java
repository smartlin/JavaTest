package cn.lxh.java.GuiGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by starlin
 * on 2015/10/12 14:01.
 */
public class Caishuzi {
    public static void main(String[] args) {
        final int n;
        n = (int) (Math.random() * 100);//
        JFrame f = new JFrame("²ÂÊý×Ö");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(5, 1));
        Label lb = new Label("cai shuzi shuo ming");
        contentPane.add(lb);
        final TextField t = new TextField();
        contentPane.add(t);
        JButton b = new JButton("Enter");
        contentPane.add(b);
        final Label lb2 = new Label();
        contentPane.add(lb2);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String d = null;
                if (Integer.parseInt(t.getText()) == n) {
                    d = "right";
                }
                if (Integer.parseInt(t.getText()) > n) {
                    d = "too large";
                }
                if (Integer.parseInt(t.getText()) < n) {
                    d = "too small";
                }
                lb2.setText(d);
            }
        });
    }
}
