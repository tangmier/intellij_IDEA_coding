package sudoku;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Menu extends JFrame{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 987868659970693475L;

	public Menu()
	{
	
		setLayout(new BorderLayout(0,0));
		setResizable(false);
		
		JLabel Sudoku = new JLabel("Sudoku",SwingConstants.CENTER);
		JLabel Blank = new JLabel();
		Sudoku.setVerticalAlignment(SwingConstants.BOTTOM);
		Sudoku.setFont(new   java.awt.Font("Dialog",   1,   50));
		JButton GameStart = new JButton("开始游戏");
		JButton Record = new JButton("历史记录");
		JButton Record2= new JButton("其他系统记录");
		JButton Exit = new JButton("离开游戏");
		
		JPanel Panel1 = new JPanel();
		JPanel Panel2 = new JPanel();
		JPanel Panel3 = new JPanel();
		
		Panel1.add(Sudoku);
		Panel2.add(GameStart);
		Panel2.add(Record);
		Panel2.add(Record2);
		Panel2.add(Exit);
		
		Panel3.add(Blank);
		add(Panel3,BorderLayout.NORTH);
		add(Panel1,BorderLayout.CENTER);
		add(Panel2,BorderLayout.SOUTH);
		
		this.setTitle("sudoku");
		this.setSize(400,280);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		GameStart.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						new Game();	
						dispose();
					//	setVisible(false);
					}
				}
			);
			
		Record.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){							
						try {
							new Record();
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						dispose();
					//	setVisible(false);
					}	
				}
			);
		
		Record2.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){							
						try {
							new Record2();
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						dispose();
					//	setVisible(false);
					}	
				}
			);
			
		Exit.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
					}
				}
			);
	}
	
}
