<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
	<form:form commandName="intern">
	
		<table>
			<tbody>
				<tr>
					<th/>
					<td>
						<form:hidden path="id"/>
					</td>
					<td/>
				</tr>
				<tr>
					<th/>
					<td>
						<form:hidden path="version"/>
					</td>
					<td/>
				</tr>
				<tr>
					<th>
						<form:label path="fullName">Full Name:</form:label>
					</th>
					<td>
						<form:input path="fullName"/>
					</td>
					<td/>
				</tr>
				<tr>
					<th>
						<form:label path="email">Email:</form:label>
					</th>
					<td>
						<form:input path="email"/>
					</td>
					<td/>
				</tr>
			</tbody>
		</table>

		<div class="buttons">
			<table>
				<tbody>
					<tr>
						<td>
							<input type="submit" value="Save" class="button"/>
						</td>
						<td>
							<a class="button" href="<c:url value="/interns"/>">Cancel</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form:form>
</div>
