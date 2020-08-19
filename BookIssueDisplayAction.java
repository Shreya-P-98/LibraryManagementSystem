package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.LibraryDAO;
import com.montran.form.LibraryManagementForm1;
//import com.montran.form.LibraryManagementForm1;
import com.montran.pojo.BookIssue;

public class BookIssueDisplayAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		System.out.println("in action");
		BookIssue book = new BookIssue();
	
		LibraryDAO dao = new LibraryDAO();
		List<BookIssue> booklist = dao.getAllEmployee();
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("list", booklist);

		
//				request.setAttribute("list",booklist);
			
		
		return mapping.findForward("success");
	}

}
