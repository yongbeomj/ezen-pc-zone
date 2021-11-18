package domain;

public class Orderdetail {

	private int od_no;
	private int po_no;
	private int p_no;
	private String p_name;
	private String od_category;
	private int od_count;
	private int od_price;
	
	public Orderdetail() {
		// TODO Auto-generated constructor stub
	}

	public Orderdetail(int po_no, int p_no, String p_name, String od_category, int od_count, int od_price) {
		this.po_no = po_no;
		this.p_no = p_no;
		this.p_name = p_name;
		this.od_category = od_category;
		this.od_count = od_count;
		this.od_price = od_price;
	}

	public int getOd_no() {
		return od_no;
	}

	public void setOd_no(int od_no) {
		this.od_no = od_no;
	}

	public int getPo_no() {
		return po_no;
	}

	public void setPo_no(int po_no) {
		this.po_no = po_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getOd_category() {
		return od_category;
	}

	public void setOd_category(String od_category) {
		this.od_category = od_category;
	}

	public int getOd_count() {
		return od_count;
	}

	public void setOd_count(int od_count) {
		this.od_count = od_count;
	}

	public int getOd_price() {
		return od_price;
	}

	public void setOd_price(int od_price) {
		this.od_price = od_price;
	}
	
	
	
}
