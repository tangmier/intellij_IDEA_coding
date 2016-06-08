package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**测试swing中Timer的使用，一个显示时间的GUI程序**/
public class TimerTest extends JFrame implements ActionListener{
    //一个显示时间的JLabel
    private JLabel jlTime=new JLabel();
    private Timer timer;
    public TimerTest(){
        setTitle("Timer test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(180,80);
        add(jlTime);
        //设置Timer定时器并启动
        timer = new Timer(500,this);
        timer.start();
        setVisible(true);
    }
    /**Timer要执行的部分**/
    public void actionPerformed(ActionEvent e){
        DateFormat format=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date date=new Date();
        jlTime.setText(format.format(date));
    }
    public static void main(String[] args){
        new TimerTest();
    }
}