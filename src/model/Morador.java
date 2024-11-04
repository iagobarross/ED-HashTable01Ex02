package model;

import java.util.Objects;

public class Morador {
	
	private int numAp;
	private String nome;
	private String modeloCarro;
	private String corCarro;
	private String placaCarro;
	
	
	
	public Morador() {
		super();
	}

	@Override
	public String toString() {
		return "Morador numAp=" + numAp + ", nome=" + nome + ", modeloCarro=" + modeloCarro + ", corCarro=" + corCarro
				+ ", placaCarro=" + placaCarro;
	}

	@Override
	public int hashCode() {
		int posicao = numAp / 100;
		return posicao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Morador other = (Morador) obj;
		return Objects.equals(corCarro, other.corCarro) && Objects.equals(modeloCarro, other.modeloCarro)
				&& Objects.equals(nome, other.nome) && numAp == other.numAp
				&& Objects.equals(placaCarro, other.placaCarro);
	}

	public int getNumAp() {
		return numAp;
	}

	public void setNumAp(int numAp) {
		this.numAp = numAp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getCorCarro() {
		return corCarro;
	}

	public void setCorCarro(String corCarro) {
		this.corCarro = corCarro;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}
	
	
	
	
}
