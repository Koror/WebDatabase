<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>
	<form method="post" action="backend" name="frmUser">
		<% String action = request.getParameter("action");
           System.out.println(action);
            if(action.equals("edit")) 
            {  
        %>  
        ID :       <input type="text" name="id" value="<c:out value="${user.id}"/>" readonly="readonly"/> Read only 
        <br/>
        Nickname : <input type="text" name="nickname" value="<c:out value="${user.nickname}"/>" /> 
        <br/>
        Password  : <input type="password" name="pass" value="<c:out value="${user.password}"/>" /> 
        <br/>    
        Email : <c:out value="${user.email}"/>
        <br/>
        Date :  <c:out value="${user.dateReg}"/> 
        <br/>
        <%
            }
        %>
        
        <%
        if(action.equals("insert")) 
        { 
        %>
        Nickname : <input type="text" name="nickname" value=""/> 
        <br/>
        Password :  <input type="password" name="pass" value=""/> 
        <br/>    
        Email :     <input type="text" name="email" value=""/> 
        <br/>
        <%
            }
        %>
        
        <input type="submit" value="btnSubmit">
	</form>
</body>
</html>