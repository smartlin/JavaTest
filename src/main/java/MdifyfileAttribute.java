/**
 * 获取文件属性
 * */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
 
public class MdifyfileAttribute extends JFrame implements ActionListener{
    JButton chooseButton = new JButton("浏览...");
    JLabel nameLabel = new JLabel();
    JLabel sizelabel = new JLabel("文件大小");
    JLabel pathLabel = new JLabel("文件路径");
    JLabel uriLabel = new JLabel("URI路径");
    JLabel datelabel = new JLabel("最后修改日期");
 
    JTextField sizeField = new JTextField(30);
    JTextField pathField = new JTextField(30);
    JTextField uriField = new JTextField(30);
    JTextField dateField = new JTextField(30);
 
    JCheckBox readCheckBox = new JCheckBox("可读");
    JCheckBox writeCheckBox = new JCheckBox("可写");
    JCheckBox hideCheckBox = new JCheckBox("隐藏");
 
    JPanel panel = new JPanel();
 
    public MdifyfileAttribute(){
        panel.setLayout(new FlowLayout());
        panel.add(chooseButton);
        panel.add(nameLabel);
        panel.add(sizelabel);
        panel.add(sizeField);
        panel.add(pathLabel);
        panel.add(pathField);
        panel.add(uriLabel);
        panel.add(uriField);
        panel.add(datelabel);
        panel.add(dateField);
        JPanel checkPanel = new JPanel();
        checkPanel.add(readCheckBox);
        checkPanel.add(writeCheckBox);
        checkPanel.add(hideCheckBox);
        panel.add(checkPanel);
        setContentPane(panel);
 
        chooseButton.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e){
                JFileChooser chooser = new JFileChooser();
                // 显示文件选择对话框
                chooser.showOpenDialog(MdifyfileAttribute.this);
                File file = chooser.getSelectedFile();
                if(file != null){
                    nameLabel.setText(file.getName());
                    sizeField.setText(file.length() + "");
                    pathField.setText(file.getPath());
                    uriField.setText(file.toURI() + "");
                    dateField.setText(new Date(file.lastModified()) + "");
                    readCheckBox.setSelected(file.canRead());
                    writeCheckBox.setSelected(file.canWrite());
                    hideCheckBox.setSelected(file.isHidden());
                }
            }
        });
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
 
    public static void main(String[] args){
        new MdifyfileAttribute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}