package cine;

public class Legenda {

	private String letra;
	private int numero;


	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Legenda [letra=" + letra + ", numero=" + numero + "]";
	}

}
