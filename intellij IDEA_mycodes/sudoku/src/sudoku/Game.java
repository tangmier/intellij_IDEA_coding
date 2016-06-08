package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

public class Game extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8121042003075557921L;
	
	JTextField[][] number = new JTextField[9][9];
	String[][] key = new String[9][9];
	int[][] positionI = new int[9][9];
	Date startdate = new Date();//获得当前时间
	
	public Game()
	{	
		int seedArray[][]={  
                {9,7,8,3,1,2,6,4,5},  
                {3,1,2,6,4,5,9,7,8},  
                {6,4,5,9,7,8,3,1,2},  
                {7,8,9,1,2,3,4,5,6},  
                {1,2,3,4,5,6,7,8,9},  
                {4,5,6,7,8,9,1,2,3},  
                {8,9,7,2,3,1,5,6,4},  
                {2,3,1,5,6,4,8,9,7},  
                {5,6,4,8,9,7,2,3,1}  
        }; 
		
		setResizable(false);
		JPanel Sudoku = new JPanel();
		JPanel ButtonSet = new JPanel();
		JButton FinishButton = new JButton("Finish");
		JButton GiveUpButton = new JButton("Give up");
		JButton RestartButton = new JButton("Restart");
		
		ButtonSet.setLayout(new GridLayout(1,3));
		ButtonSet.add(FinishButton);
		ButtonSet.add(GiveUpButton);
		ButtonSet.add(RestartButton);
		
		this.setLayout(new BorderLayout());
		this.setTitle("game");
		this.setSize(400,280);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		GetSudoku(Sudoku,seedArray,creatNineRondomArray(),number);
		
		this.add(Sudoku,BorderLayout.NORTH);
		this.add(ButtonSet,BorderLayout.CENTER);
		
		GiveUpButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						
							new Menu();
					
						dispose();
					}
		});
		
		RestartButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						new Game();
						dispose();
					}
		});
		
		FinishButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						Long ms = (getEndingDate()-getStartDate(startdate))/1000;
						if(checkAnswer(key,positionI,number))
						{
								String name = JOptionPane.showInputDialog(null,"答案正确,请输入你的名字：\n","共用了"+ms+"秒",JOptionPane.PLAIN_MESSAGE); 
								writeRecord(name,ms);
								dispose();
						
									new Menu();
							
								
						}
						else
							JOptionPane.showMessageDialog(null,"答案错误","共用了"+ms+"秒",JOptionPane.ERROR_MESSAGE);
					}
		});
	
	}
	
	public void GetSudoku(JPanel Sudoku,int[][]seedArray,ArrayList<Integer> randomList,JTextField[][] number)
	{
	    JPanel[] Nine =new JPanel[9];
	    createArray(seedArray,randomList);
	    setPanel(Nine);
	    addPanel(Sudoku,Nine);
	    getButtonNumber(number,seedArray);
	    dealWithButton(number,key,positionI);
	    addButton(number,Nine);
	}
	
	 public static ArrayList<Integer> creatNineRondomArray()  
	    {  
	        ArrayList <Integer>list = new ArrayList<Integer>();  
	        Random random=new Random();  
	        for (int i = 0; i < 9; i++) {  
	            int randomNum=random.nextInt(9)+1;  
	            while (true) {  
	                if (!list.contains(randomNum)) {  
	                    list.add(randomNum);  
	                    break;  
	                }  
	                randomNum=random.nextInt(9)+1;  
	            }  
	        }
	          return list;
	     }  
	
	public void createArray(int seedArray[][],ArrayList<Integer> randomList)
	{
		for (int i = 0; i < 9; i++) {  
            for (int j = 0; j < 9; j++) {  
                for (int k = 0; k < 9; k++) {  
                    if(seedArray[i][j]==randomList.get(k))  
                    {  
                        seedArray[i][j]=randomList.get((k+1)%9);  
                        break;  
                    }  
                }  
            }  
        }
	}
	
	public void setPanel(JPanel[] Nine)
	{
		for(int i=0;i<9;i++)
	    {	
	    	Nine[i] = new JPanel();
	  		Nine[i].setLayout(new GridLayout(3,3));
	  		Nine[i].setBorder(BorderFactory.createTitledBorder(""));
	  		Nine[i].setBorder(BorderFactory.createLineBorder(Color.darkGray));
	    }
	}
	
	public void addPanel(JPanel Sudoku,JPanel[] Nine)
	{
		for(int i=0;i<9;i++)
		{
		Sudoku.setLayout(new GridLayout(3,3));
		Sudoku.add(Nine[i]);
		}
	}
	
	public void getButtonNumber(JTextField[][] number,int seedArray[][])
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				String k = String.valueOf(seedArray[i][j]);
				number[i][j] = new JTextField(k);
				number[i][j].setEditable(false);
				number[i][j].setHorizontalAlignment(0);
			}
		}
	}
	
	public void addButton(JTextField[][] number,JPanel[] JPanel)
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(i<=2&&j<=2)
				{	
					JPanel[0].add(number[i][j]);
				}
				if(i<=2&&j<=5&&j>2)
				{	
					JPanel[1].add(number[i][j]);
				}
				if(i<=2&&j<=8&&j>5)
				{	
					JPanel[2].add(number[i][j]);
				}
				if(i<=5&&i>2&&j<=2)
				{
					JPanel[3].add(number[i][j]);
				}
				if(i<=5&&i>2&&j<=5&&j>2)
				{
					JPanel[4].add(number[i][j]);
				}
				if(i<=5&&i>2&&j<=8&&j>5)
				{
					JPanel[5].add(number[i][j]);
				}
				if(i<=8&&i>5&&j<=2)
				{
					JPanel[6].add(number[i][j]);
				}
				if(i<=8&&i>5&&j<=5&&j>2)
				{
					JPanel[7].add(number[i][j]);
				}
				if(i<=8&&i>5&&j<=8&&j>5)
				{
					JPanel[8].add(number[i][j]);
				}
			}
		}
	}
	
	public void dealWithButton(JTextField[][] number,String[][] key,int[][] positionI)
	{
		Random random=new Random(); 
		for(int m=0;m<9;m+=3) {
			for(int n=0;n<9;n+=3) {
				for(int i=0+m;i<3+m;i++) {
					for(int j=(0+n);j<(3+n);j++) {
						int randomNum=random.nextInt(8)+1;  
			            if(randomNum<2)
			            {
			            	key[i][j] = number[i][j].getText();
			            	number[i][j].setText("");
			            	number[i][j].setToolTipText("请填写1-9的数字");
			            	number[i][j].setEditable(true);			
			            	positionI[i][j]=1;
			            }
			        }
				}
			}
		}
	
		
	}
	
	public boolean checkAnswer(String[][] key,int[][] positionI,JTextField[][] number)
	{
		String[][] answer = new String[9][9];
		for(int i = 0; i < 9; i++)
		{
		   for (int j = 0; j < 9; j++) {  
			   if((positionI[i][j]==1)) {
				   answer[i][j] = number[i][j].getText();
			   }
			 
		   }
		}
	
		if (key.length != answer.length) { 
			return false; 
		} else { 
			for (int i = 0; i < key.length; i++){ 
				if (key[i].length != answer[i].length) { 
					return false; 
				} 
				else { 
					if (!Arrays.equals(key[i], answer[i])) { 
						return false; 
					} 
				} 
			}  
		}
		return true; 
	}
	
	public Long getStartDate(Date startdate)
	{
		Long startms = startdate.getTime();//获得毫秒值
		return startms;
	}
	
	public Long getEndingDate()
	{
		Date endingdate = new Date();
		Long endingms = endingdate.getTime();
		return endingms;
	}
	
	public void writeRecord(String name,Long ms)
	{
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		// URL指向要访问的数据库名scutcs

		String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=record";

		// MySQL配置时的用户名

		String user = "root";

		// Java连接MySQL配置时的密码

		String password = "root";

		try {

		// 加载驱动程序

		Class.forName(driver);

		// 连续数据库

		Connection conn = DriverManager.getConnection(url, user, password);

		// statement用来执行SQL语句

		Statement st = (Statement) conn.createStatement();

		// 要执行的SQL语句

		String sql = "INSERT INTO record (name,time) VALUES ('"+name+"','"+ms+"')";
		
		st.executeUpdate(sql);
		
		st.close();
		conn.close();
		}catch(ClassNotFoundException e) {   
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
			} catch(SQLException e) {   
			e.printStackTrace();   
			} catch(Exception e) {   
			e.printStackTrace();   
			}   
		
	}
}
