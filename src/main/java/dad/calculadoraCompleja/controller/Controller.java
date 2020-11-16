package dad.calculadoraCompleja.controller;

import dad.calculadoraCompleja.model.Complejo;
import dad.calculadoraCompleja.view.View;
import javafx.event.ActionEvent;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Controller {
	StringConverter<Number> convertidor = new NumberStringConverter();
	View vista= new View();
	Complejo primerNumero= new Complejo(0,0);
	Complejo segundoNumero= new Complejo(0,0);
	
	public Controller() {
		try {
			vista.getNumeroRealA().textProperty().bindBidirectional(primerNumero.realProperty(),convertidor);
			vista.getNumeroIA().textProperty().bindBidirectional(primerNumero.imaginarioProperty(),convertidor);
			vista.getNumeroRealB().textProperty().bindBidirectional(segundoNumero.realProperty(),convertidor);
			vista.getNumeroIB().textProperty().bindBidirectional(segundoNumero.imaginarioProperty(),convertidor);
		}
		catch (Exception er){
			System.out.println(er.getMessage());
		}
		vista.getCalcular().setOnAction(e -> {
			calcularOnAction(e);
		});
	}

	private void calcularOnAction(ActionEvent e) {
		String calculo= vista.getOperador().getSelectionModel().getSelectedItem().toString();
		Complejo resultado= new Complejo(0,0);
		
		switch (calculo) {
		case "+": {
			resultado = Complejo.sumarComplejos(primerNumero, segundoNumero);
			break;
		}
		case "-": {
			resultado = Complejo.restarComplejos(primerNumero, segundoNumero);
			break;
		}
		case "x": {
			resultado = Complejo.multiplicarComplejos(primerNumero, segundoNumero);
			break;
		}
		case "/": {
			resultado = Complejo.dividirComplejos(primerNumero, segundoNumero);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + calculo);
		}
		
		vista.getResultadoReal().setText(resultado.getReal()+"");
		vista.getResultadoI().setText(resultado.getImaginario()+"");
	}
	public View getView() {
		return vista;
	}
}
