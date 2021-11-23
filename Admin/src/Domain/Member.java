package Domain;

public class Member {
	
	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email;
	private String m_phone;
	private int m_sex;
	private String sex;
	
	public Member() {}

	public Member(int m_no, String m_id, String m_pw, String m_name,String m_email , String m_phone, int m_sex ) {
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_phone = m_phone;
		this.m_sex = m_sex;
		
		if(m_sex==1) {
			sex = "남자";
		}
		else if(m_sex==2) {
			sex = "여자";
		}
	}

	public Member( String m_name, int m_sex,  String m_phone,String m_email,String m_pw, int m_no) {
		this.m_pw = m_pw;
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_phone = m_phone;
		this.m_sex = m_sex;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public int getM_sex() {
		return m_sex;
	}

	public void setM_sex(int m_sex) {
		this.m_sex = m_sex;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

	
	
	
	
	

}
