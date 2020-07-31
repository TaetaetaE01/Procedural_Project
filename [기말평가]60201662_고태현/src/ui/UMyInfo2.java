package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import valueObject.VPersonalInfo;

public class UMyInfo2 extends JFrame {
	public void umyinfo2(VPersonalInfo vPersonalInfo) {

		setTitle("내정보");
		setSize(400, 450);
		setLocationRelativeTo(null); // 창 띄웠을 때 가운데 고정
		setResizable(false);// 창 크기 고정

		JPanel panelMyInfo = new JPanel();
		panelMyInfo.setBackground(Color.white);
		setContentPane(panelMyInfo);
		panelMyInfo.setLayout(null);

		JLabel namela = new JLabel("이름 : ");
		namela.setFont(new Font("굴림", Font.PLAIN, 13));
		panelMyInfo.add(namela);
		namela.setBounds(111, 135, 47, 15);

		JLabel stnumla = new JLabel("학번 : ");
		stnumla.setFont(new Font("굴림", Font.PLAIN, 13));
		panelMyInfo.add(stnumla);
		stnumla.setBounds(111, 181, 47, 15);

		JLabel campusla = new JLabel("소속 캠퍼스 : ");
		campusla.setFont(new Font("굴림", Font.PLAIN, 13));
		panelMyInfo.add(campusla);
		campusla.setBounds(67, 228, 91, 15);

		JLabel idla = new JLabel("아이디 : ");
		idla.setFont(new Font("굴림", Font.PLAIN, 13));
		panelMyInfo.add(idla);
		idla.setBounds(96, 272, 58, 15);

		JLabel pwla = new JLabel("패스워드 : ");
		pwla.setFont(new Font("굴림", Font.PLAIN, 13));
		panelMyInfo.add(pwla);
		pwla.setBounds(82, 318, 68, 15);

		JButton exitbtn = new JButton("나가기");
		panelMyInfo.add(exitbtn);
		exitbtn.setBounds(257, 358, 97, 23);

		JButton pwcheckbtn = new JButton("비밀번호 확인");
		panelMyInfo.add(pwcheckbtn);
		pwcheckbtn.setBounds(111, 358, 121, 23);
		pwcheckbtn.setEnabled(false);

		JTextField nametxt = new JTextField();
		panelMyInfo.add(nametxt);
		nametxt.setBounds(152, 132, 116, 21);
		nametxt.setColumns(10);
		nametxt.setText(vPersonalInfo.name1);
		nametxt.setEditable(false);

		JTextField numbertxt = new JTextField();
		panelMyInfo.add(numbertxt);
		numbertxt.setBounds(152, 178, 116, 21);
		numbertxt.setColumns(10);
		numbertxt.setText(vPersonalInfo.number);
		numbertxt.setEditable(false);

		JTextField campustxt = new JTextField();
		panelMyInfo.add(campustxt);
		campustxt.setBounds(152, 225, 116, 21);
		campustxt.setColumns(10);
		if (vPersonalInfo.yonginBtn.equals("용인캠퍼스")) {
			campustxt.setText(vPersonalInfo.yonginBtn);
		} else if (vPersonalInfo.seoulBtn.equals("서울캠퍼스")) {
			campustxt.setText(vPersonalInfo.seoulBtn);
		}
		campustxt.setEditable(false);

		JTextField idtxt = new JTextField();
		panelMyInfo.add(idtxt);
		idtxt.setBounds(152, 269, 116, 21);
		idtxt.setColumns(10);
		idtxt.setText(vPersonalInfo.id1);
		idtxt.setEditable(false);

		JPasswordField pwtxt = new JPasswordField();
		panelMyInfo.add(pwtxt);
		pwtxt.setBounds(152, 315, 116, 21);
		pwtxt.setText(vPersonalInfo.password1);
		pwtxt.setEditable(false);
		pwtxt.setEchoChar((char) 0);

		JLabel iamgela = new JLabel("");
		iamgela.setIcon(new ImageIcon("myinfo.gif"));
		panelMyInfo.add(iamgela);
		iamgela.setBounds(28, 29, 326, 79);

		// 나가기 액션
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
