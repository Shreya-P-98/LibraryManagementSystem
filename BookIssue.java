package com.montran.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "bookissue")
public class BookIssue {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_issue_gen")
	//@SequenceGenerator(sequenceName = "book_issue_sequence", name = "book_issue_gen")
	@Column(name = "sr_no")
	private int sr_no;

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "return_date")
	private Date returnDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private BookMaster book;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id")
	private Member member;

	public BookIssue() {
		// TODO Auto-generated constructor stub
	}


	

	public BookIssue(int sr_no, Date issueDate, Date returnDate, BookMaster book, Member member) {
		super();
		this.sr_no = sr_no;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.book = book;
		this.member = member;
	}




	public int getSr_no() {
		return sr_no;
	}




	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}




	public Date getIssueDate() {
		return issueDate;
	}




	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}




	public Date getReturnDate() {
		return returnDate;
	}




	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}




	public BookMaster getBook() {
		return book;
	}




	public void setBook(BookMaster book) {
		this.book = book;
	}




	public Member getMember() {
		return member;
	}




	public void setMember(Member member) {
		this.member = member;
	}




		
}
