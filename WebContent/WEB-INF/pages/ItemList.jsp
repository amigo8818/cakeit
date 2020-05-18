<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,io.cakeit.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");
	%>

	<h1>shopping cart</h1>
	<hr>
	<b>Items to add</b>
	<br>
	<ul>

		<%
			for (Item item : items) {
		%>
		<li><a href="ItemDetail?id=<%=item.getId()%>"><img src=<%=item.getIcon()%> width="100"> <%=item.getItemname()%></a>&nbsp;&nbsp;<%=item.getPrice()%><br><br>
	</li>
		<%
			}
		%>
	</ul>

</body>
</html>