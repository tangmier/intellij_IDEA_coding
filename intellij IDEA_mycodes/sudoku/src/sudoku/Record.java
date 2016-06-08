package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class Record extends JFrame{
	
	/**
	 * 
	 */
	private class Player
	{
		private int id;
		private String name;
		private int score;
		
		public void setId(int id)
		{
			this.id = id;
		}
		public int getId()
		{
			return this.id;
		}
		public void setName(String name)
		{
			this.name = name;
		}
		public String getName()
		{
			return this.name;
		}
		public void setScore(int score)
		{
			this.score=score;
		}
		public int getScore()
		{
			return this.score;
		}
	}
	private static final long serialVersionUID = 8691044452296756535L;
	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=record";
	private static final String user = "root";
	private static final String password = "123456";

	public Record() throws IOException
	{
		this.setLayout(new GridLayout(3,1,0,0));
		setResizable(false);
		
		JLabel label = new JLabel("Record",JLabel.CENTER);
		label.setFont(new   java.awt.Font("Dialog",   1,   30));
		JButton search = new JButton("查询");
		JButton back = new JButton("返回");
		JPanel record = new JPanel();
		JPanel ButtonSet = new JPanel();
		
		record.setLayout(new GridLayout(6,1,0,0));
		record.add(label);
		readRecord(record);

		ButtonSet.setLayout(new GridLayout(1,2));
		ButtonSet.add(search);
		ButtonSet.add(back);
		
		this.setLayout(new BorderLayout());
		this.add(record,BorderLayout.CENTER);
		this.add(ButtonSet,BorderLayout.SOUTH);
		this.setTitle("record");
		this.setSize(400,280);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		back.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
					
							new Menu();
					
						dispose();
					}
				}
		);
		
		search.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						search();
					}
		});
	}
	
	public void readRecord(JPanel record)
	{


		try {

		// 加载驱动程序

		Class.forName(driver);

		// 连续数据库

		Connection conn = DriverManager.getConnection(url, user, password);

		// statement用来执行SQL语句

		Statement st = conn.createStatement();

		// 要执行的SQL语句

		String sql = "select * from record ORDER BY TIME ASC";
		
		ResultSet rs = st.executeQuery(sql);
		

		int i = 0;
		while(rs.next()) { 
			String name = null;
			int time =0;
		if(i>4)
		break;
		name = rs.getString("name");
		time = rs.getInt("time");
		JLabel label1 = new JLabel(name+"                              "+time+"秒",JLabel.CENTER);
		label1.setBorder(BorderFactory.createLineBorder(Color.white));
		label1.setFont(new   java.awt.Font("Dialog",   1,  20));  
		record.add(label1);
		i++;
		} 
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
	
	public void search()
	{
		String name = JOptionPane.showInputDialog(null,"请输入你想查询的名字：\n","Search",JOptionPane.PLAIN_MESSAGE); 
		
	
		
		try{
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement st = conn.createStatement();
			
			String sql = "select time from record where name = '"+name+"' ORDER BY time ASC" ;
			
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next()){
				JOptionPane.showMessageDialog(null,""+name+"最快的时间记录是:"+rs.getInt("time")+"秒","Search",JOptionPane.PLAIN_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"没有该用户的相关记录","Search",JOptionPane.PLAIN_MESSAGE);
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
