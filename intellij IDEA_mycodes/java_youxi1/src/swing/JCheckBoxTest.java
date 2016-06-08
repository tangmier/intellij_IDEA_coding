package swing;

import javax.swing.*;
import java.awt.*;
public class JCheckBoxTest extends JFrame{
    public JCheckBoxTest(){
        super("JCheckBox");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        Favorite f=new Favorite();
        container.add(f);
        pack();
        setVisible(true);
    }
    public static void main(String args[]){
        JCheckBoxTest jcbt=new JCheckBoxTest();
        jcbt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}