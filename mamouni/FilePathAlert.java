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

public class FilePathAlert {

	private static String file1 ;
	public static void display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("File Path");
		window.setMinWidth(250);
		window.setMinHeight(200);
		
		Label label = new Label();
		label.setText("Enter the full path to the airport_default.txt file please, E.g./home/rodia/eclipse-workspace/l/example/");
		label.setWrapText(true);
		TextField text = new TextField();
		Button submit = new Button("Submit");
		
		submit.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			

			@Override
            public void handle(ActionEvent event) {
				String path = text.getText();
				System.out.println(path);
				Read.setPath(path);
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
