package SaberYGanar;

import javax.persistence.Entity;
import javax.persistence.Table;

import BDD.Selects;

@Entity
@Table(name = "Ingles")
public class Ingles extends Preguntas {
	static Selects selec = new Selects();
	String respuestaCorrecta, respuestas;

	public Ingles(int numRandom) {
		super(selec.selecEnunciadoIngles(numRandom));
		this.respuestaCorrecta = selec.selecRespuestasCorrectaIngles(enunciado);
		this.respuestas = selec.selecRespuestasIngles(numRandom);
	}
	
	public Ingles() {
		
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public String getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}
	
	
}
