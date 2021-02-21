//package mamouni;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Sc extends StackPane{
	
	private Rectangle r;
	
	public Sc(String s) {
		this.r = new Rectangle();
		this.r.setWidth(30);
		this.r.setHeight(30);
		this.r.setFill(Color.YELLOW);
		this.r.setStroke(Color.GREEN);
		this.r.setStrokeWidth(4);
		Text t1 = new Text();
		t1.setText(s);
		this.getChildren().addAll(r, t1);	
	}
	public void setB(String color) {
		if (color=="red")
		this.r.setStroke(Color.RED);
		else 
			this.r.setStroke(Color.GREEN);
	}

}
