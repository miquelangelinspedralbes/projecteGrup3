package SaberYGanar;

import javax.persistence.Entity;
import javax.persistence.Table;

import BDD.Selects;

@Entity
@Table(name = "Mates")
public class Mates extends Preguntas {
	static Selects selec = new Selects();
	int resultado;

	public Mates(int number) {
		super(selec.selecEcuacioMates(number));
		resultado = selec.respuestaMates(selec.selecEcuacioMates(number));
	}
	
	public Mates() {
		
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}	
	
	
	
}
