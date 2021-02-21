//package mamouni;


import javafx.util.Duration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;
public class Pame extends Application{
	
	private static ArrayList<Flights> alf = new ArrayList<Flights>();
	private int start_times=0;
	private int flights_that_are_leaving=0;
	private double total_price=0;
	private int total_seats=0;
	ArrayList<Timeline> altl = new ArrayList<Timeline>();
	private Label label1 = new Label();
	private Label label2 = new Label();
	private Label label3 = new Label();
	private Label label4 = new Label();
	private Label label6 = new Label();
	private Label label10 = new Label();
	private Label label11 = new Label();
	private VBox aithsh = new VBox();

	private ArrayList<Sc> alsc = new ArrayList<Sc>();

	
	int sec=0;
	int min=0;
	int i=0;
	int j=0;
	Button button;
	Label label5 = new Label("Total time:");
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("MediaLab Airport");
		stage.setWidth(1200);
		stage.setHeight(950);
		
		GridPane root = new GridPane();
		
		root.getStyleClass().add("grid");
		
		
		
  
		
		GridPane air = new GridPane();
		//columns
		for (i=0; i<100; i++) {
			ColumnConstraints column1 = new ColumnConstraints();
		    column1.setPercentWidth(1);
		    air.getColumnConstraints().add(column1);
		}
		for (i=0; i<10; i++) {
			RowConstraints row1 = new RowConstraints();
		    row1.setPercentHeight(10);
		    air.getRowConstraints().add(row1);
		}
		
		GridPane.setConstraints(air, 0, 1);
		GridPane.setColumnIndex(air, 0);
		
		for (i=0; i<5; i++) {
			ColumnConstraints column1 = new ColumnConstraints();
		    column1.setPercentWidth(20);
		    root.getColumnConstraints().add(column1);
		}
		
	    //rows
		RowConstraints row1 = new RowConstraints();
	    row1.setPercentHeight(20);
	    RowConstraints row2 = new RowConstraints();
	    row2.setPercentHeight(50);
	    RowConstraints row3 = new RowConstraints();
	    row3.setPercentHeight(10);
	    RowConstraints row4 = new RowConstraints();
	    row4.setPercentHeight(20);
	    
	    root.getRowConstraints().addAll(row1, row2,row3,row4); // each get 50% of width
	    //labels
		label1 = new Label("Landing-flights: 0");
		label1.setId("lb1");
		label2 = new Label("Αvailable seats: 0");
		label3 = new Label("Flighs that departures: 0");
		label4 = new Label("Total amount of money: 0");
		label6 = new Label("Airport Graph");
		label5 = new Label("Total time min: 0 sec: 0");
		
		VBox messages = new VBox(5);
		GridPane.setConstraints(messages, 2, 2);
		
		label10 = new Label("Important Messages: ");
		label11 = new Label("No message");
		label10.setId("lb10");
		label11.setId("lb11");
		label11.setTextFill(Color.RED);
		
		label11.setWrapText(true);
		
		GridPane.setConstraints(label1, 0, 0);
		GridPane.setConstraints(label2, 1, 0);
		GridPane.setConstraints(label3, 2, 0);
		GridPane.setConstraints(label4, 3, 0);
		GridPane.setConstraints(label5, 4, 0);
		
		
		
		messages.getChildren().addAll(label10,label11);
		
		
		
		

		
		
		

		
		//menu1
		Menu menu1 = new Menu("Apllication");
		MenuItem m1 = new MenuItem("Start"); 
		m1.setOnAction(e->{
			if (start_times>0) {
				
				air.getChildren().remove(aithsh);
				root.getChildren().remove(air);
				for (i=0; i< alsc.size(); i++) {
				air.getChildren().remove(alsc.get(i));
				}
				
			}
			
			try {
			
				print_airport(air,root,label5,"default");
				if (start_times>0) {
					everything_zero();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			start_times++;
		});
        MenuItem m2 = new MenuItem("Load"); 
		m2.setOnAction(e->{
			NewFile.display();
			String path = "/home/rodia/eclipse-workspace/l/example/airport_" + NewFile.getFile() + ".txt";
			File f = new File(path);
			if(f.exists() && !f.isDirectory()) { 
			    // do something
				try {
					
					air.getChildren().remove(aithsh);
					root.getChildren().remove(air);
					for (i=0; i< alsc.size(); i++) {
					air.getChildren().remove(alsc.get(i));}
					everything_zero();
//					Read.read_air(NewFile.getFile());
					print_airport(air,root,label5,NewFile.getFile());

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else {
				AlertBox.display("New File", "there is not a fle");
			}
		});
        MenuItem m3 = new MenuItem("Exit");
		m3.setOnAction(e->{
			Platform.exit();
		});
        menu1.getItems().addAll(m1,m2,m3);
        

        //Platform.exit()
        //print_airport(air,root);
        //menu2
		Menu menu2 = new Menu("Details");
		MenuItem m21 = new MenuItem("Gates"); 
	   	m21.setOnAction(e->{
				GatesAlert.display();
			});
			
        MenuItem m22 = new MenuItem("Flights"); 
    	m22.setOnAction(e->{
			FlightsAlert.display();
		});
        MenuItem m23 = new MenuItem("Delayed");
        MenuItem m24 = new MenuItem("Holding");
      	m24.setOnAction(e->{
    			HoldingAlert.display();
    		});
        MenuItem m25 = new MenuItem("Next Departures");
        menu2.getItems().addAll(m21,m22,m23,m24,m25);
        
        
		MenuBar menuBar1 = new MenuBar();

		menuBar1.getMenus().addAll(menu1,menu2);

		VBox vBox = new VBox(menuBar1);
		GridPane.setColumnSpan(vBox, 20);
		label1.setTextFill(Color.web("#0076a3"));
		label1.setWrapText(true);
		label2.setWrapText(true);
		label3.setWrapText(true);
		label4.setWrapText(true);
		label5.setWrapText(true);
		
		
		//draw
		Rectangle r = new Rectangle();
		r.setWidth(800);
		r.setHeight(400);
		r.setFill(Color.TRANSPARENT);
		r.setStroke(Color.BLACK);
		
		VBox airport_graph = new VBox();
		GridPane.setConstraints(airport_graph, 0, 1);
		airport_graph.getChildren().addAll(label6,r);
				
		root.getChildren().addAll(label1,label2,label3,label4,label5,vBox,airport_graph,messages);
		FilePathAlert.display();
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("stylesheet.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	
	
	private void everything_zero() {
		for (i=0; i<altl.size(); i++) {
			altl.get(i).stop();
			altl.remove(i);
		}
		ArrayList<String> empty = Read.getParked();
		empty.clear();
		
		Read.setParked(empty);
//		Read.setHolding(empty);
		Read.setLanding(empty);
		// TODO Auto-generated method stub
		start_times=0;
		flights_that_are_leaving=0;
		total_price=0;
		total_seats=0;
		flights_that_are_leaving=0;
		set_the_flights_that_are_leaving();
		graph_borders();
		set_the_total_price(total_price);
		set_the_parked_and_the_landing();
		update_left_seats(Read.getS());
		
		
	
	}



	public void print_airport(GridPane air,GridPane root,Label label5,String ffile) throws Exception {
		int i=0;
		int j=0;
		int temp_seat=0;
		sec=0;
		min=0;
		

		Read read = new Read();
		String[][] data = new String[7][4];
		read.read_air(ffile);
		data = read.getT();
		 //update left seats
		  update_left_seats(Read.getS());
		air.setVgap(20);
		
		for (i=0; i<7; i++) {
			if (data[i][1]!="-") {
				for (j=0; j<Integer.parseInt(data[i][1]); j++) {
					if (i==0) {
						Sc gate = new Sc("G"+(j+1));
						alsc.add(gate);
						GridPane.setConstraints(gate, j*2, 1);
						air.getChildren().add(gate);
						
					}
					else if (i==1) {
						Sc gate = new Sc("C"+(j+1));
						alsc.add(gate);
						GridPane.setConstraints(gate, j*2, 2);
						air.getChildren().add(gate);
						
					}
					else if (i==2) {
						Sc gate = new Sc("K"+(j+1));
						alsc.add(gate);
						GridPane.setConstraints(gate, j*2, 3);
						air.getChildren().add(gate);
						
					}
					else if (i==3) {
						Sc gate = new Sc("L"+(j+1));
						alsc.add(gate);
						GridPane.setConstraints(gate, j*2, 4);
						air.getChildren().add(gate);
						
					}
					else if (i==4) {
						Sc gate = new Sc("M"+(j+1));
						alsc.add(gate);
						GridPane.setConstraints(gate, j*2, 5);
						air.getChildren().add(gate);
						
					}
					else if (i==5) {
						Sc gate = new Sc("N"+(j+1));
						alsc.add(gate);
						GridPane.setConstraints(gate, j*2, 6);
						air.getChildren().add(gate);
						
					}
					else if (i==6) {
						Sc gate = new Sc("Z"+(j+1));
						alsc.add(gate);
						GridPane.setConstraints(gate, j*2, 7);
						air.getChildren().add(gate);
						
					}
				}
			}
		
		}

	      //aithsh
			aithsh = new VBox(8);
			GridPane.setConstraints(aithsh, 4, 1);
			Label anag = new Label("Sign");
			Label city = new Label("City");
			Label genre = new Label("Genre");
			Label type = new Label("Type");
			Label time = new Label("Time");
			Label ref = new Label("Refeal");
			Label clean = new Label("Clean");
			Label trans = new Label("Trans");
			Label load = new Label("Load");
			TextField anagt = new TextField();
			TextField cityt = new TextField();
			ChoiceBox<String> genret = new ChoiceBox<>();
			ChoiceBox<String> typet = new ChoiceBox<>();
			TextField timet = new TextField();
			ChoiceBox<String> reft = new ChoiceBox<>();
			ChoiceBox<String> cleant = new ChoiceBox<>();
			ChoiceBox<String> transt = new ChoiceBox<>();
			ChoiceBox<String> loadt = new ChoiceBox<>();
			Button submit = new Button("Submit");
			
			genret.getItems().addAll("transport","commercial","private");
			typet.getItems().addAll("onemotor","turboprop","jet");
			cleant.getItems().addAll("yes","no");
			reft.getItems().addAll("yes","no");
			transt.getItems().addAll("yes","no");
			loadt.getItems().addAll("yes","no");
			
			submit.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	flight_app(anagt,cityt,genret,typet,timet,reft,cleant,transt,loadt);
		                
		            }
		        });
			aithsh.getChildren().addAll(anag,anagt,city,cityt,genre,genret,type,typet,time,timet,ref,reft,clean,cleant,trans,transt,load,loadt,submit);
	        //aithsh
		
		root.getChildren().addAll(air,aithsh);	
		final Timeline timeline = new Timeline(
			    new KeyFrame(
			        Duration.millis(1000/12),
			        event -> {
			            if (sec==59) {
		                	sec=0; 
		                		min++;
		                }else {
		                	sec++;
		                }

		                set_the_watch();  
			        }
			    )
			);
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
	
	}
	
	public void set_the_watch() {
        label5.setText("Total time min: "+min+" sec: "+sec);

	}
	
	public void flight_app(TextField anagt,TextField cityt,ChoiceBox<String> genret,ChoiceBox<String> typet,TextField timet, ChoiceBox<String> reft, ChoiceBox<String> cleant, ChoiceBox<String> transt, ChoiceBox<String> loadt) 
	{
			
		
	double price=0;
	int time;	
	int temp_seat=0;
	boolean exw = false;
	boolean[] which = new boolean[7];
	for (i=0; i<7; i++) {
		which[i]=true;
	}

	String temp;
	String anag = anagt.getText();
	String city = cityt.getText();
	String genre = genret.getValue();
	String type = typet.getValue();
	temp = timet.getText();
	if (!temp.trim().isEmpty()) {
		time = Integer.parseInt(temp);
	}	
	else {
		time =0;
	}
	
	
	//message
	
	messages("Flight "+anag +" asks for permission to land!!!");
	
	//Integer.parseInt(temp[1]);
	String ref = reft.getValue();
	String clean = cleant.getValue();
	String trans = transt.getValue();
	String load = loadt.getValue();


	
	//genre
	if (genre!="transport") {
		which[0]=false;
		which[2]=false;
	}
	if (genre!="commercial") {
		which[1]=false;
	}
	if (genre=="transport") {
		which[6]=false;
	}
	
	//type
	if (type=="onemotor") {
		which[0]=false;
		which[1]=false;
		which[2]=false;
		which[3]=false;
	}
	if (type!="onemotor") {
		which[4]=false;
	}
	
	//serveses
	if (trans=="yes" || load=="yes") {
		which[5]=false;
	}
	//time
	if (time>45) {
		which[0]=false;
	}
	if (time>90) {
		which[1]=false;
		which[2]=false;
	}
	if (time>120) {
		which[3]=false;
	}
	if (time>180) {
			which[4]=false;

	}
	if (time>240) {
		which[5]=false;

	}
	if (time>600) {
		which[6]=false;

	}

	 String[][] seats = Read.getS();

	  int the_i=0;
	  int the_j=0;
	  
	  
	
	  
	  
outerloop:for (i=0; i<7; i++) {
		if (which[i]) {
			for (j=0; j<seats[i].length; j++) {
				if (seats[i][j]=="0") {
					seats[i][j]=anag;
					Read.setS(seats);
					exw = true;
					the_i=i;
					the_j=j;
					price = Integer.parseInt(Read.getT()[i][2]);
					Flights flight = new Flights(anag,city, genre, type, time,"Landing",ref,clean,trans,load,price,i,j);
					set_the_flight(flight);
					messages("Flight "+anag +" is landing");
					break outerloop;
				}
			}
		}
	}
	  
	
	  //update left seats
	  update_left_seats(seats);

	
	if (exw) {
		AlertBox.display("Information","Yes there is available space");
	}else {
		
		ArrayList<Flights> temptation = Read.getHolding();
		Flights flight = new Flights(anag,city, genre, type, time,"Holding",ref,clean,trans,load,price,the_i,the_j);
		temptation.add(flight);
		Read.setHolding(temptation);
		AlertBox.display("Information","NO there is not available space you will have to wait");
	}
	
	//Integer.parseInt(temp[1]);
	
		
	}
	
	
	public void update_left_seats(String[][] seats) {
		int i,j,temp_seat=0;
		  for (i=0; i<7; i++) {
				for (j=0; j<seats[i].length; j++) {
					if (seats[i][j]=="0") {
						temp_seat++;
					}
				}
			}
	  label2.setText("Αvailable seats: "+temp_seat);
	}
	
	
	public void set_the_flight(Flights flight) {
		
		//String trans, String load
		//make the seat red
		double price = 0;
		String anag = flight.getSign();
		String city = flight.getCity();
		String genre = flight.getGenre();
		String type = flight.getType();
		int time = flight.getTime();
		int the_i = flight.getThe_i();
		int the_j = flight.getThe_j();
		String ref = flight.getRef();
		String clean = flight.getClean();
		String trans = flight.getTrans();
		String load = flight.getLoad();
		
		
		
		graph_borders();
		
		
		//calculating and setting the price
		price = Integer.parseInt(Read.getT()[the_i][2]);
		if (ref=="yes") {
			price=price+ price*0.25;
		}
		if (clean=="yes") {
			price=price+ price*0.02;
		}
		if (trans=="yes") {
			price=price+ price*0.02;
		}
		if (load=="yes") {
			price=price+ price*0.05;
		}
		set_the_total_price(price);
		
		
		
		alf.add(flight);
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(anag);
		
		temp=Read.getLanding();
		temp.add(anag);
		Read.setLanding(temp);
		int index;
		
		//timeline
		
		
		KeyFrame task_parked = new KeyFrame(Duration.seconds(60*flight.getTime()/12),
		        event -> {
					ArrayList<String> temp1 = Read.getParked();
					int index1 = temp1.indexOf(anag);
					temp1.remove(index1);
					String[][] temp22 = Read.getS();
					temp22[the_i][the_j]="0";
					Read.setS(temp22);
					index1 = alf.indexOf(flight);
					alf.remove(index1);
					flights_that_are_leaving--;
					messages("Flight "+anag +" left the airport");
					update_left_seats(temp22);
					set_the_flights_that_are_leaving();
					graph_borders();
					set_the_parked_and_the_landing();
					check_if_flight();
					
		       });
		
		int dep_time;
		if (flight.getTime()-10>0) {
			dep_time=flight.getTime()-10;
		}else {
			dep_time = 10;
		}
		KeyFrame task_dep = new KeyFrame(Duration.seconds(60*dep_time/12),
		        event -> {
		        	flights_that_are_leaving++;
					set_the_flights_that_are_leaving();
					
		       });
		
		
		KeyFrame task1 = new KeyFrame(Duration.seconds(60*6/12),
			        event -> {
						ArrayList<String> temp1 = Read.getLanding();
						int index1 = temp1.indexOf(anag);
						temp1.remove(index1);
						temp1 =Read.getParked();
						temp1.add(anag);
						messages("Flight "+anag +" parked succesfully");
						Read.setParked(temp1);
						set_the_parked_and_the_landing();
						
						final Timeline timeline = new Timeline(task_parked);
						altl.add(timeline);
						timeline.play();
						
						final Timeline timeline1 = new Timeline(task_dep);
						altl.add(timeline);
						timeline1.play();
						
						

			       });
		
		KeyFrame task2 = new KeyFrame(Duration.seconds(60*4/12),
		        event -> {
					ArrayList<String> temp1 = Read.getLanding();
					int index1 = temp1.indexOf(anag);
					temp1.remove(index1);
					temp1 =Read.getParked();
					temp1.add(anag);
					messages("Flight "+anag +" parked succesfully");
					Read.setParked(temp1);
					set_the_parked_and_the_landing();
					
					final Timeline timeline = new Timeline(task_parked);
					altl.add(timeline);
					timeline.play();
					
					final Timeline timeline1 = new Timeline(task_dep);
					altl.add(timeline);
					timeline1.play();
					
		        });
		
		KeyFrame task3 = new KeyFrame(Duration.seconds(60*2/12),
		        event -> {
					ArrayList<String> temp1 = Read.getLanding();
					int index1 = temp1.indexOf(anag);
					temp1.remove(index1);
					temp1 =Read.getParked();
					temp1.add(anag);
					messages("Flight "+anag +" parked succesfully");
					Read.setParked(temp1);
					
					
					set_the_parked_and_the_landing();
					final Timeline timeline = new Timeline(task_parked);
					altl.add(timeline);
					timeline.play();
					
					final Timeline timeline1 = new Timeline(task_dep);
					altl.add(timeline);
					timeline1.play();
					
					
					
		        });

		//timeline
		set_the_parked_and_the_landing();
		if (type=="onemotor") {
			
			
			final Timeline timeline = new Timeline(task1);
			altl.add(timeline);
			timeline.play();
			
		}else if (type=="turboprop") {
			final Timeline	timeline = new Timeline(task2);
			altl.add(timeline);
			timeline.play();
			
		}else {
			final Timeline	timeline = new Timeline(task3);
			altl.add(timeline);
			timeline.play();
		}
		
	}



	private void set_the_flights_that_are_leaving() {
		label3.setText("Flighs that departures: "+flights_that_are_leaving);
		// TODO Auto-generated method stub
		
	}



	private void set_the_total_price(double price) {
		
		String euro = "\u20ac";
		total_price = total_price+ price;
		
		total_price= Math.round(total_price);
		
		label4.setText("Total amount of money: "+total_price+euro);
		
		
		// TODO Auto-generated method stub
		
	}





	public void set_the_parked_and_the_landing() {
		// TODO Auto-generated method stub
		ArrayList<String> temp_ar=Read.getLanding();
		int temp_int = temp_ar.size();
		label1.setText("Landing-flights: " + temp_int);
		
		
//		temp_ar=Read.getParked();
//		temp_int = temp_ar.size();
//		label4.setText("Parked: " + temp_int);

		
		
	}

	public void graph_borders() {
		int temp1=0;
		int temp2=0;
		String[][] seats = Read.getS();
		for (i=0; i<7; i++) {
			for (j=0; j< seats[i].length; j++) {
				if (seats[i][j]=="0") {
					alsc.get(temp1+j).setB("green");
					
				}else {
					alsc.get(temp1+j).setB("red");
				}
				temp2++;
			}
			temp1=temp1+temp2;
			temp2=0;
		}

	}
	
	public static ArrayList<Flights> getAlf(){
		return alf;
	}
	
	
	
	public void check_if_flight() {
		ArrayList<Flights> temp_ar ;
		int temp_index;
		double price=0;
		boolean exw=false;
		String[][] seats;
		boolean[] which = new boolean[7];
		
		for (i= Read.getHolding().size()-1; i==0; i--) {
			Flights flight = Read.getHolding().get(i);
			
			for (i=0; i<7; i++) {
				which[i]=true;
			}
			
			String anag = flight.getSign();
			String city = flight.getCity();
			String genre = flight.getGenre();
			String type = flight.getType();
			int time = flight.getTime();
			int the_i = flight.getThe_i();
			int the_j = flight.getThe_j();
			String ref = flight.getRef();
			String clean = flight.getClean();
			String trans = flight.getTrans();
			String load = flight.getLoad();
			
			
			
			
			if (genre!="transport") {
				which[0]=false;
				which[2]=false;
			}
			if (genre!="commercial") {
				which[1]=false;
			}
			if (genre=="transport") {
				which[6]=false;
			}
			
			//type
			if (type=="onemotor") {
				which[0]=false;
				which[1]=false;
				which[2]=false;
				which[3]=false;
			}
			if (type!="onemotor") {
				which[4]=false;
			}
			
			//serveses
			if (trans=="yes" || load=="yes") {
				which[5]=false;
			}
			//time
			if (time>45) {
				which[0]=false;
			}
			if (time>90) {
				which[1]=false;
				which[2]=false;
			}
			if (time>120) {
				which[3]=false;
			}
			if (time>180) {
					which[4]=false;

			}
			if (time>240) {
				which[5]=false;

			}
			if (time>600) {
				which[6]=false;

			}
			
			seats = Read.getS();
			
			outerloop:for (i=0; i<7; i++) {
				if (which[i]) {
					for (j=0; j<seats[i].length; j++) {
						if (seats[i][j]=="0") {
							seats[i][j]=anag;
							Read.setS(seats);
							exw = true;
							the_i=i;
							the_j=j;
							price = Integer.parseInt(Read.getT()[the_i][2]);
							if (ref=="yes") {
								price=price+ price*0.25;
							}
							if (clean=="yes") {
								price=price+ price*0.02;
							}
							if (trans=="yes") {
								price=price+ price*0.02;
							}
							if (load=="yes") {
								price=price+ price*0.05;
							}
							
							Flights flight1 = new Flights(anag,city, genre, type, time,"Landing",ref,clean,trans,load,price,the_i,the_j);
							temp_index = Read.getHolding().indexOf(flight);
							temp_ar = Read.getHolding();
							temp_ar.remove(temp_index);
							Read.setHolding(temp_ar);
							set_the_flight(flight1);
							break outerloop;
						}
					}
				}
			}	
		}
		
		
	}
	
	public void messages(String s) {
		label11.setText(s);
		
		
		KeyFrame no_message = new KeyFrame(Duration.seconds(60*2/12),
		        event -> {
		        	label11.setText("No message");
		       });
		final Timeline timeline = new Timeline(no_message);
		timeline.play();
		
		
	}


}
