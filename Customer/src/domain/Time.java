package domain;

public class Time {

	// 필드
	private int t_usetime;
	private int t_remaintime;
	private int m_no;
	
	// 생성자
	public Time() {}

	public Time(int t_usetime, int t_remaintime, int m_no) {
		this.t_usetime = t_usetime;
		this.t_remaintime = t_remaintime;
		this.m_no = m_no;
	}

	// 메소드
	public int getT_usetime() {
		return t_usetime;
	}

	public void setT_usetime(int t_usetime) {
		this.t_usetime = t_usetime;
	}

	public int getT_remaintime() {
		return t_remaintime;
	}

	public void setT_remaintime(int t_remaintime) {
		this.t_remaintime = t_remaintime;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	
}
