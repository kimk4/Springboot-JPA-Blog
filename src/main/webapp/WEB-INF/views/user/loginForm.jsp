<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
 
	<form action="/auth/loginProc" method="post"> <!-- action="/bolg/api/user/login" -->
	  <div class="form-group">
	    <label for="username">Username</label>
	    <input type="text" name="Username" class="form-control" placeholder="Enter Username" id="username">
	  </div>
	  
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
	  </div>
	    
	  <button id="btn-login" class="btn btn-primary">로그인</button>
	</form>
	
	
</div>

<!-- <script src="/js/user.js"></script> -->
<%@ include file="../layout/footer.jsp" %>
