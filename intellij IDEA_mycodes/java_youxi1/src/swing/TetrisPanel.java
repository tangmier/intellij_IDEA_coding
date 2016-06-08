package swing;

import java.awt.*;
import javax.swing.JPanel;

public class TetrisPanel extends JPanel implements Runnable{
    public int ypos=-80;
    private Image iBuffer;
    private Graphics gBuffer;
    public TetrisPanel(){
        Thread t=new Thread(this);
        t.start();
        }
    public void run(){
        while(true){
           try{
             Thread.sleep(30);
           } catch(InterruptedException e){}
            ypos+=5;
            if(ypos>300)
                ypos=-80;
            repaint();
        }
    }
    public void paint(Graphics g){
        if(iBuffer==null){
            iBuffer=createImage(this.getSize().width,this.getSize().height);
            gBuffer=iBuffer.getGraphics();
        }
//        gBuffer.setColor(getBackground());
          super.paint(g);
//        gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);
            g.clearRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.green);
        g.fillOval(90,ypos,80,80);
        //g.drawImage(iBuffer,0,0,this);
    }
//    public void update(Graphics g){
//        paint(g);
//    }
}