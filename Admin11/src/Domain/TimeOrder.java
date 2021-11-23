package Domain;

public class TimeOrder {

	private int to_price;
	private int m_no;
	private String to_date;

	public TimeOrder() {

	}

	public TimeOrder(int to_price, int m_no, String to_date) {
		this.to_price = to_price;
		this.m_no = m_no;
		this.to_date = to_date;
	}
	

	public TimeOrder(int to_price) {
		super();
		this.to_price = to_price;
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

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	

}
