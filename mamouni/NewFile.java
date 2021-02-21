//package mamouni;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewFile {

	private static String file1 ;
	public static void display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("New File");
		window.setMinWidth(250);
		window.setMinHeight(200);
		
		Label label = new Label();
		label.setText("Enter the name of the file!");
		TextField text = new TextField();
		Button submit = new Button("Submit");
		
		submit.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			

			@Override
            public void handle(ActionEvent event) {
            	NewFile.setFile(text.getText());
            	 window.close();  
            	
            }
        });
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,text,submit);
		layout.setAlignment(Pos.CENTER);

		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
	public static String getFile() {
		return file1;
	}
	public static void setFile(String file) {
		file1 = file;
	}
}
