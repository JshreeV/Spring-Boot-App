<%-- 
    Document   : courses
    Created on : 30-Mar-2019, 5:38:25 PM
    Author     : Jayshree
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
        ul li 
	{
            display: table-cell;
	}
        body {
            background: white }
        table {
            background: bisque;
            color: black;
            border-radius: 1em;
            padding: 1em;
            font-size: large;
            font-weight: bold;
            margin-left: 2%;
        }
        form{
            width: 27%;
            margin-left : 30%
        }    
</style>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script type="text/javascript">
function onCourseFormSubmit(obj)
{
	if(obj.courseName.value === "")
	{
		alert("course name is required");
				
	}
	else
	{
		$.ajax({
			url:"/course",
			method:"post",
			data:$(obj).serialize(),
			success:function(id)
			{
				showCourse();
				obj.reset();
			}
		})
	}
	return false;
}
function showCourse()
{
	$.ajax({
		url:"/course",
		success:function(data)
		{
			$("#courseData").html("");
			for(i in data)
			{
				$("#courseData").append("<tr><td>" + data[i].course_id + "</td><td>" 
						+ data[i].course_name + "</td><td>" 
						+ data[i].course_duration + "</td>"
						+ "<td><a href='javascript:void(0);' onclick='deleteCourse(" + data[i].course_id + ")' >Delete</a></td></tr>");
			}
		}
	})
}
function deleteCourse(id)
{
	$.ajax({
		url:"/course",
		method:"delete",
		data:"courseId="+id,
		success:function(data)
		{
			showCourse();
			alert(data);
		}
	})
}
</script>
<meta charset="ISO-8859-1">
<title>Course Management</title>
</head>
<body onload="showCourse();">

<form action="/course" name="courseForm" method="post" onsubmit="return onCourseFormSubmit(this);">
    <fieldset>
                <legend>Course Details </legend>
	<table>
		<tbody>
			<tr>
				<td>Course Name</td>
                                <td><input type="text" name="courseName" /></td>
                        </tr>
                        <tr>
                                <td>Course Duration</td>
				<td><input type="text" name="courseDuration" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">
					<input type="reset" value="reset" />
					<input type="submit" value="Save" />
				</td>
			</tr>
		</tbody>
	</table>
    </fieldset>
</form>
<table style="margin-left: 30%; margin-top: 2%">
	<thead>
		<tr>
                        <th>Course ID</th>
			<th>Course Name</th>
                        <th>Course Duration</th>
			<th></th>
		</tr>
	</thead>
	<tbody id="courseData">
	</tbody>
</table>
</body>
</html>
