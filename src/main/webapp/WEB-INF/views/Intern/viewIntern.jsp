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
						<c:out value="${intern.fullName}"/>
					</td>
					<td/>
				</tr>
				<tr>
					<th>
						<form:label path="email">Email:</form:label>
					</th>
					<td>
						<c:out value="${intern.email}"/>
					</td>
					<td/>
				</tr>
			</tbody>
		</table>

	</form:form>

	<div class="buttons">
		<table>
			<tr>
				<td>
					<a class="button" href="<c:url value="/interns"/>">View All</a>
				</td>
				<td>
					<a class="button" href="<c:url value="/interns/${intern.id}?edit=true"/>">Edit</a>
				</td>
				<td>
					<a class="button" href="<c:url value="/interns/create"/>">Create New</a>
				</td>
			</tr>
		</table>
	</div>
</div>
