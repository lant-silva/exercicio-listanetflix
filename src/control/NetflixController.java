package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.Lista;
import model.Serie;

public class NetflixController implements INetflixController{

	@Override
	public void gerarArquivoMajorGenre(String pesquisa, String arquivoNome) throws Exception {
		Lista l = new Lista();
		String dir = "C:\\TEMP";
		File arquivo = new File(dir, "netflixSeries.txt");
		if(arquivo.exists() && arquivo.isFile()) {
			l = gerarListaMajorGenre(arquivo, pesquisa);
			File novoArquivo = new File(dir, arquivoNome);
			gerarArquivo(novoArquivo, l);
		}else {
			throw new Exception("Arquivo não existe");
		}
	}

	@Override
	public void gerarArquivoPremiereYear(String year, String arquivoNome) throws Exception {
		Lista l = new Lista();
		String dir = "C:\\TEMP";
		File arquivo = new File(dir, "netflixSeries.txt");
		if(arquivo.exists() && arquivo.isFile()) {
			l = gerarListaPremiereYear(arquivo, year);
			File novoArquivo = new File(dir, arquivoNome);
			gerarArquivo(novoArquivo, l);
		}else {
			throw new Exception("Arquivo não existe");
		}
		
	}


	@Override
	public void tabelaEspalhamentoEstrela(Lista serie) throws Exception {

	}

	@Override
	public void buscaEstrela(int estrela) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private Lista gerarListaMajorGenre(File arquivo, String pesquisa) throws IOException {
		FileInputStream fluxo = new FileInputStream(arquivo);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		linha = buffer.readLine();
		Lista l = new Lista();
		Serie o;
		while(linha!=null) {
			String[] lista = linha.split(";");
			o = new Serie(lista[0],lista[1],lista[2],Integer.parseInt(lista[4]),lista[5],lista[6],Integer.parseInt(lista[11]));
			if(l.isEmpty()) {
				l.addFirst(o);
			}else {
				try {
					l.addLast(o);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		while(!l.isEmpty()) {
			Serie cont = null;
			Lista aux = null;
			try {
				cont = (Serie) l.get(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cont.getMajorGenre().contains(pesquisa)) {
				if(aux.isEmpty()) {
					aux.addFirst(cont);
				}else {
					try {
						aux.addLast(cont);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		buffer.close();
		leitor.close();
		fluxo.close();
		return l;
	}
	
	private Lista gerarListaPremiereYear(File arquivo, String year) throws IOException {
		FileInputStream fluxo = new FileInputStream(arquivo);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		linha = buffer.readLine();
		Lista l = new Lista();
		Serie o;
		while(linha!=null) {
			String[] lista = linha.split(";");
			if(lista[3].contains(year) && lista[5].contains("Renewed")) {
				o = new Serie(lista[0],lista[1],lista[2],Integer.parseInt(lista[4]),lista[5],lista[6],Integer.parseInt(lista[11]));
				
				if(l.isEmpty()) {
					l.addFirst(o);
				}else {
					try {
						l.addLast(o);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		buffer.close();
		leitor.close();
		fluxo.close();
		return l;
	}

	
	private void gerarArquivo(File arquivo, Lista lista) throws IOException {
		Serie o = null;
		boolean exists = false;
		if(arquivo.exists()) {
			exists = true;
		}
		while(!lista.isEmpty()) {
			try {
				o = (Serie)(lista.get(0));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String conteudo = o.getMajorGenre()+";"+o.getTitle()+";"+o.getSubGenre()+";"+o.getPremiereYear()+";"+o.getEpisodes()+";"+o.getStatus()+";"+o.getImdbRating()+"\n";
			FileWriter escrita = new FileWriter(arquivo, exists);
			PrintWriter print = new PrintWriter(escrita);
			print.write(conteudo);
			print.flush();
			try {
				lista.removeFirst();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}			
	}
}
