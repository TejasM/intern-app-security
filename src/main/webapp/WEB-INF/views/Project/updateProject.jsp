<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="section">
	<form:form commandName="project" action="${project.id}">

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
						<form:input path="projectName"/>
					</td>
					<td/>
				</tr>
				<tr>
					<th>
						<form:label path="maxPeople">Max People:</form:label>
					</th>
					<td>
						<form:input path="maxPeople"/>
					</td>
					<td/>
				</tr>
				<tr>
					<th>
						<form:label path="interns">Interns:</form:label>
					</th>
					<td>
						<form:select itemValue="id" items="${interns}" multiple="multiple" path="interns"/>
						<a href="<c:url value="/interns/create"/>">Create New Intern</a>
					</td>
					<td/>
				</tr>
			</tbody>
		</table>

		<input type="submit" value="Save" class="button"/>

	</form:form>

	<div class="buttons">
		<table>
			<tbody>
				<tr>
					<td>
						<a class="button" href="<c:url value="/projects"/>">Cancel</a>
					</td>
					<td>
						<form:form commandName="project" action="${project.id}/delete" method="POST">
							<input type="submit" value="Delete" class="button"/>
						</form:form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
