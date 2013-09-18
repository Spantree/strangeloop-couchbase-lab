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
    <title>Edit ${docKey}</title>
</head>
<body>
<div class="row">
    <form class="form-horizontal" role="form" method="POST">
        <g:each in="${labels.keySet()}" var="label">
            <g:set var="key" value="${labels[label]}"/>
            <div class="form-group">
                <label class="col-lg-2" for="${key}">${label}</label>
                <div class="col-lg-10">
                    <g:if test="${key == 'id'}">
                        ${doc[key]}
                    </g:if>
                    <g:else>
                        <input name="${key}" value="${doc[key]}" class="form-control" placeholder="Provide ${key}"/>
                    </g:else>
                </div>
            </div>
        </g:each>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Save</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>