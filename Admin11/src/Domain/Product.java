package Domain;

public class Product {
	
	private int p_no;
	private String p_name;
	private String p_img;
	private int p_count;
	private String p_category;
	private int p_price;
	private int p_activation;
	private String p_date;
	
	// 상태변경
	private String activation;


	public Product(int p_no, String p_name, String p_img, int p_count, String p_category, int p_price,
			int p_activation, String p_date) {
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_img = p_img;
		this.p_count = p_count;
		this.p_category = p_category;
		this.p_price = p_price;
		this.p_activation = p_activation;
		this.p_date = p_date;
		if(p_activation== 1) { activation="판매중";}
		else if(p_activation==2) {activation= "품절";}
	}
	
	public Product(String p_name, String p_img, int p_count, String p_category, int p_price, int p_activation) {
		this.p_name = p_name;
		this.p_img = p_img;
		this.p_count = p_count;
		this.p_category = p_category;
		this.p_price = p_price;
		this.p_activation = p_activation;
	}
	


	public void setP_count(int p_count) {
		this.p_count = p_count;
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

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public int getP_count() {
		return p_count;
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

	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}



	
	
	

}
