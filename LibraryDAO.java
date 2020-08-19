package com.montran.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.montran.pojo.BookIssue;
import com.montran.pojo.BookMaster;
import com.montran.pojo.Member;
import com.montran.util.SessionFactoryUtil;

public class LibraryDAO {
	
	private Session session;
	private Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getSessionFacotry();
	
	
	
	
	
	public List<BookIssue> getAllEmployee(){
		System.out.println("In dao");
		session = factory.openSession();
		Query query = session.createQuery("from bookissue");
		List<BookIssue> bookList = query.list();
			System.out.println(bookList);
		return bookList;
		
	}
	
	public void issueNewBook(BookIssue details) {
		session = SessionFactoryUtil.getSessionFacotry().openSession();
		transaction = session.beginTransaction();
		session.save(details);
		transaction.commit();
		session.close();
	}


	public Member getMemberByMemberCode(int memberCode) {
		session = SessionFactoryUtil.getSessionFacotry().openSession();
		Member member = session.get(Member.class, memberCode);
		System.out.println(member);
		session.close();
		return member;
	}
	
	public BookMaster getBookByBookCode(int book_id) {
		session = SessionFactoryUtil.getSessionFacotry().openSession();
		BookMaster book = session.get(BookMaster.class, book_id);
		System.out.println(book);
		System.out.println("in getbook by book id");
		session.close();
		return book;
	}
	
	public int getMaxBookIssue() {
		session = SessionFactoryUtil.getSessionFacotry().openSession();
		Query query = session.createQuery("select max(sr_no) from bookissue");
		List<Integer> issueList = query.list();
		int maxCount = issueList.get(0);
		System.out.println("Total Books :: " + maxCount);
		session.close();

		return maxCount + 1;
	}
	


}


