<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
	<form:form commandName="project">

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
						<form:label path="projectName">Project Name:</form:label>
					</th>
					<td>
						<c:out value="${project.projectName}"/>
					</td>
					<td/>
				</tr>
				<tr>
					<th>
						<form:label path="maxPeople">Max People:</form:label>
					</th>
					<td>
						<c:out value="${project.maxPeople}"/>
					</td>
					<td/>
				</tr>
				<tr>
					<th>
						<form:label path="interns">Interns:</form:label>
					</th>
					<td>
						<table id="interns">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>Email</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${project.interns}" var="item">
									<tr>
										<td>
											<c:out value="${item.fullName}"/>
										</td>
										<td>
											<c:out value="${item.email}"/>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
					<a class="button" href="<c:url value="/projects"/>">View All</a>
				</td>
				<td>
					<a class="button" href="<c:url value="/projects/${project.id}?edit=true"/>">Edit</a>
				</td>
				<td>
					<a class="button" href="<c:url value="/projects/create"/>">Create New</a>
				</td>
			</tr>
		</table>
	</div>
</div>
