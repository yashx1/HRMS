<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!--  navbar starts -->
    <!-- Fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>/">HERMES</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown">Employee <b class="caret"></b></a>
	              <ul class="dropdown-menu">
	                <li><a href="<%=request.getContextPath()%>/employee/create">Create Employee</a></li>
	                <li><a href="<%=request.getContextPath()%>/employee/list">List Employees</a></li>
	              </ul>
            </li>
     	    <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown">Team <b class="caret"></b></a>
              <ul class="dropdown-menu">
              		<li><a href="<%=request.getContextPath()%>/team/create">Create Team</a></li>
	                <li><a href="<%=request.getContextPath()%>/team/list">List Teams</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
 <!--  navbar ends -->
 <!--  Developed By Yashaswi Kumar < yashx1@gmail.com > -->