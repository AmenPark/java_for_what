package com.PAM.testPack;

import java.awt.AWTException;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * 다형성에서 Human을 상속받은 Student에 대해서, Student로 만든걸 Human에 넣어도 Student class이다.
 * 넣는건 그렇다 치는데 그럼 어떻게 써야하지? 오버라이딩만이 답인가?
 * 
 */
public class testMain {
	public static void planetMain() {
		Planet earth = new Planet("지구");
		earth.setSize(500);
		earth.setObservable(true);

		Human h = new Human("홍길동");
		System.out.println(h.getClass());

		Human h2 = new Student("김길동", 13);
		System.out.println(h2.getClass());

		earth.enroll(h);

		Ironman i = new Ironman();
		h.setHero(i);
		h.scream();

	}

	public static void testJFrameMain() {
		final int W = 800;
		final int H = 800;
		JFrame jf = new JFrame("title");
		jf.setSize(W, H);
		jf.setVisible(true);

		JButton b1 = new JButton("홍길동");
		b1.setSize(W / 10, H / 10);
		b1.setVisible(true);
		jf.add(b1);
		b1.setLocation(W / 20 * 3, H / 20 * 10);
		
		JFileChooser c = new JFileChooser();
		
		JTextField jtf = new JTextField("String", 15);
		jf.add(jtf);
		jtf.setVisible(true);
		jtf.setSize(W/10*3,H/10);
		
		ActionListener act = new ActionListener() {
			private int ct;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ct++;
				jtf.setText("Button clicked "+ct);
			}
		};
		
		b1.addActionListener(act);
		
		
		
	}
	
	public static void useJFrameTest() {

		Doctor d = new Doctor();
		
		JFrame jf = new JFrame("비만도 테스트");
		GridLayout GL = new GridLayout(4, 2);
		jf.setLayout(GL);
		JLabel name = new JLabel("이름:");
		JTextField ntf = new JTextField();
		JLabel height = new JLabel("키:");
		JTextField htf = new JTextField();
		JLabel weight = new JLabel("몸무게");
		JTextField wtf = new JTextField();
		
		jf.add(name);
		jf.add(ntf);
		jf.add(height);
		jf.add(htf);
		jf.add(weight);
		jf.add(wtf);
		
		JButton cn = new JButton("확인");
		JLabel ch = new JLabel("계산");

		ActionListener check = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.name = ntf.getText();
				d.weight = Double.parseDouble(wtf.getText());
				d.height = Double.parseDouble(htf.getText());
				
				if (d.height>3) {
					d.height/=100;
				}
				double bmi = d.weight / d.height / d.height;
				ch.setText(bmi+"");
			}
		};
		cn.addActionListener(check);

		
		jf.add(cn);
		jf.add(ch);
		
		jf.setSize(500,500);
		jf.setVisible(true);
		
	}
	
	public static void useRobotTest() throws AWTException, InterruptedException {
		Robot r = new Robot();
		
		r.mouseMove(50, 50);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_F11);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_F11);
		
	}
	public static void main(String[] args) throws AWTException, InterruptedException {
//		planetMain();
//		testJFrameMain();
//		useJFrameTest();
		useRobotTest();

	}
}
