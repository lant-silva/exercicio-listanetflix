package view;

import javax.swing.JOptionPane;

import control.NetflixController;

public class Main {
	public static void main(String[] args) throws Exception {
		
		NetflixController net = new NetflixController();
		String arquivo = "netflixSeries.txt";
		String path = "C:\\TEMP";
		
		String genero = JOptionPane.showInputDialog("Digite um genero");
		String novoArquivo = JOptionPane.showInputDialog("Digite um novo arquivo");
		
		net.gerarArquivoMajorGenre(genero, novoArquivo);
		
		
	}
}
