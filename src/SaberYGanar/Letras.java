package SaberYGanar;

import javax.persistence.Entity;
import javax.persistence.Table;

import BDD.Selects;

@Entity
@Table(name = "Letras")
public class Letras extends Preguntas {
	static Selects selec = new Selects();
	String palabraEntera;

	public Letras(int numRandom) {
		super(selec.selecOcultaLetras(numRandom));
		this.palabraEntera = selec.selecPalabraCompleta(selec.selecOcultaLetras(numRandom));;
	}
	
	public Letras() {
	}
	

	public String getPalabraEntera() {
		return palabraEntera;
	}

	public void setPalabraEntera(String palabraEntera) {
		this.palabraEntera = palabraEntera;
	};
	
	
	
	
}
