
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import jssc.SerialPort;
import jssc.SerialPortException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class MainScreen extends JFrame {
	
	//port numarasına dikkat!!!!
	 SerialPort seri=new SerialPort("COM12");
	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		addWindowListener(new WindowAdapter() {
			
			
			
			
			
			
			
			
			
			@Override
			public void windowOpened(WindowEvent e) {
				
				
				 try {
	                    seri.openPort();  // Portu Aç 
	                } catch (SerialPortException ex) {
	                    //Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
	                }
	                try {
	                    seri.setParams(9600, 8, 1,0); // 9600 Baud, 8 bit veri, 1 bit stop biti, Parity biti  (*********) 
	                } catch (SerialPortException ex) {
	                   Logger.getLogger(getName());
	                }
				
				
				
				
				
				
				
				
				
				
				
			}
		});
			
		setTitle("Kontrol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnNewButton = new JButton("Lamba Söndür");
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				 try {
			         seri.writeInt(1);
			     } catch (SerialPortException ex) {
			    	 Logger.getLogger(getName());			     }
				
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Ampul Yak");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try {
			         seri.writeInt(0);
			     } catch (SerialPortException ex) {
			    	 Logger.getLogger(getName());			     }
				
				
				
				
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		
		final JLabel lblNewLabel = new JLabel("Seri Port Durum : Açık");
		
		JButton btnNewButton_2 = new JButton("Seriport Kapat");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 try {
			            seri.closePort();  // Portu Kapat
			            lblNewLabel.setText("Seriport Durum: Kapalı");
			        } catch (SerialPortException ex) {
			        	 Logger.getLogger(getName());			        } 
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Lamba Kontrolü ");
		
		JLabel lblNewLabel_2 = new JLabel("Pervane Kontrol");
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					seri.writeInt(3);
				} catch (SerialPortException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_3.setMaximumSize(new Dimension(97, 25));
		btnNewButton_3.setIcon(new ImageIcon("back-icon.png"));
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				try {
					seri.writeInt(2);
				} catch (SerialPortException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("up-icon (1).png"));
		btnNewButton_4.setPreferredSize(new Dimension(33, 9));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					seri.writeInt(4);
				} catch (SerialPortException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		button.setIcon(new ImageIcon("forward-icon.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_1)
					.addContainerGap(362, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(24))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(175, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(173))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel_2)
					.addContainerGap(359, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblNewLabel_1)
					.addGap(29)
					.addComponent(lblNewLabel)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(75)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(105))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
