import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class JanelaValor extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPainel;
	private JLabel lblBackground;
	static JLabel lblvalor;
	static JLabel lblSequencia;
	
	public JanelaValor(){
	addWindowListener(new WindowAdapter() {
	public void windowOpened(WindowEvent arg0)
	{
	try 
		{
		        lblvalor.setText(JanelaJogo.lblVamosJogar.getText());
				Thread.sleep(3000);
				dispose();
		} 
	catch (InterruptedException e) 
		{
				e.printStackTrace();
		}
	}
			});
	
		setTitle("");
		setType(Type.UTILITY);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Projetos\\Java\\JogoGenius\\src\\icoJogo.png"));
		
		contentPainel = new JPanel();
		contentPainel.setBackground(Color.WHITE);
		contentPainel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPainel);
		
		lblvalor = new JLabel(".");
		lblvalor.setText(JanelaJogo.lblVamosJogar.getText());
		lblvalor.setForeground(Color.RED);
		lblvalor.setHorizontalAlignment(SwingConstants.CENTER);
		lblvalor.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblvalor.setBounds(168, 22, 146, 45);
		
		lblSequencia = new JLabel("Sequencia:");
		lblSequencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblSequencia.setForeground(Color.RED);
		lblSequencia.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblSequencia.setBounds(41, 22, 146, 45);
		
		lblBackground = new JLabel("");
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBackground.setBackground(new Color(238, 232, 170));
		lblBackground.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\background.png"));
		lblBackground.setBounds(-6, -5, 378, 196);
		
		contentPainel.add(lblSequencia);
		contentPainel.add(lblvalor);
		contentPainel.add(lblBackground);
		contentPainel.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(372, 214);
		Conexao.centralizarJanela(JanelaValor.this);
	}
}