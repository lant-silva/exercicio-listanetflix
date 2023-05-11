package control;
import model.Lista;

public interface INetflixController {
	
	public void gerarArquivoMajorGenre(String pesquisa, String arquivoNome) throws Exception;
	public void gerarArquivoPremiereYear(String year, String arquivoNome) throws Exception;
	public void tabelaEspalhamentoEstrela(Lista serie) throws Exception;
	public void buscaEstrela(int estrela) throws Exception;
	
}
