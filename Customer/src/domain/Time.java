package domain;

public class Time {

	// �ʵ�
	private int t_usetime;
	private int t_remaintime;
	private int m_no;
	
	// ������
	public Time() {}

	public Time(int t_usetime, int t_remaintime, int m_no) {
		this.t_usetime = t_usetime;
		this.t_remaintime = t_remaintime;
		this.m_no = m_no;
	}

	// �޼ҵ�
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
