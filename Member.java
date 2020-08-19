package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private int member_id;

	@Column(name = "member_type")
	private String memberType;

	@Column(name = "member_name")
	private String member_name;

	@Column(name = "member_email_id")
	private String member_email_id;
	
	@Column(name = "member_contact_no")
	private String member_contact_no;

	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Member(int member_id, String memberType, String member_name, String member_email_id,
			String member_contact_no) {
		super();
		this.member_id = member_id;
		this.memberType = memberType;
		this.member_name = member_name;
		this.member_email_id = member_email_id;
		this.member_contact_no = member_contact_no;
	}



	public int getMember_id() {
		return member_id;
	}



	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}



	public String getMemberType() {
		return memberType;
	}



	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}



	public String getMember_name() {
		return member_name;
	}



	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}



	public String getMember_email_id() {
		return member_email_id;
	}



	public void setMember_email_id(String member_email_id) {
		this.member_email_id = member_email_id;
	}



	public String getMember_contact_no() {
		return member_contact_no;
	}



	public void setMember_contact_no(String member_contact_no) {
		this.member_contact_no = member_contact_no;
	}



	

	
}
