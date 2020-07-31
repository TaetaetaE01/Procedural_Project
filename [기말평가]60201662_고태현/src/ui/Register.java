package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import service.SCompare;
import service.SRegistration;
import valueObject.VPersonalInfo;

public class Register extends JFrame {

	boolean click = true;

	@SuppressWarnings("deprecation")
	public void Pregister() {

		JFrame frame = new JFrame();
		setTitle("명지대 수강신청 프로그램 : Register");
		this.setSize(400, 500); // 맨 처음 창 크기
		setLocationRelativeTo(null); // 창 띄웠을 때 가운데 고정
		setResizable(false);// 창 크기 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 탈 ㅡ 출

		JPanel panelRegi = new JPanel();
		panelRegi.setBackground(Color.white);
		setContentPane(panelRegi);
		panelRegi.setLayout(null);

		JLabel labelid = new JLabel("ID : ");
		JTextField textid = new JTextField(10);
		JLabel labelpw = new JLabel("PASSWORD : ");
		JPasswordField textpw = new JPasswordField(10);
		JLabel pwchela = new JLabel("비밀번호 확인 :");
		JPasswordField pwchetxt = new JPasswordField(10);
		JLabel labelname = new JLabel("이름 : ");
		JTextField textname = new JTextField(10);
		JLabel labelnumber = new JLabel("학번 : ");
		JTextField textnumber = new JTextField(10);

		JLabel labelcampus = new JLabel("캠퍼스 ");
		JRadioButton yonginChe = new JRadioButton("용인 캠퍼스");
		yonginChe.setBackground(Color.white);
		JRadioButton seoulChe = new JRadioButton("서울 캠퍼스");
		seoulChe.setBackground(Color.white);

//		JLabel labelcollege = new JLabel("단과대 ");
//		JLabel labelmajor = new JLabel("학과 ");

		panelRegi.add(labelid);
		labelid.setBounds(65, 99, 72, 28);

		panelRegi.add(textid);
		textid.setBounds(136, 103, 116, 21);

		panelRegi.add(labelpw);
		labelpw.setBounds(52, 148, 80, 20);

		panelRegi.add(textpw);
		textpw.setBounds(137, 145, 116, 21);

		panelRegi.add(labelname);
		labelname.setBounds(65, 239, 57, 15);

		panelRegi.add(textname);
		textname.setBounds(136, 236, 116, 21);

		panelRegi.add(labelnumber);
		labelnumber.setBounds(65, 281, 57, 15);

		panelRegi.add(textnumber);
		textnumber.setBounds(136, 278, 116, 21);

		panelRegi.add(labelcampus);
		labelcampus.setBounds(55, 331, 57, 15);

		panelRegi.add(pwchela);
		pwchela.setBounds(27, 194, 85, 15);

		panelRegi.add(pwchetxt);
		pwchetxt.setBounds(136, 191, 116, 21);

		// 라디오버튼
		ButtonGroup group = new ButtonGroup();
		group.add(yonginChe);
		group.add(seoulChe);

		yonginChe.setSelected(true);

		yonginChe.setBounds(130, 327, 88, 23);
		panelRegi.add(yonginChe);

		seoulChe.setBounds(228, 327, 88, 23);
		panelRegi.add(seoulChe);

		JCheckBox personalInfocheck = new JCheckBox("개인정보 수집 동의");
		personalInfocheck.setBackground(Color.white);
		panelRegi.add(personalInfocheck);
		personalInfocheck.setBounds(136, 359, 129, 23);

		JButton compareBtn = new JButton("아이디 중복확인");
		panelRegi.add(compareBtn);
		compareBtn.setBounds(255, 102, 125, 23);

		JButton regiBtn = new JButton("회원 가입");
		panelRegi.add(regiBtn);
		regiBtn.setBounds(228, 388, 97, 23);

		JButton comebackBtn = new JButton("뒤로 가기");
		panelRegi.add(comebackBtn);
		comebackBtn.setBounds(118, 388, 97, 23);

		JLabel Regiimage = new JLabel("");
		Regiimage.setIcon(new ImageIcon("회원가입이미지.gif"));
		panelRegi.add(Regiimage);
		Regiimage.setBounds(12, 10, 362, 85);

		regiBtn.setEnabled(false);

		personalInfocheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkP = personalInfocheck.isSelected();
				regiBtn.setEnabled(checkP);
			}
		});

		// 아이디 중복확인 액션
		compareBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.compareid = textid.getText();

				try {
					SCompare sCompare = new SCompare();
					vPersonalInfo = sCompare.compare(vPersonalInfo);
					if (vPersonalInfo == null) {
						// 아이디 쌉가능
						JOptionPane.showMessageDialog(null, "사용할 수 있는 아이디입니다.");
						click = false;
						textid.setEnabled(false);
					} else {
						// 아이디 쌉불가능 중복
						JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// 다시 로그인 패널로 돌아가는 버튼
		comebackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ULogin uLogin = new ULogin();
				uLogin.ULogin();
			}
		});

		// 회원가입 액션
		regiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				vPersonalInfo.id1 = textid.getText();
				vPersonalInfo.password1 = textpw.getText();
				vPersonalInfo.name1 = textname.getText();
				vPersonalInfo.number = textnumber.getText();

//				vPersonalInfo.yonginBtn = yonginChe.isSelected();
//				vPersonalInfo.seoulBtn = seoulChe.isSelected();

				String yongin, seoul;
				if (yonginChe.isSelected()) {
					yongin = "용인캠퍼스";
				} else {
					yongin = "용인아님";
				}
				if (seoulChe.isSelected()) {
					seoul = "서울캠퍼스";
				} else {
					seoul = "서울아님";
				}
				vPersonalInfo.yonginBtn = yongin;
				vPersonalInfo.seoulBtn = seoul;

				if (vPersonalInfo.id1.equals("") || vPersonalInfo.password1.equals("") || vPersonalInfo.name1.equals("")
						|| vPersonalInfo.number.equals("") || pwchetxt.getText().equals("")) {
					// 회원가입 비정상
					JOptionPane.showMessageDialog(null, "회원가입 정보에 빈칸이 있습니다.");

				} else if (click) {
					// 중복확인 안 누름
					JOptionPane.showMessageDialog(null, "아이디 중복확인을 눌러주세요");
				} else if (!pwchetxt.getText().equals(vPersonalInfo.password1)) {
					JOptionPane.showMessageDialog(null, "pw가 pw확인과 일치하지 않습니다");
				} else {
					// 회원가입 정상

					SRegistration sRegistration = new SRegistration();
					sRegistration.write(vPersonalInfo);
					JOptionPane.showMessageDialog(null, vPersonalInfo.name1 + "님 회원가입 되었습니다");
					dispose();

					ULogin uLogin = new ULogin();
					uLogin.ULogin();
				}
			}
		});
	}
}
