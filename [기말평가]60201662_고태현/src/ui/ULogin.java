package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.SLogin;
import valueObject.VLogin;
import valueObject.VPersonalInfo;

public class ULogin extends JFrame {

	public void ULogin() {

		JFrame frame = new JFrame();
		this.setVisible(true); // 화면에 항상 출력
		setTitle("명지대 수강신청 프로그램 : Login");
		setSize(600, 400); // 맨 처음 창 크기
		setLocationRelativeTo(null); // 창 띄웠을 때 가운데 고정
		setResizable(false);// 창 크기 고정

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 탈 ㅡ 출

		JPanel panelLo = new JPanel();
		panelLo.setBackground(Color.white);
		// add(panelLo);

		setContentPane(panelLo);
		panelLo.setLayout(null);

		JLabel labelid = new JLabel("ID : ");
		JTextField textid = new JTextField(10);
		JLabel labelpw = new JLabel("PASSWORD : ");
		JPasswordField textpw = new JPasswordField(10);

		JLabel imagelabel = new JLabel(" "); // 이미지 레이블

		panelLo.add(labelid);
		labelid.setBounds(301, 102, 30, 28);

		panelLo.add(textid);
		textid.setBounds(336, 96, 154, 41);

		panelLo.add(labelpw);
		labelpw.setBounds(244, 153, 89, 28);

		panelLo.add(textpw);
		textpw.setBounds(336, 147, 154, 41);

		JButton logBtn = new JButton("로그인");
		panelLo.add(logBtn);
		logBtn.setBounds(235, 230, 127, 32);

		JButton registerPerBtn = new JButton("회원가입");
		panelLo.add(registerPerBtn);
		registerPerBtn.setBounds(374, 230, 127, 32);

		JButton findidBtn = new JButton("아이디 찾기");
		panelLo.add(findidBtn);
		findidBtn.setBounds(235, 272, 127, 23);

		JButton findpwBtn = new JButton("패스워드 찾기");
		panelLo.add(findpwBtn);
		findpwBtn.setBounds(374, 272, 127, 23);

		imagelabel.setIcon(new ImageIcon("loginimage.gif"));
		panelLo.add(imagelabel);
		imagelabel.setBounds(43, 53, 192, 194);

		// 로그인 액션
		logBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				// 로그인 버튼 눌렀을 떄 비교하기

				VLogin vLogin = new VLogin();
				vLogin.ConfirmId = textid.getText();
				vLogin.ConfirmPassword = textpw.getText();

				if (vLogin.ConfirmId.equals("") || vLogin.ConfirmPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "로그인 정보에 빈칸이 있습니다.");
				} else {
					SLogin sLogin = new SLogin();
					VPersonalInfo vPersonalInfo;
					try {
						vPersonalInfo = sLogin.validate(vLogin);
						if (vPersonalInfo == null) {
							JOptionPane.showMessageDialog(null, "로그언 정보가 일치하지 않습니다");
						} else {
							JOptionPane.showMessageDialog(null, "로그인 되었습니다! " + vPersonalInfo.name1 + "님 환영합니다!");
							String PersonalData = vPersonalInfo.id1;

							Usugang usugang = new Usugang();
							usugang.Psugangsincheong(PersonalData, vPersonalInfo);
						
							UMyInfo uMyInfo = new UMyInfo();
							uMyInfo.umyinfo(vPersonalInfo);
							
							

							usugang.setVisible(true);
							dispose();

						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		// 회원가입 액션
		registerPerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 회원가입 버튼 눌렀을 때 회원가입
				Register register = new Register();
				register.Pregister();
				// frame.setVisible(false);
				register.setVisible(true);
				dispose();

			}
		});
		// 아이디 찾기 액션
		findidBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find find = new Find();
				find.findid();
				find.setVisible(true);
			}
		});
		// 패스워드 찾기 액션
		findpwBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find find1 = new Find();
				find1.findpw();
				find1.setVisible(true);
			}
		});
	}
}
