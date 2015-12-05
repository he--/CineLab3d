package cine;

public class Cadeira {
	
	private boolean ocupada;
	
	private Cliente cliente;
	
	public Cadeira(){
		this.ocupada = false;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	@Override
	public String toString() {
		return this.ocupada ? "ocupada" : " livre ";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.ocupada = true;
		this.cliente = cliente;
	}
}
