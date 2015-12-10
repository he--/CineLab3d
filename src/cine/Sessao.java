package cine;

import java.util.Date;

import com.sun.java.swing.plaf.windows.WindowsBorders.DashedBorder;

import javafx.scene.chart.PieChart.Data;

public class Sessao {

	private String horario;

	private String descricao;
	
	private String filme;

	public Sessao(String horario, String filme) {
		super();
		this.horario = horario;
		this.filme = filme;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Horario: "+this.horario + "\nDescrição: "+this.descricao;
	}
}
