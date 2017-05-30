<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.10.2016
  Time: 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>


<link rel="stylesheet" type="text/css" href="<c:url value="/css/basis.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/goodInfo.css"/>">

<t:toolbar>


    <div class="window">
        <div class="container">
            <div class="information">
                <c:forEach items="${goods}" var="good">

                <div class="img_good_cont">
                        <%--<img class="img_good" src="<c:url value="/images/${img_good}"/>" alt=""/>--%>
                </div>

                <div class="descr">
                    <div class="add_good">
                        <form:form method="post" commandName="good"
                                   action="${s:mvcUrl('GCC#showGoods').arg(0, good.id).build()}">
                            <select class="select_quantity" name='quantity' required>
                                <option disabled>Select quantity</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                            </select>
                            <input type="submit" class="btn_add" name="add" value="add to basket">
                        </form:form>
                        <%--<form action="/basket/add?id=${catalogId}" method="get">--%>

                        <%--</form>--%>
                    </div>
                    <h3>${good.name}</h3>
                    <p>${good.price} руб.</p>

                    <div class="text_information">

                        <h3>Information</h3>
                        <p>${good.description}</p>
                    </div>
                </div>
                    <p>Comments:</p>
                    <c:forEach items="${good.comments}" var="comment">
                        <p>${comment.text}</p>
                    </c:forEach>
                    <form:form method="post" commandName="comment"
                               action="${s:mvcUrl('CC#addComment').arg(0, good.id).build()}">
                        <form:textarea path="text"></form:textarea>
                        <input type="submit" value=<s:message code="btn.add.comment"/>>
                    </form:form>
                </c:forEach>
        </div>

    </div>
    </div>
    <div class="clear-float"></div>
    <div class="banner-bottom"></div>

</t:toolbar>

