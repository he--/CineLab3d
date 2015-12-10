package cine;

import java.util.Date;

import com.sun.java.swing.plaf.windows.WindowsBorders.DashedBorder;

import javafx.scene.chart.PieChart.Data;

public class Sessao {

	private String horario;
	
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

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}
	
}
