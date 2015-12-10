package cine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Sala {

	private  Map<Legenda, Cadeira> cadeiras;

	private Sessao sessao;

	private String nome;

	private String descricao;

	public Sala()
	{
		this.cadeiras = new HashMap<Legenda, Cadeira>();
		this.sessao = new Sessao();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void locaCadeira(Legenda legenda, Cadeira cadeira)
	{
		cadeiras.put(legenda, cadeira);
	}

	public Cadeira getCadeira(Legenda legenda)
	{
		Set<Legenda> legendas = this.cadeiras.keySet();
		Iterator<Legenda> chavesIterator = legendas.iterator();
		while (chavesIterator.hasNext()) {
			Legenda leg = chavesIterator.next();
			if (leg.getLetra().equals(legenda.getLetra()) && leg.getNumero() == legenda.getNumero()) {
				return this.cadeiras.get(leg);
			}
		}
		return null;
	}

	public Map getCadeiras()
	{
		return this.cadeiras;
	}

	@Override
	public String toString() {
		return "Nome: "+this.nome+"\nDescricao: "+this.descricao;
	}

}
