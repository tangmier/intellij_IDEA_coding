package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyWindow extends JFrame{
    MyWindow(){
        this.setTitle("This is the test window");
        Container c=this.getContentPane();
        c.add(new TetrisPanel());
        this.setBounds(400, 200, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String args[]){
        MyWindow DB=new MyWindow();
        DB.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}