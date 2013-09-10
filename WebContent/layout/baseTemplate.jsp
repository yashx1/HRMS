<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>

<link rel="shortcut icon" href="">
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.css"	rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/css/theme.css"	rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="<%=request.getContextPath()%>/assets/js/html5shiv.js"></script>
      <script src="<%=request.getContextPath()%>/assets/js/respond.min.js"></script>
    <![endif]-->

<style id="holderjs-style" type="text/css">
.holderjs-fluid {
	font-size: 16px;
	font-weight: bold;
	text-align: center;
	font-family: sans-serif;
	margin: 0
}

#footer {
   position:fixed;
   left:0px;
   bottom:0px;
   height:30px;
   width:100%;
   background:#999;
}

/* IE 6 */
* html #footer {
   position:absolute;
   top:expression((0-(footer.offsetHeight)+(document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight)+(ignoreMe = document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop))+'px');
}
</style>

<script type="text/javascript">
	var _hermes = {};
	_hermes.appContext = '<%=request.getContextPath() %>';
</script>

</head>

<body style="">

<!-- navbar starts -->
<tiles:insertAttribute name="navbar" ignore="true"></tiles:insertAttribute>
<!--  navbar ends -->

<!-- container starts -->
<tiles:insertAttribute name="container" ignore="true"></tiles:insertAttribute>
<!-- conatainer ends -->

<div id="footer" style="padding: 1% 2% 2% 2%;">
                    <a rel="license" href="http://creativecommons.org/licenses/by-nc/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-nc/3.0/80x15.png"></a>   This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc/3.0/">Creative Commons Attribution-NonCommercial 3.0 Unported License</a>.
        Created By <a href="mailto:yashx1@gmail.com">Yashaswi Kumar</a>.
</div>

<!-- Bootstrap core JavaScript-->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/holder.js"></script>
<!--  Developed By Yashaswi Kumar < yashx1@gmail.com > -->
</body>
</html>