<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix ="logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Issue Details</title>
</head>
<body>
<h3>Book Issue Details</h3>
<hr>
<br>
<html:form action="libraryManagementAction">
<table border="1">
<tr>
<th>Issue Serial Name</th>
<th>Member Code</th>
<th>Member Name</th>
<th>Book Code</th>
<th>Book Name</th>
<th>Date Of Issue </th>
<th>Date Of Return</th>
</tr>

<logic:iterate name="list" id="issueDetails">
<tr>
<td><bean:write name="issueDetails" property="sr_no" /></td>
<td><bean:write name="issueDetails" property="member.member_id" /></td>
<td><bean:write name="issueDetails" property="member.member_name" /></td>
<td><bean:write name="issueDetails" property="book.book_id" /></td>
<td><bean:write name="issueDetails" property="book.book_title" /></td>
<td><bean:write name="issueDetails" property="issueDate" /></td>
<td><bean:write name="issueDetails" property="returnDate" /></td>

</logic:iterate>

</table>

<a href="firstPage.jsp">New</a>
<a href="">Update</a>
<a href="">Delete</a>

</html:form>
<br>
<br>

</body>
</html>