package Domain;

public class OrderDetail {
	private int od_no;
	private String p_name;
	private String od_category;
	private int od_count;
	private int od_price;
	
	public OrderDetail() {}

	public OrderDetail(int od_no, String p_name,String od_category, int od_count , int od_price) {
		this.od_no = od_no;
		this.p_name = p_name;
		this.od_count = od_count;
		this.od_category = od_category;
		this.od_price = od_price;
	}

	public int getOd_no() {
		return od_no;
	}

	public void setOd_no(int od_no) {
		this.od_no = od_no;
	}


	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getOd_count() {
		return od_count;
	}

	public void setOd_count(int od_count) {
		this.od_count = od_count;
	}

	public String getOd_category() {
		return od_category;
	}

	public void setOd_category(String od_category) {
		this.od_category = od_category;
	}

	public int getOd_price() {
		return od_price;
	}

	public void setOd_price(int od_price) {
		this.od_price = od_price;
	}
	
	
	

}
