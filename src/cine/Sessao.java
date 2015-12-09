package cine;

import java.util.Date;

import com.sun.java.swing.plaf.windows.WindowsBorders.DashedBorder;

import javafx.scene.chart.PieChart.Data;

public class Sessao {

	private Date horario;
	
	private String filme;
	
	public void Sessao()
	{
		this.horario  = new Date();
		this.filme    = "";
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}
	
}
