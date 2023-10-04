import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Julian Coward Homework 3");
		Button btn1 = new Button("button 1");
		Button btn2 = new Button("button 2");
		BorderPane borderPane = new BorderPane();
		VBox buttons = new VBox(50,btn1, btn2);
		TextField textField = new TextField("enter text here then press button 1");
		borderPane.setCenter(textField);
		borderPane.setLeft(buttons);
		textField.setMaxWidth(300);
		Scene scene = new Scene(borderPane, 700,700);
		textField.setAlignment(Pos.CENTER);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
