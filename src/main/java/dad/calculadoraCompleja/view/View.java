package dad.calculadoraCompleja.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends HBox {
	private ComboBox operador;
	ObservableList<String> opciones= FXCollections.observableArrayList("+","-","*","/");
	private TextField numeroRealA,numeroIA,numeroRealB,numeroIB,resultadoReal,resultadoI;
	private Button calcular;
	
	public View() {
		operador= new ComboBox(opciones);
		operador.getSelectionModel().select(0);
		VBox operaciones=new VBox();
		operaciones.setAlignment(Pos.CENTER);
		operaciones.getChildren().addAll(operador);
		
		HBox arriba=new HBox();
		arriba.setSpacing(3);
		Label sumaA=new Label("+");
		Label iA=new Label ("i");
		numeroRealA=new TextField();
		numeroRealA.setPrefWidth(30);
		numeroRealA.setText("0");
		numeroIA=new TextField();
		numeroIA.setPrefWidth(30);
		numeroIA.setText("0");
		arriba.getChildren().addAll(numeroRealA,sumaA,numeroIA,iA);
		
		Separator sep = new Separator();
		
		HBox abajo= new HBox();
		abajo.setSpacing(3);
		Label sumaB=new Label("+");
		Label iB=new Label ("i");
		numeroRealB=new TextField();
		numeroRealB.setPrefWidth(30);
		numeroRealB.setText("0");
		numeroIB=new TextField();
		numeroIB.setPrefWidth(30);
		numeroIB.setText("0");
		abajo.getChildren().addAll(numeroRealB,sumaB,numeroIB,iB);
		
		HBox cajaResultado= new HBox();
		cajaResultado.setSpacing(3);
		Label sumaR=new Label("+");
		Label iR=new Label ("i");
		resultadoReal= new TextField();
		resultadoReal.setDisable(true);
		resultadoReal.setText("0");
		resultadoI= new TextField();
		resultadoI.setDisable(true);
		resultadoI.setText("0");
		cajaResultado.getChildren().addAll(resultadoReal,sumaR,resultadoI,iR);
		
		VBox contenedor= new VBox();
		contenedor.setSpacing(5);
		contenedor.setAlignment(Pos.CENTER);
		contenedor.getChildren().addAll(arriba, abajo, sep, cajaResultado);
		
		calcular = new Button();
		calcular.setText("=");
		VBox cajaBoton=new VBox();
		cajaBoton.setAlignment(Pos.CENTER);
		cajaBoton.getChildren().addAll(calcular);
		
		setSpacing(5);
		setAlignment(Pos.CENTER);
		getChildren().addAll(operaciones,contenedor,cajaBoton);
	}

	public ComboBox getOperador() {
		return operador;
	}

	public TextField getNumeroRealA() {
		return numeroRealA;
	}

	public TextField getNumeroIA() {
		return numeroIA;
	}

	public TextField getNumeroRealB() {
		return numeroRealB;
	}

	public TextField getNumeroIB() {
		return numeroIB;
	}

	public TextField getResultadoReal() {
		return resultadoReal;
	}

	public TextField getResultadoI() {
		return resultadoI;
	}

	public Button getCalcular() {
		return calcular;
	}
	
}
