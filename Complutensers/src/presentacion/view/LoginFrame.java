package presentacion.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * para ver como queda ejecutar la clase prueba
 */
public class LoginFrame extends JFrame{
	
	JTextField user;
	JPasswordField password;
	JButton logButton;
	JButton notlogButton;
	JButton register;
	LoginListener loginlist;
	
	public LoginFrame (LoginListener ll){
		super("Login");	
		loginlist=ll;
		initGUI();
	}
	
	private void initGUI(){		
		JPanel panel = createJpanel();		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	private JPanel createJpanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel userp = new JPanel();
		userp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		user = new JTextField(20);			
		JLabel a = new JLabel("Usuario:");
		userp.add(a);
		userp.add(user);
		
		JPanel pass = new JPanel();
		pass.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		password = new JPasswordField(20);	
		JLabel b = new JLabel("Contraseņa:");
		pass.add(b);
		pass.add(password);
		
		JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		botones.setSize(new Dimension(500,100));		
		logButton = new JButton("Log in");
		notlogButton = new JButton("Entrar sin log");
		register = new JButton("Registrarse");
		
		logButton.addActionListener((e)->{
			if (loginlist.loggear(user.getText(), password.getText()))
				this.setVisible(false);
			else{
				JOptionPane.showMessageDialog(this, "Usuario o contraseņa "
						+ "incorrectos, vuelva a intentarlo.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				user.setText("");
				password.setText("");
			}
		});
		notlogButton.addActionListener((e)->{
			loginlist.entrarSinLog();
			this.setVisible(false);
		});
		register.addActionListener((e)->{
			if (loginlist.registrarse(user.getText(), password.getText()))
				JOptionPane.showMessageDialog(this, "Se ha registrado "
						+ "satisfactoriamente, ya puede utilizar Complutensers "
						+ "introduciendo su usuario y contraseņa.",
						"REGISTRO CORRECTO", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Ese nombre de usuario "
						+ "ya existe, por favor introduzca otro diferente.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			
		});
		botones.add(logButton);
		botones.add(notlogButton);
		botones.add(register);
		
		panel.add(userp);
		panel.add(pass);
		panel.add(botones);
		return panel;
	}

}

