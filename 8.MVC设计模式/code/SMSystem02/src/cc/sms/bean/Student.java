package cc.sms.bean;

import java.util.Date;

public class Student {
	private int sid;
	private String sname;
	private String gender;
	private String phone;
	private Date birthday;
	private String hobby;
	private String info;

	public Student() {
	}
	
	/**
	 * 用来装载需要插入的对象 sid=-1
	 * @param sname
	 * @param gender
	 * @param phone
	 * @param birthday
	 * @param hobby
	 * @param info
	 */
	public Student(String sname, String gender, String phone, Date birthday, String hobby, String info) {
		super();
		this.sid = -1;
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}

	/**
	 * 用来装载需要更新的对象，需要传入sid
	 * @param sname
	 * @param gender
	 * @param phone
	 * @param birthday
	 * @param hobby
	 * @param info
	 */
	public Student(int sid, String sname, String gender, String phone, Date birthday, String hobby, String info) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", phone=" + phone + ", birthday="
				+ birthday + ", hobby=" + hobby + ", info=" + info + "]";
	}
}
