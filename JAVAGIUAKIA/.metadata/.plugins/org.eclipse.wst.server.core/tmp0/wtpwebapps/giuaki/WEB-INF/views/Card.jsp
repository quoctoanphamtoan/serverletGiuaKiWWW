<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Card</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<h1>Card-person</h1>
		<div class="row">
			<div class="col-8">
				<table class="table">
					<thead>
						<tr>
							<th>Stt</th>
							<th>Number</th>
							<th>Type</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listCard}" var="card" varStatus="lop">
							<tr>
								<td>${lop.index+1}</td>
								<td>${card.getNumber()}</td>
								<td>${card.getType()}</td>
								<td><a role="button"
									href="card/delete?id=${card.getId()}&&personId=${personId}"
									class="btn btn-danger">Delete</a>
                                    <a role="button"
									href="card/edit?id=${card.getId()}&&personId=${personId}"
									class="btn btn-info">Edit</a>
                                
                                
                                </td>
							</tr> 
						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="col-4">
				<a href="card/addcard?id=${personId}" role="button"
					class="btn btn-success">Add card</a>
					<a href="/giuaki/person" role="button"
					class="btn btn-success">Back</a>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
