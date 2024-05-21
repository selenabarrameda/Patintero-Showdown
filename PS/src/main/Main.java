package main;

import javafx.application.Application;
import javafx.stage.Stage;
import scenes.MenuStage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		MenuStage menuStage = new MenuStage();
		menuStage.setStage(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}