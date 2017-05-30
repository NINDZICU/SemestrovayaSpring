<%--
  Created by IntelliJ IDEA.
  User: Anatoly
  Date: 08.05.2017
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:toolbar>
    <h2 style="color: green">${message}</h2>
    <h2>Add Good</h2>
    <form:form method="POST" action="${s:mvcUrl('GCC#addGood').build()}" cssclass="form-horizontal" commandName="good">
        <div class="form-group">
            <form:label path="name" cssClass="control-label col-xs-3" for="name"><s:message
                    code="reg.name.name"/></form:label>
            <div class="col-xs-9">
                <form:input path="name" id="name" cssClass="form-control"/>
            </div>
            <form:errors cssStyle="color: red" path="name"/><br>
        </div>

        <div class="form-group">
            <form:label path="price" cssClass="control-label col-xs-3" for="price">Price:</form:label>
            <div class="col-xs-9">
                <form:input path="price" id="price" cssClass="form-control"/>
            </div>
            <form:errors cssStyle="color: red" path="price"/><br>
        </div>

        <form:label path="description">Description:</form:label>
        <form:textarea path="description"/>
        <form:errors cssStyle="color: red" path="description"/><br>

        <div class="form-group">
        <form:label path="img" cssClass="control-label col-xs-3" for="name">Name of image</form:label>
        <div class="col-xs-9">
            <form:input path="img" id="img" cssClass="form-control"/>
        </div>
        <form:errors cssStyle="color: red" path="img"/><br>
        </div>

        <form:label path="categories">Category:</form:label>
        <form:select path="categories" multiple="true" size="5">
            <form:option value="NONE">
                <form:options items="${categories}"></form:options>
            </form:option>
        </form:select>
        <form:errors cssStyle="color: red" path="categories"/><br>

        <input type="submit" value=<s:message code="btn.add"/>>
    </form:form>
</t:toolbar>
