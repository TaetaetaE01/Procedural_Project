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

import service.SPlusfriend;
import valueObject.VFriend;
import valueObject.VPersonalInfo;

public class UPlusFriend extends JFrame {

	public void pulsFriend(String PersonalData) {

		setTitle("친구 추가");
		this.setSize(400, 200); // 맨 처음 창 크기
		setLocationRelativeTo(null); // 창 띄웠을 때 가운데 고정
		setResizable(false);// 창 크기 고정

		JPanel panelplusFri = new JPanel();
		panelplusFri.setBackground(Color.white);
		setContentPane(panelplusFri);
		panelplusFri.setLayout(null);

		JLabel labeltext2 = new JLabel("친구의 아이디를 입력해주세요");
		JLabel labelid = new JLabel("아이디 : ");
		JTextField textid = new JTextField(10);

		panelplusFri.add(labeltext2);
		labeltext2.setBounds(77, 15, 160, 24);

		panelplusFri.add(labelid);
		labelid.setBounds(77, 47, 47, 24);

		panelplusFri.add(textid);
		textid.setBounds(135, 49, 132, 24);

		JButton plusBtn = new JButton("친구 추가");
		panelplusFri.add(plusBtn);
		plusBtn.setBounds(177, 93, 97, 23);
		
		JButton backBtn = new JButton("뒤로가기");
		panelplusFri.add(backBtn);
		backBtn.setBounds(77, 93, 97, 23);
		
		VPersonalInfo vPersonalInfo = new VPersonalInfo();
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UFriend uFriend = new UFriend();
				uFriend.ufriend(PersonalData, vPersonalInfo);
				uFriend.setVisible(true);
			}
		});
		
		// 친구추가 액션
		plusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					VPersonalInfo vPersonalInfo = new VPersonalInfo();
					VFriend vFriend = new VFriend();

					vPersonalInfo.plusfriend = textid.getText();
					vFriend.setFriendName(textid.getText());

					SPlusfriend sPlusfriend = new SPlusfriend();
					vPersonalInfo = sPlusfriend.plusfriend(vFriend, vPersonalInfo);

					if (vPersonalInfo == null) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
					
					} else {
						// 여기서 값이 있으면 S WRITE통해서 M에 저장하고
						// 스캐너로 읽어서 벡터로 가져와서 리스트에 넣는다(블린형으로 인자 넘겨주기)
						// 여기서 벡터에 넣지말고 원래 패털에서 넣기
						// 그러고 리스트 선택시 그값에 따른 ID를 수강신청 폴더에서 찾아서
						// 테이블에 담기
						sPlusfriend.write(vFriend, PersonalData);
						JOptionPane.showMessageDialog(null, "친구가 등록되었습니다.");

						dispose();
						UFriend uFriend = new UFriend();
						uFriend.ufriend(PersonalData, vPersonalInfo);
						uFriend.setVisible(true);

					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}
