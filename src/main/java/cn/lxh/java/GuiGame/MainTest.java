package cn.lxh.java.GuiGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTest {
    public static void main(String[] args) {
        final int n;
        n = (int) (Math.random() * 100);// ????????
        JFrame f = new JFrame("?????????");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//?????????????
        f.setSize(300, 300);
        f.setVisible(true);
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(5, 1));
        Label lb = new Label("???????????????");
        contentPane.add(lb);
        Label lb1 = new Label("????????,???????????:");
        contentPane.add(lb1);
        final TextField t = new TextField();
        contentPane.add(t);
        JButton b = new JButton("???");
        contentPane.add(b);
        final Label lb2 = new Label();
        contentPane.add(lb2);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String d = null;
                if (Integer.parseInt(t.getText()) == n) {
                    d = "????";
                }
                if (Integer.parseInt(t.getText()) > n) {
                    d = "????";
                }
                if (Integer.parseInt(t.getText()) < n) {
                    d = "��??";
                }
                lb2.setText(d);
            }
        });
    }
}