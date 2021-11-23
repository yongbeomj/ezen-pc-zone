package domain;

public class Timeorder {

	private int  to_price;
	private int  m_no ;
	
	public Timeorder() {
		// TODO Auto-generated constructor stub
	}

	public Timeorder(int to_price, int m_no) {
		super();
		this.to_price = to_price;
		this.m_no = m_no;
	}

	public int getTo_price() {
		return to_price;
	}

	public void setTo_price(int to_price) {
		this.to_price = to_price;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	
}
