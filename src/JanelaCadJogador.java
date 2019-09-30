import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class JanelaCadJogador extends JFrame{


	private static final long serialVersionUID = 1L;

private JPanel contentPainel; 
	
	public static JTextField textCodjogador;
	private JTextField textNomejogador;
	
	private JLabel lblCodJogador;
	private JLabel lblNomeJogador;
	
	private JButton btnGravar;
	
	public JanelaCadJogador()
	{
		super("Cadastrar Jogador");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Projetos\\Java\\JogoGenius\\src\\icoJogo.png"));
		
		    addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0)
			{
				String ultimoDado = Conexao.RetornaDados("SELECT MAX(CODJOGADOR) FROM JOGADOR");
				
				if(ultimoDado == null)
				{
					ultimoDado = "0";
				}
				
				int x = Integer.parseInt(ultimoDado) + 1 ;
				textCodjogador.setText(""+ x);
				textNomejogador.grabFocus();
			}
		});
		
		Conexao.centralizarJanela(JanelaCadJogador.this);   
		contentPainel = new JPanel();
		contentPainel.setBackground(Color.WHITE);
		contentPainel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPainel);
		
		textCodjogador = new JTextField();
		textCodjogador.setBounds(104, 34, 35, 20);
		textCodjogador.setHorizontalAlignment(SwingConstants.CENTER);
		textCodjogador.setEditable(false);
		
		textNomejogador = new JTextField();
		textNomejogador.setBounds(231, 34, 314, 20);
		
		lblCodJogador = new JLabel("Cod. Jogador:");
		lblCodJogador.setBounds(20, 37, 85, 14);
		lblNomeJogador = new JLabel("Jogador:");
		lblNomeJogador.setBounds(170, 37, 51, 14);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setBounds(559, 33, 85, 23);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gravarDados();
			}
		});
		contentPainel.setLayout(null);
		contentPainel.add(lblCodJogador);
		contentPainel.add(textCodjogador);
		contentPainel.add(lblNomeJogador);
		contentPainel.add(textNomejogador);
		contentPainel.add(btnGravar);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(660, 110);
		Conexao.centralizarJanela(JanelaCadJogador.this);
	}

	public void gravarDados()
	{
		if(textNomejogador.getText().length() == 0)
		{
		JOptionPane.showMessageDialog(null, "O Campo NOME não pode ser vazio!");
		textNomejogador.requestFocus();
		return;
		}
		try
		{
		Conexao.ExecutarComando("INSERT INTO JOGADOR (CODJOGADOR) VALUES (" + textCodjogador.getText() + ")");
		Conexao.ExecutarComando("UPDATE JOGADOR SET NOMEJOGADOR = '" + textNomejogador.getText().toUpperCase() + "' WHERE CODJOGADOR = '" + textCodjogador.getText() + "'");
		dispose();
		
		JanelaJogo.comecarJogo();
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
		JanelaJogo.btnDonw.setVisible(true);	
		JanelaJogo.btnUp.setVisible(true);	
		JanelaJogo.btnRigth.setVisible(true);
		JanelaJogo.btnLeft.setVisible(true);
		JanelaJogo.lblPontuacao.setVisible(true);
		JanelaJogo.lblJogador.setVisible(true);
		JanelaJogo.labelnomejogador.setVisible(true);
		JanelaJogo.labelponto.setVisible(true);
		
		JanelaJogo.btnJogar.setVisible(false);
		JanelaJogo.buttonScore.setVisible(false);
		
		String nome = Conexao.RetornaDados("SELECT NOMEJOGADOR FROM JOGADOR WHERE CODJOGADOR = " + textCodjogador.getText());
		JanelaJogo.labelnomejogador.setText("" + nome);
		
		dispose();
	}
}
