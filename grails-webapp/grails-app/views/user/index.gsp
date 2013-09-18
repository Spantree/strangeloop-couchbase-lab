<%--
  Created by IntelliJ IDEA.
  User: cedric
  Date: 9/18/13
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Users</title>
</head>
<body>
    <div class="row">
        <table class="table table-striped table-bordered col-md-12 col-lg-12">
            <thead>
                <tr>
                    <th>Key</th>
                    <th>ID</th>
                    <th>User</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Company</th>
                </tr>
            </thead>
            <g:each in="${rows}" var="row">
                <tr>
                    <th><g:link uri="/users/${row.key}">${row.key}</g:link></th>
                    <td>${row.doc.id}</td>
                    <td>${row.doc.user}</td>
                    <td>${row.doc.first}</td>
                    <td>${row.doc.last}</td>
                    <td>${row.doc.email}</td>
                    <td>${row.doc.company}</td>
                </tr>
            </g:each>
        </table>
    </div>
</body>
</html>