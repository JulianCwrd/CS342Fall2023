import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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

		TextField txt1 = new TextField("enter text here then press button 1");
		TextField txt2 = new TextField("final string goes here");
		txt2.setEditable(false);

		btn1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent action){
				txt2.setText(txt1.getText() + " : from the center text field!");
				btn1.setDisable(true);
				btn1.setText("pressed");
			}
		});

		btn2.setOnAction(e -> {
			txt1.clear();
			txt2.clear();
			txt2.setText("final string goes here");
			btn1.setDisable(false);
			btn1.setText("button 1");
		});

		borderPane.setCenter(txt1);
		borderPane.setRight(txt2);
		borderPane.setLeft(buttons);
		txt2.setAlignment(Pos.CENTER);

		Scene scene = new Scene(borderPane, 700,700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
