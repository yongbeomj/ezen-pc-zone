package domain;

public class Time {

	// 필드
	private int t_usetime;
	private int t_remaintiome;
	private int m_no;
	
	// 생성자
	public Time() {}

	public Time(int t_usetime, int t_remaintiome, int m_no) {
		this.t_usetime = t_usetime;
		this.t_remaintiome = t_remaintiome;
		this.m_no = m_no;
	}

	// 메소드
	public int getT_usetime() {
		return t_usetime;
	}

	public void setT_usetime(int t_usetime) {
		this.t_usetime = t_usetime;
	}

	public int getT_remaintiome() {
		return t_remaintiome;
	}

	public void setT_remaintiome(int t_remaintiome) {
		this.t_remaintiome = t_remaintiome;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	
	
}
