package dad.calculadoraCompleja.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {
	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imaginario = new SimpleDoubleProperty();
	
	public Complejo() {}
	
	public Complejo(double real, double imaginario) {
		super();
		setReal(real);
		setImaginario(imaginario);
	}

	public final DoubleProperty realProperty() {
		return this.real;
	}

	public final double getReal() {
		return this.realProperty().get();
	}

	public final void setReal(final double real) {
		this.realProperty().set(real);
	}

	public final DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}

	public final double getImaginario() {
		return this.imaginarioProperty().get();
	}

	public final void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}
	
	@Override
	public String toString() {
		return getReal() + "+" + getImaginario() + "i";
	}
	
	public Complejo add(Complejo c) {
		Complejo r = new Complejo();
		r.realProperty().bind(realProperty().add(c.realProperty()));
		r.imaginarioProperty().bind(imaginarioProperty().add(c.imaginarioProperty()));
		return r;
	}
	
	public static Complejo sumarComplejos(Complejo a, Complejo b) {
		double numReal = a.getReal() + b.getReal();
		double numI = a.getImaginario() + b.getImaginario();
		Complejo resultado = new Complejo(numReal, numI);
		return resultado;
	}
	
	public static Complejo restarComplejos(Complejo a, Complejo b) {
		double numReal = a.getReal() - b.getReal();
		double numI = a.getImaginario() - b.getImaginario();
		Complejo resultado = new Complejo(numReal, numI);
		return resultado;
	}
	
	public static Complejo multiplicarComplejos(Complejo a, Complejo b) {
		double numReal = (a.getReal()*b.getReal()) - (a.getImaginario()*b.getImaginario());
		double numI = (a.getReal()*b.getImaginario()) + (a.getImaginario()*b.getReal());
		Complejo resultado = new Complejo(numReal, numI);
		return resultado;
	}
	
	public static Complejo dividirComplejos(Complejo a, Complejo b) {
		double numReal = (a.getReal()*b.getReal()) + (a.getImaginario()*b.getImaginario()) / Math.pow(b.getReal(), 2) + Math.pow(b.getImaginario(), 2);
		double numI = (a.getImaginario()*b.getReal()) - (b.getImaginario()*a.getReal()) / Math.pow(b.getReal(), 2) + Math.pow(b.getImaginario(), 2);
		Complejo resultado = new Complejo(numReal, numI); 
		return resultado;
	}
}
