<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function get() {
		return confirm("DO You really want to Delete")
	}
</script>


<h1 style="color: red; text-align: center">ALL USER INFO</h1>

<c:choose>
	<c:when test="${!empty display}">
		<table border="1" style="color: cyan; text-align: center">
			<tr bgcolor="red">
				<th>SerialNo</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Country</th>
				<th>Action</th>

			</tr>
			<c:forEach items="${display}" var="user" varStatus="index">
				<tr>
					<td><c:out value="${index.count}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.phone}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.country}" /></td>
					<td><a href="update?uid=${user.userId}">update</a> <a
						href="delete?uid=${user.userId}" onclick="return get()">delete</a></td>
				</tr>
			</c:forEach>
			<a href="get">+addUser</a>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center;">NO RECOREDS ARE
			SELECED</h1>
	</c:otherwise>

</c:choose>


<!-- pagination  -->

<c:if test="${cp>1}">
	<a href="viewUser?pid=${cp-1}">previous</a>
</c:if>
<c:forEach begin="1" end="${ps}" var="i">
	<c:choose>
		<c:when test="${cp==i}">
			<c:out value="${i}"></c:out>
		</c:when>
		<c:otherwise>
			<a href="viewUser?pid=${i}"><c:out value="${i}"></c:out></a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${cp<ps}">
	<a href="viewUser?pid=${cp+1}">Next</a>
</c:if>






