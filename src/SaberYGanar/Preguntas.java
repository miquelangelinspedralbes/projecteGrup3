package SaberYGanar;

import javax.persistence.*;

public abstract class Preguntas  {

	String enunciado;
	
	public Preguntas(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public Preguntas() {
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	
	
}
