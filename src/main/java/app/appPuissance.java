package app;

import javafx.scene.control.Label;

import app.control.control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class appPuissance extends Application {
	@Override
	public void start(Stage stage) {
		
		control root = new control();
		root.puissanceControl();
		/*
		 * String javaVersion = System.getProperty("java.version"); String javafxVersion
		 * = System.getProperty("javafx.version"); Label l = new
		 * Label("Application , Puissance " + javafxVersion + ", running on Java " +
		 * javaVersion + ".");
		 */
		Scene scene = new Scene(root.getFenetre(), 640, 480);
		 stage.setScene(scene);
		 stage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}
