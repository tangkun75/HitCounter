<%@ page import="java.util.Map" %>
<html>
<head>
    <title>JSP - Context Path</title>
</head>

<body>
<table>
    <tr>
        <td> Page Name</td>
        <td> Hit Counter</td>
    </tr>
<%

    ServletContext sc = request.getServletContext();
    Map<String, Integer> pagesHitCounts = (Map<String, Integer>) sc.getAttribute("PagesHitCounts");
    for (String pageName : pagesHitCounts.keySet()) {
%>
    <tr>
        <td><%=pageName%> </td><td/><td/>
        <td><%=pagesHitCounts.get(pageName)%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>