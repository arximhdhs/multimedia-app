package mamouni;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays; 

public class Read 
{ 
	
static private ArrayList<String> parked = new ArrayList<String>();
static private ArrayList<Flights> holding= new ArrayList<Flights>();
static private ArrayList<String> landing= new ArrayList<String>();
static private String[][] tokens;
static private String[][] seats;
static private String path;
	
	

public static String getPath() {
	return path;
}
public static void setPath(String path) {
	Read.path = path;
}
static public String[][] getT(){
//	int i=0;
//	int j=0;
//	for (i=0; i<7; i++) {
//		for (j=0; j<4; j++) {
//			System.out.println(tokens[i][j]);
//		}
//	}
	return tokens;

}
static public String[][] getS(){
//	int i=0;
//	int j=0;
//	for (i=0; i<7; i++) {
//		for (j=0; j<4; j++) {
//			System.out.println(tokens[i][j]);
//		}
//	}
	return seats;

}


public static void setT(String[][] token){
//	int i=0;
//	int j=0;
//	for (i=0; i<7; i++) {
//		for (j=0; j<4; j++) {
//			System.out.println(tokens[i][j]);
//		}
//	}
	tokens=token;

}
public Read() {
	tokens = new String[7][4];
	int i=0;
	int j=0;
	for (i=0; i<7; i++) {
		for (j=0; j<4; j++) {
			tokens[i][j]="-";
		}
	}

}

 static public void read_air(String file_name)throws Exception 
  { 
		
		
		
  File file = new File(path +  "airport_" +file_name+ ".txt"); 
//	 File file = new File("../airport_" +file_name+ ".txt"); 
  
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  String[] temp = new String[4]; 
  seats = new String[7][];
  String st;
  int i=0;
  while ((st = br.readLine()) != null) { 
  	temp = st.split(",");
  	int index = Integer.parseInt(temp[0]);
  	tokens[index-1]=temp;
  	seats[index-1]= new String[ Integer.parseInt(temp[1])];
  	for (int j = 0; j< Integer.parseInt(temp[1]); j++) {
  		seats[index-1][j]="0";
  	}
  	i++;
  	
  	}

  }
public static void setS(String[][] seats1) {
	seats = seats;
	// TODO Auto-generated method stub
	
}
public static ArrayList<String> getParked() {
	return parked;
}
public static void setParked(ArrayList<String> parked) {
	Read.parked = parked;
}
public static ArrayList<Flights> getHolding() {
	return holding;
}
public static void setHolding(ArrayList<Flights> holding) {
	Read.holding = holding;
}
public static ArrayList<String> getLanding() {
	return landing;
}
public static void setLanding(ArrayList<String> landing) {
	Read.landing = landing;
} 
} 
