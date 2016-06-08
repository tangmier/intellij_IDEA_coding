package swing;

import java.awt.*;
import javax.swing.*;

public class JTextFieldTest extends JFrame{
    JTextField jtf;
    public JTextFieldTest() {
        super("JTextField");
        Container container =getContentPane();
        container.setLayout(new FlowLayout());
        jtf=new JTextField("TangXiaoli fighting,2016,be healthy happy successful and well-being",10);
        container.add(jtf);
        pack();
        setVisible(true);
    }
    public static void main(String args[]){
        JTextFieldTest jtft;
        jtft = new JTextFieldTest();
        jtft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}