package Friend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


import javax.swing.JSplitPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class FriendView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField nametf;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField birthtf;
	private JTextField phonetf;
	private JTextField addrtf;
	private JButton newadd;
	private JButton allview;
	private JSplitPane splitPane_1;
	private JPanel panel_2;
	private JComboBox comsel;
	private JTextField tfsearch;
	private JButton btnsearch;
	private JScrollPane scrollPane;
	FriendDBAImpl dba = new FriendDBAImpl();
	private JTextArea taview;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FriendView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(390);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(Color.RED), "\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getNametf());
			panel.add(getLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_2());
			panel.add(getBirthtf());
			panel.add(getPhonetf());
			panel.add(getAddrtf());
			panel.add(getNewadd());
			panel.add(getAllview());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(64, 56, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getNametf() {
		if (nametf == null) {
			nametf = new JTextField();
			nametf.setBounds(220, 53, 116, 21);
			nametf.setColumns(10);
		}
		return nametf;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("생일");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(64, 121, 57, 15);
		}
		return label;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("전화번호");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(64, 176, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("주소");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(64, 228, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JTextField getBirthtf() {
		if (birthtf == null) {
			birthtf = new JTextField();
			birthtf.setText("");
			birthtf.setBounds(220, 118, 116, 21);
			birthtf.setColumns(10);
		}
		return birthtf;
	}
	private JTextField getPhonetf() {
		if (phonetf == null) {
			phonetf = new JTextField();
			phonetf.setBounds(220, 173, 116, 21);
			phonetf.setColumns(10);
		}
		return phonetf;
	}
	private JTextField getAddrtf() {
		if (addrtf == null) {
			addrtf = new JTextField();
			addrtf.setBounds(220, 228, 116, 21);
			addrtf.setColumns(10);
		}
		return addrtf;
	}
	private JButton getNewadd() {
		if (newadd == null) {
			newadd = new JButton("추가");
			newadd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Friend f = new Friend();
					String name = nametf.getText();
					String birth = birthtf.getText();
					String phone = phonetf.getText();
					String addr = addrtf.getText();
					f.setName(name);
					f.setBirth(birth);
					f.setPhone(phone);
					f.setAddr(addr);
					dba.friendInsert(f);
					allview.doClick();
				}
			});
			newadd.setBounds(64, 288, 97, 23);
		}
		return newadd;
	}
	private JButton getAllview() {
		if (allview == null) {
			allview = new JButton("전체보기");
			allview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					taview.setText("");
					ArrayList<Friend> arr = dba.friendView();
					for(Friend f : arr) {
						taview.append("번호 : "+f.getNum()+"\n");
						taview.append("이름 : "+f.getName()+"\n");
						taview.append("생일 : "+f.getBirth()+"\n");
						taview.append("전화번호 : "+f.getPhone()+"\n");
						taview.append("주소 : "+f.getAddr()+"\n");
						taview.append("\n");
					}					
				}
			});
			allview.setBounds(239, 288, 97, 23);
		}
		return allview;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setRightComponent(getPanel_2());
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setDividerLocation(300);
		}
		return splitPane_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getComsel());
			panel_2.add(getTfsearch());
			panel_2.add(getBtnsearch());
		}
		return panel_2;
	}
	private JComboBox getComsel() {
		if (comsel == null) {
			comsel = new JComboBox();
			comsel.setModel(new DefaultComboBoxModel(new String[] {"선택하세요.", "이름", "주소"}));
			comsel.setBounds(12, 10, 75, 21);
		}
		return comsel;
	}
	private JTextField getTfsearch() {
		if (tfsearch == null) {
			tfsearch = new JTextField();
			
			tfsearch.setBounds(101, 10, 155, 21);
			tfsearch.setColumns(10);
		}
		return tfsearch;
	}
	private JButton getBtnsearch() {
		if (btnsearch == null) {
			btnsearch = new JButton("찾기");
			btnsearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					taview.setText("");
					int num = comsel.getSelectedIndex();
					String key = "name";
					if(num==0) { tfsearch.setText("선택오류");
					}else if(num==1) {key = "name";
					}else if(num==2) {key = "addr";}
					
					String str = key+" like '%"+tfsearch.getText().trim()+"%'";
					
					ArrayList<Friend> arr = dba.friendSearch(str);
					
					for(Friend f : arr) {
						taview.append("번호 : "+f.getNum()+"\n");
						taview.append("이름 : "+f.getName()+"\n");
						taview.append("생일 : "+f.getBirth()+"\n");
						taview.append("전화번호 : "+f.getPhone()+"\n");
						taview.append("주소 : "+f.getAddr()+"\n");
						taview.append("\n");
					}		
				}
			});
			btnsearch.setBounds(267, 9, 97, 23);
		}
		return btnsearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(null, "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setViewportView(getTaview());
		}
		return scrollPane;
	}
	private JTextArea getTaview() {
		if (taview == null) {
			taview = new JTextArea();
		}
		return taview;
	}
}
