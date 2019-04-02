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
<style type="text/css">
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
            width: 30%;
            margin-left : 30%
        } 
</style>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script type="text/javascript">
function onStudentFormSubmit(obj)
{
	if(obj.studentName.value === "")
	{
		alert("student name is required");
				
	}
	else
	{
		$.ajax({
			url:"/student",
			method:"post",
			data:$(obj).serialize(),
			success:function(id)
			{
				showStudent();
				obj.reset();
			}
		})
	}
	return false;
}
function showData(){
    showStudent();
    showStudentEnrolledCourse();
}
function showStudent()
{
	$.ajax({
		url:"/student",
		success:function(data)
		{
			$("#studentData").html("");
			for(i in data)
			{
				$("#studentData").append("<tr><td>" + data[i].name + "</td><td>" 
						+ data[i].age + "</td><td>" + data[i].address + "</td><td>" + data[i].course_id + "</td>"
						+ "<td><a href='javascript:void(0);' onclick='deleteStudent(" + data[i].id + ")' >Delete</a></td></tr>");
			}
		}
	})
}
function deleteStudent(id)
{
	$.ajax({
		url:"/student",
		method:"delete",
		data:"studentId="+id,
		success:function(data)
		{
			showStudent();
			alert(data);
		}
	})
}

function showStudentEnrolledCourse()
{
	$.ajax({
		url:"/course",
                
                success : function(response) {
			$('#courseSelect').empty();
			$('#courseSelect').append($('<option>', {
			    value: 0,
			    text:  'Select'
			}));
			for (item in response) {
				$('#courseSelect').append($('<option>', {
				    value: response[item].course_id,
				    text:  response[item].course_name
				}));
			}
		},
		error : function(e) {
			// alert("Submit failed" + JSON.stringify(e));
		}
	});
}
</script>
<meta charset="ISO-8859-1">
<title>Student Management</title>
</head>
<body onload="showData();">

    <form action="/student" name="studentForm" method="post" onsubmit="return onStudentFormSubmit(this);" >
        <fieldset>
                <legend>Student Details </legend>
            <table>
                    <tbody>
                            <tr>
                                    <td>Student Name</td>
                                    <td><input type="text" name="studentName" /></td>
                            </tr>
                            <tr>
                                    <td>Student Age</td>
                                    <td><input type="number" name="studentAge" /></td>
                            </tr>
                            <tr>
                                    <td>Student Address</td>
                                    <td><textarea rows="3" cols="20" name="studentAddress"></textarea>
                            </tr>
                            <tr>
                                    <td>Course ID</td>
                                    <td><select id="courseSelect" name="courseId">
                                        <option value="0">Choose Course</option></select>
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
    <table style="margin-left: 35%; margin-top: 2%">
	<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Address</th>
                        <th>Course ID</th>
			<th></th>
		</tr>
	</thead>
	<tbody id="studentData">
	</tbody>
    </table>
</body>
</html>