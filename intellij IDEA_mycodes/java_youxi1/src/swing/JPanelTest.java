package swing;

import javax.swing.*;
import java.awt.*;

public class JPanelTest extends JFrame{
    JButton[] buttons;
    JPanel panel1;
    CustomPanel panel2;
    public JPanelTest(){
        super("JPanelTest");
        Container container=getContentPane();
        container.setLayout(new BorderLayout());
        panel1=new JPanel(new FlowLayout());
        buttons=new JButton[4];
        for(int i=0;i<buttons.length;i++){
            buttons[i]=new JButton("anniu"+(i+1));
            panel1.add(buttons[i]);
            }
        panel2=new CustomPanel();
        container.add(panel1,BorderLayout.NORTH);
        container.add(panel2,BorderLayout.CENTER);
        pack();
        setVisible(true);
        }
    public static void main(String args[]){
        JPanelTest jpe=new JPanelTest();
        jpe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class CustomPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawString("Welcome to Java Shape World", 20, 20);
            g.drawRect(20, 40, 130, 130);
            g.setColor(Color.green);
            g.fillRect(20, 40, 130, 130);
            g.drawOval(160, 40, 100, 100);
            g.setColor(Color.orange);
            g.fillOval(160,40,100,100);
            }
        public Dimension getPreferredSize(){
            return new Dimension(200,200);
        }
    }
}