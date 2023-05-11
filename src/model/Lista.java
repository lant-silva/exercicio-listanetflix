package model;

public class Lista {

	No primeiro;
	
	public boolean isEmpty() {
		if(primeiro == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size() {
		int cont = 0;
		if(!isEmpty()) {
			No auxiliar = primeiro;
			while(auxiliar!=null) {
				cont ++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	
	private No getNo(int pos) throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		int tamanho = size();
		if(pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição inválida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while(cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar;
	}
	
	public void addFirst(Object valor) {
		
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	
	public void addLast(Object valor) throws Exception{
		int tamanho = size();
		if(isEmpty()) {
			throw new Exception("Lista Vazia");			
		}
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = null; // redundante
		No ultimo = getNo(tamanho-1);
		ultimo.proximo = elemento;
	}
	
	public void add(Object valor, int pos) throws Exception {
		int tamanho = size();
		if(pos < 0 || pos > tamanho) {
			throw new Exception("Posição inválida");
		}
		if(pos == 0) {
			addFirst(valor);
		}else {
			if(pos == tamanho) {
				addLast(valor);
			}else {
				No elemento = new No();
				elemento.dado = valor;
				No anterior = getNo(pos - 1);
				elemento.proximo = anterior.proximo;
				anterior.proximo = elemento;
			}
		}
	}
	
	public void removeFirst() throws Exception{
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		primeiro = primeiro.proximo;
	}
	
	public void removeLast() throws Exception{
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		int tamanho = size();
		if(tamanho == 1) {
			removeFirst();
		}else {
			No penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
	}
	
	public void remove(int pos) throws Exception{
		int tamanho = size();
		if(pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição inválida");
		}
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		if(pos == 0) {
			removeFirst();
		}else {
			if(pos == tamanho - 1) {
				removeLast();
			}else {
				No anterior = getNo(pos - 1);
				No atual = getNo(pos);
				anterior.proximo = atual.proximo;
			}
		}	
	}
	
	public Object get(int pos) throws Exception{
		if(isEmpty()) {
			throw new Exception("Lista vazia");
		}
		int tamanho = size();
		if(pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição inválida");
		}
		int cont = 0;
		No auxiliar = primeiro;
		while(cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar.dado;
	}
	
	/*
	* vectorInit
	* Esse método recebe um vetor (de tipo equivalente a biblioteca), e recebe uma fila
	* 
	* Esse método tem como objetivo inicializar uma fila a partir de vetores, inserindo os valores do vetor na fila
	* portanto, não é recomendado utilizar uma fila que ja contém elementos nela
	* 
	* Como medida de impedir potenciais erros, apenas filas vazias irão ser utilizadas
	*/
	
	
	public Lista vectorInit(Object[] vet, Lista lista) throws Exception {
		
		if(vet.length == 0) {
			throw new Exception("Vetor vazio");
		}else if(lista.size()>0) {
			throw new Exception("Essa lista possui elementos préviamente inseridos\nComo medida de impedir erros, apenas filas vazias devem ser utilizadas");
			}else {
				try {
					for(int i=0 ; i < vet.length; i++) {
						lista.add(vet[i], i);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return lista;		
	} 
	
	/*
	 * printList
	 * Esse método tem como objetivo fazer o print de todos os valores atuais de uma lista no console
	 */
	
	public void printList(Lista lista) throws Exception{
		
		if(lista.isEmpty()) {
			throw new Exception("Lista vazia");
		}
		
		for(int i=0;i < lista.size()-1;i++ ) {
			System.out.println(lista.get(i));
		}
	}
}
