package domain;

public class Product {

	// 필드
	private int p_no;
	private String p_name;
	private String p_img;
	private String p_contents;
	private String p_category;
	private int p_count;
	private int p_price;
	private int p_activation;
	private String p_date;
	private int m_no;

	private String activation;

	// 생성자
	public Product() {}
	
	public Product(int p_no, String p_name, String p_img, String p_contents, String p_category, int p_count,
			int p_price, int p_activation, String p_date, int m_no, String activation) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_img = p_img;
		this.p_contents = p_contents;
		this.p_category = p_category;
		this.p_count = p_count;
		this.p_price = p_price;
		this.p_activation = p_activation;
		this.p_date = p_date;
		this.m_no = m_no;
		this.activation = activation;
		
		if (p_activation == 0) {
			activation = "재고없음";
		} else if (p_activation > 0) {
			activation = "구매가능";
		}
	}

	// 메소드
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
	public String getP_img() {
		return p_img;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	public String getP_contents() {
		return p_contents;
	}
	public void setP_contents(String p_contents) {
		this.p_contents = p_contents;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_activation() {
		return p_activation;
	}
	public void setP_activation(int p_activation) {
		this.p_activation = p_activation;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	
	
	
	
	
}
