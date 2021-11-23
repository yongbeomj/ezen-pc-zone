package domain;

public class Pc {

	// 필드
	private int p_no;
	private String p_ip;
	private int p_port;
	private int p_activation;
	private int m_no;

	// 생성자
	public Pc() {}
	public Pc(String p_ip, int p_port, int p_activation, int m_no) {
		this.p_ip = p_ip;
		this.p_port = p_port;
		this.p_activation = p_activation;
		this.m_no = m_no;
	}

	public Pc(int p_no, int p_activation, int m_no) {
		super();
		this.p_no = p_no;
		this.p_activation = p_activation;
		this.m_no = m_no;
	}
	public Pc(int p_no, int m_no) {
		this.p_no = p_no;
		this.m_no = m_no;
	}

	public String getP_ip() {
		return p_ip;
	}

	public void setP_ip(String p_ip) {
		this.p_ip = p_ip;
	}

	public int getP_port() {
		return p_port;
	}

	public void setP_port(int p_port) {
		this.p_port = p_port;
	}

	public int getP_activation() {
		return p_activation;
	}

	public void setP_activation(int p_activation) {
		this.p_activation = p_activation;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

}
