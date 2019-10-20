<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.error {
	color: #FF0000
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="reg"]').validate({
			rules : {
				name : 'required',
				pwd : 'required',
				email : {
					required : true,
					email : true
				},
				phone : 'required',
			},
			messages : {
				username : 'Please enter username',
				password : 'please enter password',
				email : 'Please enter valid email',
				phone : 'please enter phone number',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script></head>
<body>
	<p>
	<h1 style="color: red; text-align: center">${msg}</h1>
	</p>

	<h1 style="color: red; text-align: center">Form Register</h1>
	<form:form action="registerUser" method="post" modelAttribute="user" id="reg">
		<table>
			<tr>
				<th>UserName</th>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<th>Passsword</th>
				<td><form:password path="pwd" /></td>
			</tr>

			<tr>
				<th>Email</th>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<th>Phone</th>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<th>Country</th>
				<td><form:select path="country">
						<form:options items="${countryList}" />
					</form:select></td>
			</tr>

			<tr>
				<th><input type="reset" value="reset" /></th>
				<th><input type="submit" value="Resgister" /></th>
			</tr>
		</table>
	</form:form>
		<a href="viewUser?pid=1">ViewUser</a>	

</body>
</html>