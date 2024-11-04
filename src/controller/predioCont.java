/*2. Considerando um projeto Java, com a importação de uma biblioteca de Lista Genérica, que resolva
o seguinte problema.
• Uma portaria de prédio precisa fazer o controle dos acessos dos carros dos moradores de um
prédio de 10 andares. Cada morador tem o número do apartamento, o nome do morador, o
modelo, a cor e a placa do carro. Todos os carros tem um crachá com o número do
apartamento.
• Os apartamentos são numerados de acordo com o andar (Ap. 101, 102, 201, 202, 701, ...)
• A solução deve criar uma tabela de espalhamento que permita cadastrar, consultar e excluir
morador (O model morador deve ser criado), bem como listar os moradores de um
determinado andar.
• Deve-se criar uma função hash customizada e específica para o problema.
• A técnica adotada para a tabela de espalhamento deverá ser a Técnica de Encadeamento
*/
package controller;

import model.Morador;

import javax.swing.JOptionPane;

import br.edu.fateczl.*;

public class predioCont {
	Lista[] predio;

	public predioCont() {
		predio = new Lista[10];
		inicializarLista();
	}

	private void inicializarLista() {
		int tamanho = predio.length;
		for (int i = 0; i < tamanho; i++) {
			predio[i] = new Lista();
		}
	}

	public void addMorador(Morador morador) {
		int andar = morador.hashCode() - 1;
		try {
			predio[andar].addLast(morador);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public Morador findMorador(Morador morador) throws Exception {
		int posicao = morador.hashCode() - 1;
		int tamanho = predio[posicao].size();

		for (int i = 0; i < tamanho; i++) {
			Morador m = (Morador) predio[posicao].get(i);
			if (m.getNumAp() == morador.getNumAp()) {
				return m;
			}
		}

		throw new Exception("Morador não encontrado");
	}

	public void removeMorador(Morador morador) throws Exception {
		int posicao = morador.hashCode() - 1;
		int tamanho = predio[posicao].size();

		for (int i = 0; i < tamanho; i++) {
			Morador m = (Morador) predio[posicao].get(i);
			if (m.getNumAp() == morador.getNumAp()) {
				predio[posicao].remove(i);
				System.out.println("Morador removido");
				break;
			}
		}
	}
	
	public void listAndar(int andar) throws Exception {
		int tamanho = predio[andar].size();
		for(int i = 0; i < tamanho; i++) {
			Morador m = (Morador) predio[andar].get(i);
			System.out.println(m.toString());
		}
		
		if(predio[andar].isEmpty()) {
			JOptionPane.showMessageDialog(null, "Andar vazio");
		}
		
	}
}
