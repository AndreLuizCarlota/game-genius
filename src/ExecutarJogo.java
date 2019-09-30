import java.io.File;

public class ExecutarJogo {

	public static void main(String[] args){
		new Conexao();
		
				String path = "res/musica.mp3";
				File mp3File = new File(path);
				Musica musica = new Musica();
				musica.tocar(mp3File);
		        musica.start();
		       
		JanelaJogo iniciar = new JanelaJogo();
		iniciar.setVisible(true);
	 }
}  


