package swing_tut;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;  

class JLabel_test implements ActionListener{  
	JTextField tf;
	JLabel l1;
	JButton b;

	Random generator = new Random();

	JLabel_test(){
		JFrame f= new JFrame("Label Example"); 
		tf = new JTextField();
		tf.setBounds(50, 50, 100, 30);
		f.add(tf);

		l1=new JLabel();  
		l1.setBounds(50,150, 400,30);   
		f.add(l1);

		b = new JButton("Get random number between 0 and number you chose");
		b.setBounds(50,100,400,30);
		b.addActionListener(this);
		f.add(b);

		f.setSize(500,300);  
		f.setLayout(null);  
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {  
		try{  
			Integer number = Integer.parseInt(tf.getText().trim());
			if(number <= 0) throw new Exception("number less or equal than 0"); 
			double d1 = generator.nextDouble();
			int rn = (int) (0 + Math.round(d1*(number -0)));
			l1.setText(rn + "");  
		}catch(Exception ex){
			System.out.println(ex);
			String errorcause = tf.getText();
			
			if(ex.getMessage().equals("number less or equal than 0"))
				l1.setText("Please enter a number greater than 0");
			else if(errorcause.isEmpty() || errorcause.trim().isEmpty())
				l1.setText("Please enter a valid number");
			else
				l1.setText(errorcause.trim() + " is not a valid entry, please enter a valid number");
		}  
	}  

	public static void main(String args[])  
	{  
		new JLabel_test();
	}  
}  