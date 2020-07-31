package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import service.SBasket;
import service.SHakgwa;
import service.SLecture;
import service.SLogin;
import service.SSugangsincheong;
import valueObject.VBasket;
import valueObject.VHakgwa;
import valueObject.VLecture;
import valueObject.VLogin;
import valueObject.VPersonalInfo;
import valueObject.VSugangsincheong;

public class Usugang extends JFrame {

	private String fileName = "root";
	String fileName5 = null;
	String Id, Name, Professor, Credit, Time = null;
	String Id1, Name1, Professor1, Credit1, Time1 = null;
	// String Id3, Name3, Professor3, Credit3, Time3 = null;
//	int total, total1 = 0;
//	int finaltotal = total - total;
	int finaltotal;

	@SuppressWarnings("unchecked")
	public void Psugangsincheong(String personalData, VPersonalInfo vPersonalInfo) {

		JFrame frame = new JFrame();
		setTitle("명지대 수강신청 프로그램");
		this.setSize(1000, 700); // 맨 처음 창 크기
		setLocationRelativeTo(null); // 창 띄웠을 때 가운데 고정
		setResizable(false);// 창 크기 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 탈 ㅡ 출

		JPanel panelSugang = new JPanel();
		panelSugang.setBackground(Color.white);
		setContentPane(panelSugang);
		panelSugang.setLayout(null);

		JLabel hellola = new JLabel(vPersonalInfo.name1 + "님 환영합니다!");
		hellola.setFont(new Font("굴림", Font.BOLD, 13));
		panelSugang.add(hellola);
		hellola.setBounds(12, 10, 181, 15);

		JList campuslist = new JList();
		panelSugang.add(campuslist);
		campuslist.setBounds(25, 150, 111, 205);
		campuslist.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		campuslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JList collegelist = new JList();
		panelSugang.add(collegelist);
		collegelist.setBounds(151, 150, 165, 205);
		collegelist.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		collegelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JList departmentlist = new JList();
		panelSugang.add(departmentlist);
		departmentlist.setBounds(328, 150, 122, 205);
		departmentlist.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		departmentlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel campusla = new JLabel("캠퍼스");
		campusla.setFont(new Font("굴림", Font.BOLD, 13));
		campusla.setBounds(25, 125, 57, 15);
		panelSugang.add(campusla);

		JLabel collegela = new JLabel("단과대");
		panelSugang.add(collegela);
		collegela.setFont(new Font("굴림", Font.BOLD, 13));
		collegela.setBounds(154, 125, 57, 15);

		JLabel departmentla = new JLabel("학과");
		panelSugang.add(departmentla);
		departmentla.setFont(new Font("굴림", Font.BOLD, 13));
		departmentla.setBounds(328, 125, 57, 15);

		JLabel lecturela = new JLabel("강 의");
		panelSugang.add(lecturela);
		lecturela.setFont(new Font("굴림", Font.BOLD, 13));
		lecturela.setBounds(25, 386, 57, 15);

		JLabel image = new JLabel("New label");
		panelSugang.add(image);
		image.setIcon(new ImageIcon("수강신청이미지.gif"));
		image.setBounds(12, 32, 356, 83);

		JLabel emergency = new JLabel("* 다른 단과대를 선택시 'reset'을 눌러주세요");
		panelSugang.add(emergency);
		emergency.setFont(new Font("굴림", Font.PLAIN, 12));
		emergency.setBounds(172, 360, 278, 22);

		JButton gobasketBtn = new JButton("강좌 담기");
		panelSugang.add(gobasketBtn);
		gobasketBtn.setBounds(320, 628, 130, 23);

		JButton logoutBtn = new JButton("로그아웃");
		panelSugang.add(logoutBtn);
		logoutBtn.setBounds(875, 55, 97, 23);

		JButton clockBtn = new JButton("서버시간");
		panelSugang.add(clockBtn);
		clockBtn.setBounds(875, 22, 97, 23);

		JLabel basketla = new JLabel("책가방");
		panelSugang.add(basketla);
		basketla.setBounds(506, 125, 57, 15);

		JButton deleteBtn = new JButton("삭제하기");
		panelSugang.add(deleteBtn);
		deleteBtn.setBounds(857, 360, 97, 23);

		JButton sugangBtn = new JButton("수강신청");
		panelSugang.add(sugangBtn);
		sugangBtn.setBounds(748, 360, 97, 23);

		JButton sugangdelBtn = new JButton("삭제하기");
		panelSugang.add(sugangdelBtn);
		sugangdelBtn.setBounds(857, 628, 97, 23);

		JButton homepageBtn = new JButton("홈페이지");
		panelSugang.add(homepageBtn);
		homepageBtn.setBounds(766, 22, 97, 23);

		JButton myInfo = new JButton("내정보");
		panelSugang.add(myInfo);
		myInfo.setBounds(766, 55, 97, 23);

		JLabel mju = new JLabel("그대는      를 밝히는      이어라!");
		mju.setFont(new Font("이소라", Font.BOLD, 28));
		panelSugang.add(mju);
		mju.setBounds(377, 44, 382, 47);

		JLabel mju1 = new JLabel("명지");
		mju1.setFont(new Font("이소라", Font.BOLD, 28));
		panelSugang.add(mju1);
		mju1.setBounds(465, 47, 87, 40);

		JLabel mju2 = new JLabel("등불");
		mju2.setFont(new Font("이소라", Font.BOLD, 28));
		panelSugang.add(mju2);
		mju2.setBounds(629, 48, 98, 39);
		mju2.setForeground(Color.red);

		JLabel sugangla = new JLabel("수강신청");
		panelSugang.add(sugangla);
		sugangla.setBounds(506, 386, 57, 15);

		JButton numcheBtn = new JButton("학점 확인");
		panelSugang.add(numcheBtn);
		numcheBtn.setBounds(748, 628, 97, 23);

		JButton friendBtn = new JButton("친 구");
		panelSugang.add(friendBtn);
		friendBtn.setBounds(875, 88, 97, 23);

		// 친구 버튼 액션
		friendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UFriend uFriend = new UFriend();
				uFriend.ufriend(personalData, vPersonalInfo);
				uFriend.setVisible(true);
			}
		});

		// 서버 시계 버튼
		clockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						URI uri = new URI("http://time.navyism.com/?host=class.mju.ac.kr");
						desktop.browse(uri);
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		// 내정보 버튼 액션
		myInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UMyInfo uMyInfo = new UMyInfo();
				uMyInfo.umyinfo(vPersonalInfo);
				uMyInfo.setVisible(true);
			}
		});

		// 홈페이지 버튼 액션
		homepageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						URI uri = new URI("https://www.mju.ac.kr/sites/mjukr/intro/intro.html");
						desktop.browse(uri);
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		// 강의 테이블
		JTable table = new JTable();
		JScrollPane scoll = new JScrollPane(table);
		// 책가방 테이블
		JTable btable = new JTable();
		JScrollPane scoll1 = new JScrollPane(btable);

		Vector<String> m = new Vector<String>();
		m.addElement("강의 번호");
		m.addElement("강의명");
		m.addElement("교수");
		m.addElement("학점");
		m.addElement("시간");
		DefaultTableModel model1 = new DefaultTableModel(m, 0) { // (데이터, // 맨위에)
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// 수강신청 테이블
		JTable stable = new JTable();
		JScrollPane scoll2 = new JScrollPane(stable);
		DefaultTableModel model2 = new DefaultTableModel(m, 0) { // (데이터, // 맨위에)
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// 로그아웃 버튼 액션
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ULogin uLogin = new ULogin();
				uLogin.ULogin();
			}
		});

		SHakgwa sHakgwa = new SHakgwa();
		Vector<VHakgwa> vCampuses = sHakgwa.getData(fileName);

		Vector<Object> campus = new Vector<>();

		// 리스트에 캠퍼스넣기
		for (VHakgwa vCampus : vCampuses) {
			campus.add(vCampus.getName());
		}
		campuslist.setListData(campus);
		campus.addElement("reset");

		// 캠퍼스 선택
		campuslist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				fileName = (String) campuslist.getSelectedValue();

				for (VHakgwa vCampus : vCampuses) {
					if (vCampus.getName().equals(fileName)) {
						fileName = vCampus.getFileName();

					}
				}

				Vector<VHakgwa> colleges = sHakgwa.getData(fileName);
				Vector<Object> college = new Vector<>();
				// 리스트에 단과대 넣기
				for (VHakgwa vCollege : colleges) {
					college.add(vCollege.getName());
				}

				collegelist.setListData(college);

				collegelist.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {

						String fileName1 = null;

						// 여기서 겟파일네임은 받아짐
						fileName1 = (String) collegelist.getSelectedValue();

						for (VHakgwa vCollege : colleges) {
							if (vCollege.getName().equals(fileName1)) {
								fileName = vCollege.getFileName();

							}
						}

						Vector<VHakgwa> departments = sHakgwa.getData(fileName);
						Vector<Object> department = new Vector<>();

						// 리스트에 학과 넣기
						for (VHakgwa vDepartment : departments) {
							department.add(vDepartment.getName());
						}

						departmentlist.setListData(department);

						departmentlist.addListSelectionListener(new ListSelectionListener() {
							@SuppressWarnings("serial")
							public void valueChanged(ListSelectionEvent e) {
								String fileName1 = null;
								// 여기서 겟파일네임은 받아짐
								fileName1 = (String) departmentlist.getSelectedValue();

								for (VHakgwa vDepartmnet : departments) {
									if (vDepartmnet.getName().equals(fileName1)) {
										fileName5 = vDepartmnet.getFileName();

									}
								}
								try {
									SLecture sLecture = new SLecture();
									Vector<VLecture> lectures = sLecture.read(fileName5);

									Vector<String> u = new Vector<String>();
									u.addElement("강의 번호");
									u.addElement("강의명");
									u.addElement("교수");
									u.addElement("학점");
									u.addElement("시간");

									DefaultTableModel model = new DefaultTableModel(u, 0) { // (데이터, 맨위에)
										public boolean isCellEditable(int row, int column) {
											return false;
										}
									};
									scoll.setBounds(25, 411, 425, 214);
									scoll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

									table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
									panelSugang.add(scoll);

									for (VLecture vLecture : lectures) {
										@SuppressWarnings("rawtypes")

										Vector lecture = new Vector();

										lecture.add(vLecture.getId());
										lecture.add(vLecture.getName());
										lecture.add(vLecture.getProfessor());
										lecture.add(vLecture.getCredit());
										lecture.add(vLecture.getTime());

										model.addRow(lecture);
										table.setModel(model);
									}

									table.getColumnModel().getColumn(0).setPreferredWidth(45);
									table.getColumnModel().getColumn(1).setPreferredWidth(170);
									table.getColumnModel().getColumn(2).setPreferredWidth(40);
									table.getColumnModel().getColumn(3).setPreferredWidth(30);
									table.getColumnModel().getColumn(4).setPreferredWidth(90);

									// 강의 선택시
									table.addMouseListener(new MouseAdapter() {
										public void mousePressed(MouseEvent e) {

											// 마우스 클릭한 행의 인덱스 값
											int idx = table.getSelectedRow();

											// 테이블.getValueAt(행의 인덱스 , 컬럼의 인덱스)
											Id = table.getValueAt(idx, 0) + "";
											Name = table.getValueAt(idx, 1) + "";
											Professor = table.getValueAt(idx, 2) + "";
											Credit = table.getValueAt(idx, 3) + "";
											Time = table.getValueAt(idx, 4) + "";

										}
									});

								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						});
					}
				});
			}
		});

		// 미리담기 버튼액션
		gobasketBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {

				VBasket vBasket = new VBasket();
				vBasket.setId(Id);
				vBasket.setName(Name);
				vBasket.setProfessor(Professor);
				vBasket.setCredit(Credit);
				vBasket.setTime(Time);

				JOptionPane.showMessageDialog(null, "'" + vBasket.getName() + "' 강좌가 책가방에 담겼습니다!");
				SBasket sBasket = new SBasket();
				sBasket.write(vBasket, personalData);

				Vector<VBasket> VBaskets = sBasket.read(personalData, Id);

				scoll1.setBounds(506, 151, 448, 204);
				scoll1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				panelSugang.add(scoll1);

				model1.getDataVector().removeAllElements();

				for (VBasket vBasket1 : VBaskets) {
					Vector<String> info = new Vector<String>();

					info.add(vBasket1.getId());
					info.add(vBasket1.getName());
					info.add(vBasket1.getProfessor());
					info.add(vBasket1.getCredit());
					info.add(vBasket1.getTime());

					model1.addRow(info);
					btable.setModel(model1);
				}

				btable.getColumnModel().getColumn(0).setPreferredWidth(45);
				btable.getColumnModel().getColumn(1).setPreferredWidth(170);
				btable.getColumnModel().getColumn(2).setPreferredWidth(40);
				btable.getColumnModel().getColumn(3).setPreferredWidth(30);
				btable.getColumnModel().getColumn(4).setPreferredWidth(90);

			}
		});

		// 수강신청 테이블 액션
		btable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				// 마우스 클릭한 행의 인덱스 값
				int idx = btable.getSelectedRow();

				// 테이블.getValueAt(행의 인덱스 , 컬럼의 인덱스)
				Id1 = btable.getValueAt(idx, 0) + "";
				Name1 = btable.getValueAt(idx, 1) + "";
				Professor1 = btable.getValueAt(idx, 2) + "";
				Credit1 = btable.getValueAt(idx, 3) + "";
				Time1 = btable.getValueAt(idx, 4) + "";

			}
		});

		// 수강신청 버튼 액션
		sugangBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {

				VSugangsincheong vSugangsincheong = new VSugangsincheong();
				vSugangsincheong.setId(Id1);
				vSugangsincheong.setName(Name1);
				vSugangsincheong.setProfessor(Professor1);
				vSugangsincheong.setCredit(Credit1);
				vSugangsincheong.setTime(Time1);

				JOptionPane.showMessageDialog(null, "'" + vSugangsincheong.getName() + "' 강좌가 책가방에 담겼습니다!");
				SSugangsincheong sSugangsincheong = new SSugangsincheong();
				sSugangsincheong.write(vSugangsincheong, personalData);

				Vector<VSugangsincheong> VSugangsincheongs = sSugangsincheong.read(personalData);

				scoll2.setBounds(509, 411, 445, 214);
				scoll2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				panelSugang.add(scoll2);

				model2.getDataVector().removeAllElements();
				for (VSugangsincheong vSugangsincheong1 : VSugangsincheongs) {
					Vector<Object> info2 = new Vector<Object>();

					info2.add(vSugangsincheong1.getId());
					info2.add(vSugangsincheong1.getName());
					info2.add(vSugangsincheong1.getProfessor());
					info2.add(vSugangsincheong1.getCredit());
					info2.add(vSugangsincheong1.getTime());

					model2.addRow(info2);
					stable.setModel(model2);

				}
				stable.getColumnModel().getColumn(0).setPreferredWidth(45);
				stable.getColumnModel().getColumn(1).setPreferredWidth(170);
				stable.getColumnModel().getColumn(2).setPreferredWidth(40);
				stable.getColumnModel().getColumn(3).setPreferredWidth(30);
				stable.getColumnModel().getColumn(4).setPreferredWidth(90);

				// 학점 확인 액션
				Vector<Integer> credits = new Vector<Integer>();
				numcheBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						for (VSugangsincheong vSugangsincheong1 : VSugangsincheongs) {

							if (vSugangsincheong1.getCredit().equals("2")) {
								credits.add(2);
							} else if (vSugangsincheong1.getCredit().equals("3")) {
								credits.add(3);
							} else if (vSugangsincheong1.getCredit().equals("4")) {
								credits.add(4);
							}
						}

						for (int m = 0; m < credits.size(); m++) {
							finaltotal += credits.get(m);
						}

						JOptionPane.showMessageDialog(null, "현재 학점은 " + finaltotal + "입니다");
						numcheBtn.setEnabled(false);
					}
				});

			}
		});
		// 책가방 안에있는 거 강의 삭제하기
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btable.getSelectedRow() == -1) {
					return;
				} else {
					model1.removeRow(btable.getSelectedRow());
				}
				btable.setVisible(false);
				btable.setVisible(true);
				SBasket sBasket = new SBasket();
				sBasket.basketDelete(personalData);

				int t = 0;

				// btable의 인덱스 전체 크기
				t = btable.getRowCount();

				for (int h = 0; h < t; h++) {
					VBasket vBasket = new VBasket();
					vBasket.setId(btable.getValueAt(h, 0) + "");
					vBasket.setName(btable.getValueAt(h, 1) + "");
					vBasket.setProfessor(btable.getValueAt(h, 2) + "");
					vBasket.setCredit(btable.getValueAt(h, 3) + "");
					vBasket.setTime(btable.getValueAt(h, 4) + "");

					sBasket.write(vBasket, personalData);
				}
			}
		});

		// 수강신청 안에있는 강의 삭제하기
		sugangdelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stable.getSelectedRow() == -1) {
					return;
				} else {
					model2.removeRow(stable.getSelectedRow());
				}
				stable.setVisible(false);
				stable.setVisible(true);
				SSugangsincheong sSugangsincheong = new SSugangsincheong();
				sSugangsincheong.basketDelete(personalData);

				int t = 0;

				// btable의 인덱스 전체 크기
				t = stable.getRowCount();

				for (int h = 0; h < t; h++) {
					VSugangsincheong vSugangsincheong = new VSugangsincheong();
					vSugangsincheong.setId(stable.getValueAt(h, 0) + "");
					vSugangsincheong.setName(stable.getValueAt(h, 1) + "");
					vSugangsincheong.setProfessor(stable.getValueAt(h, 2) + "");
					vSugangsincheong.setCredit(stable.getValueAt(h, 3) + "");
					vSugangsincheong.setTime(stable.getValueAt(h, 4) + "");

					sSugangsincheong.write(vSugangsincheong, personalData);
				}

			}
		});
	}

}