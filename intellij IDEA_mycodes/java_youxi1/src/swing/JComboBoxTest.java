package swing;

import javax.swing.*;
import java.awt.*;

public class JComboBoxTest extends JFrame{
    JComboBox jcombobox1,jcombobox2;
    String cityNames[]={"BEIJING","SHANGHAI","GUANGZHOU","QINGDAO"};
    public JComboBoxTest(){
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        jcombobox1=new JComboBox(cityNames);
        jcombobox1.setSelectedIndex(3);
        jcombobox1.setEditable(false);
        jcombobox2=new JComboBox(cityNames);
        jcombobox2.setSelectedItem(cityNames[1]);
        jcombobox2.setEditable(true);
        jcombobox2.addItem(new String("YANTAI"));
        container.add(jcombobox1);
        container.add(jcombobox2);
        pack();
        setVisible(true);
    }
    public static void main(String args[]){
        JComboBoxTest jcombo=new JComboBoxTest();
        jcombo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}