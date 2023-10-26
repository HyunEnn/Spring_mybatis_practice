package com.ssafy.spring.dto;

public class MemberDto {
	private String id;
	private String pw;
	
	public MemberDto(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public MemberDto() {
		super();
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pw=" + pw + "]";
	}
	
}
