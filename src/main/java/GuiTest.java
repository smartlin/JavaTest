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
            //������¼�˳��mousePressed > mousePressed > mouseClicked(�жϰ�����̧���Ƿ���ͬһλ��    )
            public void mouseClicked(MouseEvent e) {//�����
                super.mouseClicked(e);
                System.out.println("������¼�");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("��갴��");
                System.out.println("���λ�ã�x---->" + e.getX());//getX()ȡ�����ĺ�������
                System.out.println("���λ�ã�y---->" + e.getY());//getY()ȡ��������������
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println("����ɿ�");
            }

            @Override
            public void mouseEntered(MouseEvent e) {//������
                super.mouseEntered(e);
                System.out.println("�������¼�");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                System.out.println("����뿪�¼�");
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
        g.drawString("��Ϸ",20,40);
        g.drawOval(20,40,40,40);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GuiTest");
        frame.setContentPane(new GuiTest().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ��ڽ�������
        frame.pack();
        frame.setVisible(true);//���ô����Ƿ���ʾ
        frame.setTitle("����");//���ñ���
        //      frame.setSize(200,200);//���ô����С
//        frame.setLocation(500,200);//���ô����ʼλ��
        frame.setResizable(true);//���ô����С�Ƿ���Ըı� false�����ܣ�true������
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//        System.out.println(width + "===" +height);
        frame.setLocation((width-200)/2,(height-200)/2);//���ô����ʼλ��

//        int result =  JOptionPane.showConfirmDialog(frame,"�ҵ�ȷ����Ϣ");//
//        System.out.println(result);
//        if(result == 0 ){
//            JOptionPane.showMessageDialog(frame,"��ʼ");//������Ϣ����Ҫ������ʾ��Ϣ
//        }else if(result == 1){
//            JOptionPane.showMessageDialog(frame,"����");//������Ϣ����Ҫ������ʾ��Ϣ
//        }else{
//            JOptionPane.showMessageDialog(frame,"����ѡ��");//������Ϣ����Ҫ������ʾ��Ϣ
//        }

        String username = JOptionPane.showInputDialog("������������ ");//showInputDialog()��ʾһ������Ի���
        if(username!=null){
            System.out.println(username);
            JOptionPane.showMessageDialog(frame,"�����������" + username);
        }else{
            JOptionPane.showMessageDialog(frame,"���������������");
        }





    }
}
