package swing;

import javax.swing.*;
import java.awt.*;
class Favorite extends JPanel{
    JCheckBox sport,computer,music,read;
    Favorite(){
        sport =new JCheckBox("sport");
        computer =new JCheckBox("computer");
        music =new JCheckBox("music");
        read =new JCheckBox("read");
        add(new JLabel("hobby"));
        add(sport);
        add(computer);
        add(music);
        add(read);
        sport.setSelected(false);
        computer.setSelected(false);
        music.setSelected(false);
        read.setSelected(false);
    }
}