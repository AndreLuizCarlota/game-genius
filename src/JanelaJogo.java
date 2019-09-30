import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class JanelaJogo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
    private JPanel contentPane;
	
	public static JLabel lblPontuacao;
	public static JLabel lblJogador;
	public static JLabel labelnomejogador;
	public static JLabel labelponto;
	public static JLabel lblVamosJogar;
	public static JLabel lblbackground;
	public static JLabel lblImgJogar;
	
	public static JButton btnDonw;
	public static JButton btnLeft;
	public static JButton btnRigth;
	public static JButton btnUp;
	public static JButton btnJogar;
	public static JButton buttonScore;
	
	public static String valorBut = "";
	public static int soma = 0;
	
	public JanelaJogo()
	{
	super("Jogo");
	
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Projetos\\Java\\JogoGenius\\src\\icoJogo.png"));
	
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setContentPane(contentPane);
	
	lblPontuacao = new JLabel("Potuação:");
	lblPontuacao.setForeground(Color.WHITE);
	lblPontuacao.setBounds(552, 323, 60, 14);
	lblPontuacao.setVisible(false);
	
	lblJogador = new JLabel("Jogador:");
	lblJogador.setForeground(Color.WHITE);
	lblJogador.setBounds(15, 323, 56, 14);
	lblJogador.setVisible(false);
	
	labelnomejogador = new JLabel("");
	labelnomejogador.setForeground(Color.WHITE);
	labelnomejogador.setBounds(77, 323, 246, 15);
	labelnomejogador.setVisible(false);
	
	labelponto = new JLabel("0");
	labelponto.setForeground(Color.WHITE);
	labelponto.setBounds(618, 323, 22, 14);
	labelponto.setVisible(false);
	
	lblImgJogar = new JLabel("");
	lblImgJogar.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\vamosJogar.png"));
	lblImgJogar.setBounds(174, 11, 328, 60);
	
	btnDonw = new JButton();
	btnDonw.setBounds(287, 165, 80, 80);
	btnDonw.setBorder(null);
	btnDonw.setBackground(null);
	btnDonw.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\2.png"));
	btnDonw.setVisible(false);	
	
	btnLeft = new JButton();
	btnLeft.setBounds(188, 113, 80, 80);
	btnLeft.setBorder(null);
	btnLeft.setBackground(null);
	btnLeft.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\1.png"));
	btnLeft.setVisible(false);
	
	btnRigth = new JButton();
	btnRigth.setBounds(384, 113, 80, 80);
	btnRigth.setBorder(null);
	btnRigth.setBackground(null);
	btnRigth.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\4.png"));
	btnRigth.setVisible(false);
	
	btnUp = new JButton();
	btnUp.setBounds(287, 63, 80, 80);
	btnUp.setBorder(null);
	btnUp.setBackground(null);
	btnUp.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\3.png"));
	btnUp.setVisible(false);
	
	buttonScore = new JButton("");
	buttonScore.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\botaoScore.png"));
	buttonScore.setBorder(null);
	buttonScore.setBounds(234, 107, 185, 69);
	buttonScore.addActionListener( new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try 
					{
						JanelaPontuacao pontuacao = new JanelaPontuacao();
						pontuacao.setVisible(true);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
		}
	});
	
	btnJogar = new JButton("");
	btnJogar.setBorder(null);
	btnJogar.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\jogar.png"));
	btnJogar.setBounds(234, 205, 185, 69);
	btnJogar.addActionListener( new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try 
					{
						
						
						JanelaCadJogador frame = new JanelaCadJogador();
						btnJogar.setVisible(false);
						buttonScore.setVisible(false);
						lblImgJogar.setVisible(false);
						frame.setVisible(true);
						
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
		}
	});
	
	
	contentPane.setLayout(null);
	contentPane.add(buttonScore);
	contentPane.add(lblJogador);
	contentPane.add(labelnomejogador);
	contentPane.add(lblPontuacao);
	contentPane.add(labelponto);
	contentPane.add(btnJogar);
	contentPane.add(btnLeft);
	contentPane.add(btnDonw);
	contentPane.add(btnUp);
	contentPane.add(btnRigth);
	contentPane.add(lblImgJogar);
	
	
	lblbackground = new JLabel("");
	lblbackground.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\background.png"));
	lblbackground.setBounds(0, 0, 654, 349);
	contentPane.add(lblbackground);
	
	lblVamosJogar = new JLabel("Vamos Jogar?");
	lblVamosJogar.setBounds(15, 11, 164, 29);
	lblVamosJogar.setVisible(false);
	contentPane.add(lblVamosJogar);
	
	contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnJogar, btnLeft, btnDonw, btnUp, btnRigth, lblJogador, labelnomejogador, lblPontuacao, labelponto, lblVamosJogar}));
	setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, btnLeft, btnDonw, btnJogar, btnUp, btnRigth, lblJogador, labelnomejogador, lblPontuacao, labelponto, lblVamosJogar}));
	
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setSize(660, 378);
	Conexao.centralizarJanela(JanelaJogo.this);
	}
    
	public static void somaPontuacao()
		{
			int ponto;
			ponto = Integer.parseInt(labelponto.getText());
			ponto = ponto + 10;
			labelponto.setText(String.valueOf(ponto));	
			
		}
	
	public static void gravaPontuacao()
	{
		try
		{
		Conexao.ExecutarComando("UPDATE JOGADOR SET PONTUACAOJOGADOR = " + labelponto.getText() + " WHERE NOMEJOGADOR = '" + labelnomejogador.getText() + "'");
		}
		catch(Exception ef)
		{ 
			System.out.println("Erro ao gravar pontuação " + ef);
		}
	}
	
	public static void bagunçaAleartorio()
	{
		int aux, aux1, aux2, aux3;
		
		Random aleartorio = new Random();	
		aux =  aleartorio.nextInt(4);
		aux1 =  aleartorio.nextInt(4);
		aux2 =  aleartorio.nextInt(4);
		aux3 =  aleartorio.nextInt(4);
		
		if(aux == 0)
		{
			aux = 1;
		}
		
		if(aux1 == 0)
		{
			aux1 = 3;
		}
		
		if(aux2 == 0)
		{
			aux2 = 4;
		}
		
		if(aux3 == 0)
		{
			aux3 = 2;
		}
		lblVamosJogar.setText("" + aux + "" + aux1 + "" + aux2 + "" + aux3);
		
		String path = "res/recarregar.mp3";
		File mp3File = new File(path);
		Musica musica = new Musica();
		musica.tocar(mp3File);
        musica.start();
        
        JanelaValor iniciar = new JanelaValor();
		iniciar.setVisible(true);
	}
	
	
	public static  void comecarJogo()
	{
		bagunçaAleartorio();
		
		btnDonw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String path = "res/4.mp3";
				File mp3File = new File(path);
				Musica musica = new Musica();
				musica.tocar(mp3File);
		        musica.start();
				
				valorBut  = valorBut + "2";
				soma++;
				
				if(valorBut.equals(lblVamosJogar.getText().trim()))
				{
					JOptionPane.showMessageDialog(null, "Sequecia Correta.");
					soma = 0;
					valorBut = "";
					bagunçaAleartorio();
					somaPontuacao();
				}
				
				else if (soma >= 4)
				{
					soma = 0;
					gravaPontuacao();
					int simounao = 0;
					int resposta = JOptionPane.showConfirmDialog(null, "Você Perdeu!\nDeseja Jogar Novamente?", "Atenção", simounao );	
					if(resposta == 0)
					{
						valorBut = "";
						JanelaCadJogador n = new JanelaCadJogador();
						n.setVisible(true);
					}
					else
					{
					System.exit(0);
					}
				}
			}
		});
		
		btnUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				String path = "res/3.mp3";
				File mp3File = new File(path);
				Musica musica = new Musica();
				musica.tocar(mp3File);
		        musica.start();
				
				valorBut  = valorBut + "3";
				soma++;
				
				if(valorBut.equals(lblVamosJogar.getText().trim()))
				{
					JOptionPane.showMessageDialog(null, "Sequecia Correta.");
					soma = 0;
					valorBut = "";
					bagunçaAleartorio();
					somaPontuacao();
				}
				
				else if (soma >= 4)
				{
					soma = 0;
					gravaPontuacao();
					int simounao = 0;
					int resposta = JOptionPane.showConfirmDialog(null, "Você Perdeu!\nDeseja Jogar Novamente?", "Atenção", simounao );	
					if(resposta == 0)
					{
						valorBut = "";
						JanelaCadJogador n = new JanelaCadJogador();
						n.setVisible(true);
					}
					else
					{
					System.exit(0);
					}
				}
			}
		});
		
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String path = "res/2.mp3";
				File mp3File = new File(path);
				Musica musica = new Musica();
				musica.tocar(mp3File);
		        musica.start();
				
				valorBut  = valorBut + "1";
				soma++;
				
				if(valorBut.equals(lblVamosJogar.getText().trim()))
				{
					JOptionPane.showMessageDialog(null, "Sequecia Correta.");
					soma = 0;
					valorBut = "";
					bagunçaAleartorio();
					somaPontuacao();
				}
				
				else if (soma >= 4)
				{
					soma = 0;
					gravaPontuacao();
					int simounao = 0;
					int resposta = JOptionPane.showConfirmDialog(null, "Você Perdeu!\nDeseja Jogar Novamente?", "Atenção", simounao );	
					if(resposta == 0)
					{
						valorBut = "";
						JanelaCadJogador n = new JanelaCadJogador();
						n.setVisible(true);
					}
					else
					{
					System.exit(0);
					}
				}
			}
		});
		
		btnRigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String path = "res/1.mp3";
				File mp3File = new File(path);
				Musica musica = new Musica();
				musica.tocar(mp3File);
		        musica.start();
				
				valorBut  = valorBut + "4";
				soma++;
				
				if(valorBut.equals(lblVamosJogar.getText().trim()))
				{
					JOptionPane.showMessageDialog(null, "Sequecia Correta.");
					soma = 0;
					valorBut = "";
					bagunçaAleartorio();
					somaPontuacao();
				}
				
				else if(soma >= 4)
				{
					soma = 0;
					gravaPontuacao();
					int simounao = 0;
					int resposta = JOptionPane.showConfirmDialog(null, "Você Perdeu!\nDeseja Jogar Novamente?", "Atenção", simounao );	
					if(resposta == 0)
					{
						valorBut = "";
						JanelaCadJogador n = new JanelaCadJogador();
						n.setVisible(true);
					}
					else
					{
					System.exit(0);
					}
				}
			}
		});
	}
	
}