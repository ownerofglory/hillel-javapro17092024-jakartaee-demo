<%@ page import="ua.ithillel.jakartaee.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hillel Task App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <%
        List<Task> tasks = (List<Task>) request.getAttribute("tasks");
    %>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Hillel Task App</h1>
            </div>
        </div>
        <main class="row">
            <form action="/hillel-jakartaee-demo/task" method="post">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Enter your task</label>
                    <input type="text" name="task" class="form-control" id="exampleFormControlInput1" placeholder="task...">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </form>

            <section>
                <h2>Task list</h2>

                <ul class="list-group">
                    <%
                        for (Task task: tasks) {
                    %>
                        <li class="list-group-item">
                            <%= task.getName() %>
                        </li>
                    <%
                        }
                    %>
                </ul>

            </section>
        </main>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
