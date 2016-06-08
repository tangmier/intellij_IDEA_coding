package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class TetrisPanel2 extends JPanel implements Runnable,KeyListener{
    public int ypos=-80,xpos=90;
    public TetrisPanel2(){
        Thread t=new Thread(this);  //创建一个新线程
        t.start();  //启动线程
        //设定焦点在本面板并作为监听对象
        setFocusable(true);
        addKeyListener(this);
    }
    public void run(){  //重载run()方法
        while(true){
            try{
                Thread.sleep(30); //线程休眠30ms
            }catch (InterruptedException e){}
            ypos+=5;
            if(ypos>300)
                ypos=-80;
            repaint();
        }
    }
    public void paint(Graphics g){
        g.clearRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.green);
        g.fillOval(xpos,ypos,80,80);
    }
    public void keyPressed(KeyEvent e){
        int keyCode=e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_LEFT:
                xpos-=10;
                break;
            case KeyEvent.VK_RIGHT:
                xpos+=10;
                break;
        }
        repaint();
    }
    public void keyReleased(KeyEvent arg0){
    }
    public void keyTyped(KeyEvent arg0){
    }
}