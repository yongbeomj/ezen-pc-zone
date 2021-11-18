package domain;

public class Timeorder {
	
	private int to_no;
	private int to_price;
	private int to_date;
	private int m_no;
	
	public Timeorder() {
		// TODO Auto-generated constructor stub
	}

	

	public Timeorder(int to_no, int to_price, int to_date, int m_no) {
		super();
		this.to_no = to_no;
		this.to_price = to_price;
		this.to_date = to_date;
		this.m_no = m_no;
	}



	public int getTo_no() {
		return to_no;
	}

	public void setTo_no(int to_no) {
		this.to_no = to_no;
	}

	public int getTo_price() {
		return to_price;
	}

	public void setTo_price(int to_price) {
		this.to_price = to_price;
	}

	public int getTo_date() {
		return to_date;
	}

	public void setTo_date(int to_date) {
		this.to_date = to_date;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	
	
	
}
