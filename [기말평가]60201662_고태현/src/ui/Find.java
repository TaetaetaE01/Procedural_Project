package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.SFind;
import valueObject.VPersonalInfo;

@SuppressWarnings("serial")
public class Find extends JFrame {

	public void findid() {
		JFrame frame = new JFrame();
		setTitle("아이디 찾기");
		this.setSize(400, 200); // 맨 처음 창 크기
		setLocationRelativeTo(null); // 창 띄웠을 때 가운데 고정
		setResizable(false);// 창 크기 고정

		JPanel panelfindid = new JPanel();
		panelfindid.setBackground(Color.white);
		setContentPane(panelfindid);
		panelfindid.setLayout(null);

		JLabel labeltext = new JLabel("학번을 입력해주세요");
		JLabel labelnum = new JLabel("학번 : ");
		JTextField textnum = new JTextField(10);

		panelfindid.add(labeltext);
		labeltext.setBounds(77, 15, 151, 24);

		panelfindid.add(labelnum);
		labelnum.setBounds(77, 47, 47, 24);

		panelfindid.add(textnum);
		textnum.setBounds(135, 49, 132, 24);

		JButton confirmBtn = new JButton("확 인");
		confirmBtn.setBounds(177, 93, 97, 23);
		panelfindid.add(confirmBtn);

		// 확인 눌렀을때 팝업창
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.findid = textnum.getText();

				try {
					SFind sFind = new SFind();
					vPersonalInfo = sFind.findid(vPersonalInfo);
					if (vPersonalInfo != null) {
						JOptionPane.showMessageDialog(null,
								vPersonalInfo.name1 + "님의 아이디는 " + "'" + vPersonalInfo.id1 + "'" + "입니다");
					} else {
						JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Find find = new Find();
				find.findid();
				dispose();
			}
		});

	}

	public void findpw() {

		JFrame frame1 = new JFrame();

		setTitle("패스워드 찾기");
		this.setSize(400, 200); // 맨 처음 창 크기
		setLocationRelativeTo(null); // 창 띄웠을 때 가운데 고정
		setResizable(false);// 창 크기 고정

		JPanel panelfindpw = new JPanel();
		panelfindpw.setBackground(Color.white);
		setContentPane(panelfindpw);
		panelfindpw.setLayout(null);

		JLabel labeltext2 = new JLabel("아이디를 입력해주세요");
		JLabel labelid = new JLabel("아이디 : ");
		JTextField textid = new JTextField(10);

		panelfindpw.add(labeltext2);
		labeltext2.setBounds(77, 15, 151, 24);

		panelfindpw.add(labelid);
		labelid.setBounds(77, 47, 47, 24);

		panelfindpw.add(textid);
		textid.setBounds(135, 49, 132, 24);

		JButton confirmBtn = new JButton("확 인");
		confirmBtn.setBounds(177, 93, 97, 23);
		panelfindpw.add(confirmBtn);

		// 확인 눌렀을때 팝업창
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.findpw = textid.getText();

				try {
					SFind sFind = new SFind();
					vPersonalInfo = sFind.findpw(vPersonalInfo);
					if (vPersonalInfo != null) {
						JOptionPane.showMessageDialog(null,
								vPersonalInfo.name1 + "님의 패스워드는 " + "'" + vPersonalInfo.password1 + "'" + "입니다");
					} else {
						JOptionPane.showMessageDialog(null, "존재하지 않는 패스워드입니다.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Find find = new Find();
				find.findpw();
				dispose();
			}
		});
	}
}
