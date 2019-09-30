import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class JanelaPontuacao extends JFrame{
    
	private static final long serialVersionUID = 1L;

	private JPanel contentPainel;
	private JLabel lblPontuacoes;
	private JTable tabelaJogo;
	private JLabel lblBackground;
	private JLabel lblCodJogador;
	private JLabel lblNome1jogador;
	private JLabel lblPontuacao;
	
	public JanelaPontuacao(){
		
		super("Score");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Projetos\\Java\\JogoGenius\\src\\icoJogo.png"));
		
		contentPainel = new JPanel();
		contentPainel.setBackground(Color.WHITE);
		contentPainel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPainel);
		
		lblPontuacoes = new JLabel("");
		lblPontuacoes.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\Score.png"));
		lblPontuacoes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontuacoes.setBounds(256, 11, 141, 38);
		lblPontuacoes.setForeground(Color.BLUE);
		lblPontuacoes.setFont(new Font("Arial", Font.PLAIN, 22));
		
		lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(238, 232, 170));
		lblBackground.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\background.png"));
		lblBackground.setBounds(-1, 0, 657, 347);
		
		lblPontuacao = new JLabel("");
		lblPontuacao.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\pontuacao.png"));
		lblPontuacao.setBounds(513, 75, 126, 28);
		
		lblNome1jogador = new JLabel("");
		lblNome1jogador.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\jogador.png"));
		lblNome1jogador.setBounds(256, 75, 126, 28);
		
		lblCodJogador = new JLabel("");
		lblCodJogador.setIcon(new ImageIcon("C:\\Projetos\\Java\\JogoGenius\\src\\codJogador.png"));
		lblCodJogador.setBounds(10, 75, 126, 28);
		
		DefaultTableModel modelo;
		
		tabelaJogo = new JTable();
		tabelaJogo.setShowHorizontalLines(false);
		tabelaJogo.setShowVerticalLines(false);
		tabelaJogo.setFont(new Font("Arial", Font.BOLD, 14));
		tabelaJogo.setForeground(new Color(128, 0, 0));
		tabelaJogo.scrollRectToVisible(getBounds());
		tabelaJogo.setBounds(10, 114, 629, 204);
		tabelaJogo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaJogo.setEnabled(true);
		tabelaJogo.setBorder(null);
		tabelaJogo.setBackground(new Color(238, 232, 170));
		tabelaJogo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tabelaJogo.setEnabled(false);
		modelo = (DefaultTableModel) tabelaJogo.getModel();
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nome");
		modelo.addColumn("Pontos");

		for (Conexao c :  Conexao.CarregarTabela("SELECT * FROM JOGADOR WHERE PONTUACAOJOGADOR >= 50 ORDER BY PONTUACAOJOGADOR DESC"))
		{
			modelo.addRow(new Object[]{c.getCodigo(), c.getNome(),c.getPontos()});
		}
		
		contentPainel.setLayout(null);
		contentPainel.add(lblPontuacoes);
		contentPainel.add(tabelaJogo);
		contentPainel.add(lblCodJogador);
		contentPainel.add(lblNome1jogador);
		contentPainel.add(lblPontuacao);
		contentPainel.add(lblBackground);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(660, 376);
		Conexao.centralizarJanela(JanelaPontuacao.this);
	}
}