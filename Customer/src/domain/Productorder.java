package domain;

public class Productorder {

	private int po_no;
	private String po_date;
	private String po_contents;
	private int po_count;
	private int pc_no;
	private String m_id;
	private int po_price;
	private int po_activation;
	
	public Productorder() {
		// TODO Auto-generated constructor stub
	}

	public Productorder(String po_contents, int po_count, int pc_no, String m_id, int po_price, int po_activation) {
		this.po_contents = po_contents;
		this.po_count = po_count;
		this.pc_no = pc_no;
		this.m_id = m_id;
		this.po_price = po_price;
		this.po_activation = po_activation;
	}

	public int getPo_no() {
		return po_no;
	}

	public void setPo_no(int po_no) {
		this.po_no = po_no;
	}

	public String getPo_date() {
		return po_date;
	}

	public void setPo_date(String po_date) {
		this.po_date = po_date;
	}

	public String getPo_contents() {
		return po_contents;
	}

	public void setPo_contents(String po_contents) {
		this.po_contents = po_contents;
	}

	public int getPo_count() {
		return po_count;
	}

	public void setPo_count(int po_count) {
		this.po_count = po_count;
	}

	public int getPc_no() {
		return pc_no;
	}

	public void setPc_no(int pc_no) {
		this.pc_no = pc_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getPo_price() {
		return po_price;
	}

	public void setPo_price(int po_price) {
		this.po_price = po_price;
	}

	public int getPo_activation() {
		return po_activation;
	}

	public void setPo_activation(int po_activation) {
		this.po_activation = po_activation;
	}

	

	
	
	
	
}
