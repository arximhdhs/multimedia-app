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

public class GatesAlert {

	public static void display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Gates");
		window.setMinWidth(650);
		window.setMinHeight(200);
		VBox layout = new VBox(10);
		String[][] seats = Read.getS();
		String s = null;
		String av="yes";
		String fn = "-";
		for (int i = 0; i<7; i++) {
			for (int j = 0; j<seats[i].length; j++) {
				if (seats[i][j]!="0") {
					av="no";
				}
				if (seats[i][j]!="0") {
					fn=seats[i][j];
				}
				if (i==0) {
					s="G" +(j+1) ;
				}else if (i==1) {
					s="C" +(j+1) ;
				}
				else if (i==2) {
					s="K" +(j+1) ;
				}else if (i==3) {
					s="L" +(j+1) ;
				}
				else if (i==4) {
					s="M" +(j+1) ;
				}else if (i==5) {
					s="N" +(j+1) ;
				}else if (i==6) {
					s="Z" +(j+1) ;
				}
				
				
				
				Label lb = new Label("Gate: "+s+", Available: "+av +", Flight number: "+fn);
				layout.getChildren().add(lb);
				av="yes";
				fn="-";
			}
		}

	
		
		
		
		layout.setAlignment(Pos.CENTER);

		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
}
