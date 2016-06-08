package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JRadioButtonTest{
    JFrame f = null;
    JRadioButtonTest(){
        f=new JFrame("RadioTest");  //����һ��JFrame�Ķ���
        Container contentPane=f.getContentPane();// ����һ�������������
        contentPane.setLayout(new FlowLayout());//���øô��ڵĲ���
        JPanel p1=new JPanel();//����һ��������
        p1.setLayout(new GridLayout(1, 3));//���ò��ֹ������ĸ�ʽ
        p1.setBorder(BorderFactory.createTitledBorder("WHICH ONE?"));
        JRadioButton r1=new JRadioButton();
        r1.setText("BEIJING");
        JRadioButton r2=new JRadioButton("SHANGHAI");
        JRadioButton r3=new JRadioButton("GUANGZHOU");
        p1.add(r1);
        p1.add(r2);
        p1.add(r3);
        r1.setSelected(true);

        contentPane.add(p1);//������p1��ӵ������������������
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {   //���һ�����ڼ�����
                       @Override
            public void windowClosing(WindowEvent e) {
                           System.exit(0);
            }
        });
    }
    public static void main(String args[]){
        new JRadioButtonTest();
    }
}