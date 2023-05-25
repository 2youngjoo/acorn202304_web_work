package test.guest.dto;

public class GuestDto {
	private int num;
	private String writer;
	private String content;
	private String pwd;
	private String date;
	
	// 생성자
	public GuestDto() {
		
	}

	public GuestDto(int num, String date, String writer, String content, String pwd) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.pwd = pwd;
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GuestDto [num=" + num + ", writer=" + writer + ", content=" + content + ", pwd= " + pwd + "]";
	}
	
}
