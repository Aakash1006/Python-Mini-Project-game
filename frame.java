package gui;

import java.awt.EventQueue;
import java.awt.Frame;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;


public class frame extends JFrame {

	private JFrame frame;
	private JTextField pointstext;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btns[];
	private int points=0;
	private int temp=0;
	private int y=0;
	private int go=0;
	private int check=0;
	
	private JTextField timer;
	private JTextField goal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame window = new frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	class countdown{
		
		Timer t=new Timer();
		
		TimerTask task=new TimerTask() {
			public void run() {
				if(temp>0) {	
				temp--;
				timer.setText(String.valueOf(temp));
				}
				else {
					task.cancel();
					t.cancel();
				}
;
				}};
		public void cd(int sec) {
			temp=sec; 
			t.scheduleAtFixedRate(task, 1000, 1000);
			};
	};
	
	class game extends countdown{
				
		
		public void gam(Object[] btns) {
			int x;
		
			if(temp<=0) {
				JOptionPane.showMessageDialog(null, "Time Up!");
				result();
			}
			else {
				
				Random rnd =new Random();
				x=rnd.nextInt(9);
				((JButton) btns[x]).setBackground(Color.RED);
				((JButton) btns[x]).setText("Click!");
				check=1;
				((JButton) btns[x]).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						((JButton) btns[x]).setBackground(Color.ORANGE);
						((JButton) btns[x]).setText("");
						points++;
						pointstext.setText(String.valueOf(points));
						if(points==go) {
							temp=0;
							JOptionPane.showMessageDialog(null, "YOU WIN!!");
							((JButton) btns[x]).setBackground(Color.ORANGE);
							((JButton) btns[x]).setText("");
							result();
						}
						else	
							gam(btns);	
						}
				});
				for(int i=0;i<10;i++) {
					if(i!=x) {
						((JButton) btns[i]).addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								temp=0;
								JOptionPane.showMessageDialog(null,"Wrong button pressed!");
								((JButton) btns[x]).setBackground(Color.ORANGE);
								((JButton) btns[x]).setText("");
								result();
							}
						});
					}		
				}
			}
		}
	}

	public frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void result(){
		
		check=0;
		String s="<html><body>Thank You for Playing!"+" <br><br>"+  "Your Score=";
		String s1="<html><body>You Lost!"+"<br><br>"+"But don't worry, select a easier level next time.(Assuming you didn't fail on the easiest level)";
		if(points<go) {
			JOptionPane.showMessageDialog(null, s1);
		}
		JOptionPane.showMessageDialog(null, s+points);
		points=0;
		pointstext.setText(String.valueOf(points));
		timer.setText(String.valueOf(y));
		for(int i=0;i<10;i++)
		{
			((JButton) btns[i]).setBackground(Color.ORANGE);
		}
	};
	private void initialize() {
		frame = new JFrame("Click before you BLINK!");
		
		frame.setBounds(100, 100, 629, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("");	
		btn1.setBackground(Color.ORANGE);
		btn1.setBounds(10, 11, 144, 119);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("");	
		btn2.setBackground(Color.ORANGE);
		btn2.setBounds(164, 11, 144, 119);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setBackground(Color.ORANGE);
		btn3.setBounds(318, 11, 144, 119);
		frame.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setBackground(Color.ORANGE);
		btn4.setBounds(10, 141, 144, 119);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setBackground(Color.ORANGE);
		btn5.setBounds(164, 141, 144, 119);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setBackground(Color.ORANGE);
		btn6.setBounds(318, 141, 144, 119);
		frame.getContentPane().add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setBackground(Color.ORANGE);
		btn7.setBounds(10, 274, 144, 119);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setBackground(Color.ORANGE);
		btn8.setBounds(164, 274, 144, 119);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.setBackground(Color.ORANGE);
		btn9.setBounds(318, 274, 144, 119);
		frame.getContentPane().add(btn9);
			
		JRadioButton rbtne = new JRadioButton("Easy");
		rbtne.setBounds(496, 52, 92, 23);
		frame.getContentPane().add(rbtne);
		
		JRadioButton rbtnm = new JRadioButton("Medium");
		rbtnm.setBounds(496, 78, 92, 23);
		frame.getContentPane().add(rbtnm);
		
		JRadioButton rbtnh = new JRadioButton("Hard");
		rbtnh.setBounds(496, 104, 92, 23);
		frame.getContentPane().add(rbtnh);
		
		ButtonGroup bg1 = new ButtonGroup( );

		bg1.add(rbtne);
		bg1.add(rbtnm);
		bg1.add(rbtnh);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton[] btns=new JButton[9];
				btns[0]=btn1;
				btns[1]=btn2;
				btns[2]=btn3;
				btns[3]=btn4;
				btns[4]=btn5;
				btns[5]=btn6;
				btns[6]=btn7;
				btns[7]=btn8;
				btns[8]=btn9;
				if(check==1)
					JOptionPane.showMessageDialog(null,"Game already started");
				else {
					points=0;
				
				game g=new game();
				countdown c=new countdown();
				if(rbtne.isSelected()) {
					c.cd(60);
					y=60;
					go=40;
					g.gam(btns);
				}
				if(rbtnm.isSelected()) {
					c.cd(30);
					y=30;
					go=30;
					g.gam(btns);
				}
				if(rbtnh.isSelected()) {
					c.cd(15);
					y=10;
					go=30;
					g.gam(btns);
				}
				else 
					JOptionPane.showMessageDialog(null, "Set the difficulty");
			}
			}
		});
		
		btnStart.setBounds(10, 406, 452, 23);
		frame.getContentPane().add(btnStart);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setFont(new Font("Hobo Std", Font.PLAIN, 13));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setBounds(486, 282, 92, 23);
		frame.getContentPane().add(lblPoints);
		
		pointstext = new JTextField();
		pointstext.setHorizontalAlignment(SwingConstants.CENTER);
		pointstext.setBounds(508, 307, 49, 23);
		frame.getContentPane().add(pointstext);
		pointstext.setColumns(10);
		pointstext.setText("0");
		
		JLabel lblTimer = new JLabel("Timer (s)");
		lblTimer.setFont(new Font("Hobo Std", Font.PLAIN, 13));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(483, 202, 95, 23);
		frame.getContentPane().add(lblTimer);
		
		timer = new JTextField();
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setBounds(486, 225, 92, 23);
		frame.getContentPane().add(timer);
		timer.setColumns(10);
		timer.setText("Select Difficulty");
		
		JLabel lblDifficultyLevel = new JLabel("Difficulty Level");
		lblDifficultyLevel.setFont(new Font("Hobo Std", Font.PLAIN, 13));
		lblDifficultyLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficultyLevel.setBounds(486, 31, 99, 14);
		frame.getContentPane().add(lblDifficultyLevel);
		
		JButton btnSet = new JButton("SET");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtne.isSelected()) {
					timer.setText("60");
					goal.setText("40");
				}
				if(rbtnm.isSelected()) {
					timer.setText("30");
					goal.setText("30");
				}
				if(rbtnh.isSelected()) {
					timer.setText("10");
					goal.setText("30");
				}
			}
		});
		btnSet.setBounds(489, 141, 89, 23);
		frame.getContentPane().add(btnSet);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(473, 11, 122, 170);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(472, 192, 122, 68);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(472, 274, 122, 65);
		frame.getContentPane().add(panel_2);
		
		JLabel lblGoal = new JLabel("Goal");
		lblGoal.setFont(new Font("Hobo Std", Font.PLAIN, 13));
		lblGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoal.setBounds(496, 362, 68, 23);
		frame.getContentPane().add(lblGoal);
		
		goal = new JTextField();
		goal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		goal.setHorizontalAlignment(SwingConstants.CENTER);
		goal.setText("Select Difficulty");
		goal.setBounds(486, 395, 92, 23);
		frame.getContentPane().add(goal);
		goal.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(472, 350, 122, 79);
		frame.getContentPane().add(panel_3);
		
		
			
	}
}
 
