package dad.calculadoraCompleja.app;

import dad.calculadoraCompleja.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	private Controller controlador;
	
	public void start(Stage primaryStage)throws Exception{
		controlador = new Controller();
		Scene scene = new Scene (controlador.getView(),400,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculadora Compleja");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);

	}

}
