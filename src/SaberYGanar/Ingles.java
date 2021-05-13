package SaberYGanar;

import BDD.Selects;

public class Ingles extends Preguntas {
	static Selects selec = new Selects();
	String respuestaCorrecta, respuestas;

	public Ingles(int numRandom) {
		super(selec.selecEnunciadoIngles(numRandom));
		this.respuestaCorrecta = selec.selecRespuestasCorrectaIngles(enunciado);
		this.respuestas = selec.selecRespuestasIngles(numRandom);
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public String getRespuestas() {
		return respuestas;
	}
	
	
}
