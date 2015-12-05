package cine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import cine.Cadeira;

public class Cinema
{

	private String[] letra;

	private int[] fileira;

	private Sala sala;
	
	private Scanner inInt ;
	
	private Scanner inString ;

	public Cinema()
	{
		this.letra = new String[6];
		this.fileira = new int[10];
		this.sala = new Sala();
		this.inInt    = new Scanner(System.in);
		this.inString = new Scanner(System.in);
	}

	public void abreSala()
	{
		this.letra[0] = "A";
		this.letra[1] = "B";
		this.letra[2] = "C";
		this.letra[3] = "D";
		this.letra[4] = "E";
		this.letra[5] = "F";
		
		this.fileira[0] = 1;
		this.fileira[1] = 2;
		this.fileira[2] = 3;
		this.fileira[3] = 4;
		this.fileira[4] = 5;
		this.fileira[5] = 6;
		this.fileira[6] = 7;
		this.fileira[7] = 8;

		for (int i = 0; i < fileira.length ; i++) {
			for (int j = 0; j < letra.length; j++) {
				Cadeira cadeira = new Cadeira();
				Legenda legenda = new Legenda();
				legenda.setLetra((String)this.letra[j]);
				legenda.setNumero(i);
				this.sala.locaCadeira(legenda, cadeira);
			}
		}
	}

	public void flashSala()
	{
		System.out.println("-----A-------B-------C-------D-------E-------F----");
		for (int j = 0; j < this.fileira.length; j++) {
			System.out.print(j + " ");
			for (int i = 0; i < this.letra.length; i++) {
				//@todo fazer construtor com dois parametros
				Legenda legenda = new Legenda();
				legenda.setLetra(this.letra[i]);
				legenda.setNumero(j);
				System.out.print(this.sala.getCadeira(legenda).toString() +" ");
			}
			System.out.println();
		}
		this.inString.nextLine();
	}
	
	public void vendeIngresso()
	{
		System.out.println("Digite a coluna da cadeira");
		String letra = this.inString.nextLine();
		System.out.println("Digite a fila da cadeira");
		int fila = this.inInt.nextInt();
		Legenda legenda = new Legenda();
		legenda.setLetra(letra);
		legenda.setNumero(fila);
		
		System.out.println("Digite o nome do cliente");
		String nome = this.inString.nextLine();
		System.out.println("Digite o telefone do cliente");
		String telefone = this.inString.nextLine();
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		
		Cadeira cadeira = this.sala.getCadeira(legenda);
		if (cadeira.isOcupada()){
			System.out.println("Cadeira já ocupada");
		} else {
			cadeira.setCliente(cliente);
			System.out.println("ingresso vendido com sucesso!!!");
		}
	}
	
	public void findIngressoNome()
	{
		System.out.println("Digite o nome do cliente para a pesquisa.");
		String nome = this.inString.nextLine();
		
		Set<Legenda> legendas = this.sala.getCadeiras().keySet();
		Iterator<Legenda> chavesIterator = legendas.iterator();
		while (chavesIterator.hasNext()) {
			Legenda leg = chavesIterator.next();
			Cadeira cadeira = this.sala.getCadeira(leg);
			if (cadeira.getCliente() != null && cadeira.getCliente().getNome().equals(nome)) {
				System.out.println("Nome Cliente: "+cadeira.getCliente().getNome());
				System.out.println("      Status: "+cadeira.isOcupada());
				System.out.println("    Telefone: "+cadeira.getCliente().getTelefone());
			}
		}
	}

}
