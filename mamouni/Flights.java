//package mamouni;

import java.util.Random;

public class Flights {
	
	private String sign;
	private String city;
	private String genre;
	private String type;
	private int time;
	private String state;
	private String ref;
	private String clean;
	private String trans;
	private String load;
	private String seat;
	private int the_i;
	private int the_j;
	private double price;


	public Flights(String sign, String city, String genre, String type, int time,String state, String ref, String clean, String trans, String load,double price, int the_i, int the_j) {
		super();
		String s = null;
		this.sign = sign;
		this.city = city;
		this.genre = genre;
		this.type = type;
		int temp=0;
		if (type=="onemotor") {
			temp=6;
		}else if (type=="turboprop") {
			temp=4;
		}
		else if (type=="jet") {
			temp=2;
		}
		this.time = new Random().nextInt((time))-temp;
		if (this.time < 10) {
			this.time = 11;
		}
		

		this.state=state;
		this.ref=ref;
		this.clean=clean;
		this.trans=trans;
		this.load=load;
		this.price=price;
		this.the_i = the_i;
		this.the_j = the_j;
		if (the_i==0) {
			s="G";
		}else if (the_i==1) {
			s="C";
		}
		else if (the_i==2) {
			s="K";
		}else if (the_i==3) {
			s="L";
		}
		else if (the_i==4) {
			s="M";
		}else if (the_i==5) {
			s="N";
		}else if (the_i==6) {
			s="Z";
		}
		this.setSeat(s+(the_j+1));
	}
	
	public String getSign() {
		return sign;
	}


	public void setSign(String sign) {
		this.sign = sign;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getClean() {
		return clean;
	}

	public void setClean(String clean) {
		this.clean = clean;
	}

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public String getLoad() {
		return load;
	}

	public void setLoad(String load) {
		this.load = load;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public int getThe_i() {
		return the_i;
	}

	public void setThe_i(int the_i) {
		this.the_i = the_i;
	}

	public int getThe_j() {
		return the_j;
	}

	public void setThe_j(int the_j) {
		this.the_j = the_j;
	}


	
	
	
	
}
