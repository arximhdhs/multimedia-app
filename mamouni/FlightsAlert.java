//package mamouni;

import javafx.util.Duration;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FlightsAlert {

	public static void display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Fligts");
		window.setMinWidth(650);
		window.setMinHeight(200);
		VBox layout = new VBox(10);
		ArrayList<Flights> temp = Pame.getAlf();
		Flights f;
		if (temp.size()==0) {
			Label lb = new Label("There are no flights right now");
			layout.getChildren().add(lb);
		}
		else {
			
			for (int i = 0; i<temp.size(); i++) {
				f = temp.get(i);
				Label lb = new Label("Flight: "+f.getSign()+", City: " + f.getCity()+", Genre: " +f.getGenre()+", Type of aircraft: "+ f.getType()+ ", Seat: "+f.getSeat()+", Time to leave: " +f.getTime());
				layout.getChildren().add(lb);
			}
		}
	
		
		
		
		layout.setAlignment(Pos.CENTER);

		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
}
