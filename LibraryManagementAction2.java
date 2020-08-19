package com.montran.action;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.LibraryDAO;
import com.montran.form.LibraryManagementForm1;
import com.montran.pojo.BookIssue;
import com.montran.pojo.BookMaster;
import com.montran.pojo.Member;

public class LibraryManagementAction2 extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		
		LibraryManagementForm1 detailsForm = (LibraryManagementForm1) form;
		LibraryDAO issueDetailsDAO = new LibraryDAO();
		Member member = null;
		BookMaster book = null;
		BookIssue details = null;

		detailsForm.setBook_id((issueDetailsDAO.getMaxBookIssue()));
		
		if (request.getParameter("member") != null) {
			if (request.getParameter("member").equals("getMember")) {
				System.out.println("getMember Button Clicked");
				System.out.println(detailsForm.getMember_id());
				member = issueDetailsDAO.getMemberByMemberCode(detailsForm.getMember_id());
				detailsForm.setMember_name(member.getMember_name());
				return mapping.findForward("book");
			}
		}
		if (request.getParameter("book") != null) {
			if (request.getParameter("book").equals("getBook")) {
				System.out.println("getBook Button Clicked");
				System.out.println(detailsForm.getBook_id());
				book = issueDetailsDAO.getBookByBookCode(detailsForm.getBook_id());
				detailsForm.setAuthor(book.getBook_author());
				detailsForm.setBook_title(book.getBook_title());

				LocalDate issueDate = LocalDate.now();
				LocalDate returnDate = LocalDate.now();

				member = issueDetailsDAO.getMemberByMemberCode(detailsForm.getMember_id());
				detailsForm.setMember_name(member.getMember_name());

				if (member.getMemberType().equals("student")) {
					returnDate = returnDate.plusDays(8);
					System.out.println(detailsForm);
				}
				if (member.getMemberType().equals("faculty")) {
					returnDate = returnDate.plusDays(90);
					System.out.println(detailsForm);
				}

				detailsForm.setDate(issueDate.toString());
				detailsForm.setReturn_date(returnDate.toString());
				System.out.println("--------------------------------------");
				System.out.println(detailsForm);

				HttpSession httpSession = request.getSession();

				httpSession.setAttribute("member", member);
				httpSession.setAttribute("book", book);
				httpSession.setAttribute("issueDate", issueDate);
				httpSession.setAttribute("returnDate", returnDate);
				return mapping.findForward("member");
			}
		}
		if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issueBook")) {
				System.out.println("Issue Book Button Click");
				HttpSession httpSession = request.getSession();
				LocalDate issueDate = null;
				LocalDate returnDate = null;

				if (httpSession.getAttribute("book") != null)
					book = (BookMaster) httpSession.getAttribute("book");
				if (httpSession.getAttribute("member") != null)
					member = (Member) httpSession.getAttribute("member");
				if (httpSession.getAttribute("issueDate") != null)
					issueDate = (LocalDate) httpSession.getAttribute("issueDate");
				if (httpSession.getAttribute("returnDate") != null)
					returnDate = (LocalDate) httpSession.getAttribute("returnDate");

				Random random = new Random();
				Date issueD = Date.from(issueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date returnD = Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

				details = new BookIssue(detailsForm.getBook_id(), issueD, returnD, book, member);
				issueDetailsDAO.issueNewBook(details);
				System.out.println("Book Issued Successfully !!");
			}
		}

		return mapping.findForward("success");
	}
}	

