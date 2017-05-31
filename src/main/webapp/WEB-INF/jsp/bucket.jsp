<%--
  Created by IntelliJ IDEA.
  User: Anatoly
  Date: 30.05.2017
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<link rel="stylesheet" type="text/css" href="<c:url value="/css/basis.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/basket.css"/>">


<t:toolbar>
    <div class="window">
        <div class="container">
            <div class="basket">
                <c:choose>
                    <c:when test="${fn:length(goods) gt 0}">
                        <c:forEach items="${goods}" var="good">
                            <div class="good">
                                <div class="basket_img">
                                        <img class="img_good" src="<c:url value="/images/${good.img}"/>" alt=""/>
                                </div>
                                <div class="basket_good_name">
                                    <div>
                                        <h5 class="title">${good.name}</h5>
                                    </div>
                                </div>
                                <div class="price">${good.price} руб.</div>
                                <%--<div class="quantity">Quantity:</div>--%>

                                <%--<form class="basket_item" action="<c:url value="/good/edit"/>" method="post">--%>
                                    <%--<select class="select_quantity" name='quantity' required>--%>
                                        <%--<option disabled>Select quantity</option>--%>
                                        <%--<option>1</option>--%>
                                        <%--<option>2</option>--%>
                                        <%--<option>3</option>--%>
                                        <%--<option>4</option>--%>
                                        <%--<option>5</option>--%>
                                        <%--<option>6</option>--%>
                                    <%--</select>--%>
                                    <%--<input type="text" name="id" hidden value="${good.id}">--%>
                                    <%--<input type="submit" class="btn btn-primary" value="Edit quantity">--%>
                                <%--</form>--%>
                                <div class="link">
                                    <a href="${s:mvcUrl('BC#dropGoodFromBucket').arg(0, good.id).build()}">
                                        <button class="btn btn-danger">Remove</button>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h3>No goods to display</h3>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="clear-float"></div>
            <div class="link">
                <form action="action="${s:mvcUrl('BC#dropAllGoodFromBucket').build()}" method="get">
                    <input class="btn btn-primary" type="submit" name="doCheck" value="Оформить заказ">
                </form>
            </div>
            <div class="link">
                <form method="get" action="${s:mvcUrl('BC#dropAllGoodFromBucket').build()}">
                    <input class="btn btn-danger" type="submit" name="deleteAll" value="Удалить все">
                </form>
            </div>
        </div>
        <div>
        </div>
        <div class="clear-float"></div>
        <div class="banner-bottom"></div>

    </div>
</t:toolbar>