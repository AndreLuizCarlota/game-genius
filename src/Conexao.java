import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Conexao {

	public static Connection con;
	public static Statement stm;
	private static ResultSet resultado;
	private String codigo, nome, pontos;
	

	   public Conexao() 
	   {
		   try 
	      {
	         Class.forName("org.firebirdsql.jdbc.FBDriver");
	         
	         con = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:C:/Projetos/Java/JogoGenius/DataBase/BANCOJOGO.FDB",
	               "sysdba", "masterkey");
	         
	         stm = con.createStatement();
	         
	         System.out.println("Conexão Realizada com Sucesso.");
	      }
	      catch (Exception e) 
	      {
	         System.out.println("Erro ao Conectar ao Banco: " + e.getMessage());
	      }
	   }

	   public static String ExecutarComando(String query)
	   {
		   try
		   {
			    stm = con.createStatement();
	            stm.executeUpdate(query);
	            System.out.println("ExecutarComando Realizada com Sucesso.");
	        } 
		   catch (Exception e)
		   {
	            e.printStackTrace();
	       }
		  return query; 
	  }

	   public static String RetornaDados(String query)
	   {
		   String linha = null;
		   try {
		            con.createStatement();
		            resultado = stm.executeQuery(query);
		            while (resultado.next())  
	                {  
	                    linha = resultado.getString(1);  
	                }  
		        } 
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
		   		return linha;
		 }
	   
	   public static ArrayList<Conexao> CarregarTabela(String query)
	   {
     	 ArrayList<Conexao> aux = new ArrayList<Conexao>();
     	 Conexao jogador = new Conexao();
		  
		   try{
			    
			      stm = con.createStatement();
			      resultado = stm.executeQuery(query);
			    
			      
			      
			      	while(resultado.next())
			      	{ 
			      		jogador.setCodigo(resultado.getString(1));
			      		jogador.setNome(resultado.getString(2));
			      		jogador.setPontos(resultado.getString(3));
			      		aux.add(jogador);
			      		jogador = new Conexao();
			      	}
			      } 
			 catch (Exception e)
		   	 {
			   System.out.println("SQLException: " + e.getMessage());
			 }
		   
		return  aux;
		
	   }
	   
	   public static void FecharConexao()
	   {
		   try
		   {
	         Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
	         con = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:C:/Projetos/Java/JogoGenius/DataBase/BANCOJOGO.FDB",
	 	     "sysdba", "masterkey");
	         con.close();
	       } 
		   catch(Exception e ) 
		   {
	            System.out.println(e.getMessage());
	       }
	   } 
	   
	   public static void centralizarJanela(Component componente)
	   {
		    Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
	        Rectangle r = componente.getBounds();  
	        int widthSplash = r.width ;  
	        int heightSplash = r.height;  
	        int posX = (tela.width / 2) - ( widthSplash / 2 );  
	        int posY = (tela.height / 2) - ( heightSplash / 2 );  
	        componente.setBounds(posX,posY,widthSplash,heightSplash);  
	  }
	  
	public String getCodigo() {
		return codigo;
	}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPontos() {
		return pontos;
	}

	public void setPontos(String pontos) {
		this.pontos = pontos;
	}
}
