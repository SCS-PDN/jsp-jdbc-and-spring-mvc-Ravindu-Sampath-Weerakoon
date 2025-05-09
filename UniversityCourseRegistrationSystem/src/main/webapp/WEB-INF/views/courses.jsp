<h2>Available Courses</h2>
<c:forEach var="course" items="${courses}">
    ${course.name} by ${course.instructor} - ${course.credits} credits
    <form method="post" action="register/${course.courseId}">
        <input type="submit" value="Register"/>
    </form>
</c:forEach>
