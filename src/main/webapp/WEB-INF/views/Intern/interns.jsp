<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
	<form:form commandName="search" method="GET">
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
		<br/>

		<div class=" buttons">
			<table>
				<tbody>
					<tr>
						<td>
							<input type="submit" value="Search" class="button"/>
						</td>
						<td>
							<a class="button" href="<c:url value="/interns/create"/>">Create New</a>
						</td>
					</tr>					
				</tbody>
			</table>
		</div>
	</form:form>

	<table>
		<c:forEach items="${entities}" var="entity">
			<tr>
				<td>Intern ${entity.id}</td>
				<td><a class="button" href="<c:url value="/interns/${entity.id}"/>">View</a></td>
				<td><a class="button" href="<c:url value="/interns/${entity.id}?edit=true"/>">Edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<br/>

</div>
