<%--
  Created by IntelliJ IDEA.
  User: Anatoly
  Date: 09.05.2017
  Time: 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/css/basis.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/mainPage.css"/>">

<t:toolbar>
    <security:authorize access="hasAnyRole('ROLE_ADMIN')" var="isAdmin"/>
    <c:if test="${isAdmin}">
        <a href="${s:mvcUrl('GCC#addGood').build()}">
            <button class="btn btn-success"><s:message code="btn.add.good"/></button>
        </a>
    </c:if>
    <div class="good">
        <div class="row">
            <div class="col-md-2"><b>Name:</b></div>
            <div class="col-md-2 col-md-offset-1"><b>Description:</b></div>
            <div class="col-md-2 col-md-offset-1"><b>Categories:</b></div>
        </div>
        <c:choose>
            <c:when test="${fn:length(goods) gt 0}">
                <c:forEach items="${goods}" var="good">
                    <div class="row">
                    <c:if test="${not empty good.name}">
                        <div class="good_name col-md-2">
                            <a href="${s:mvcUrl('GC#showGood').arg(0, good.id).build()}"
                               style="color: saddlebrown">${good.name}</a>
                            <h2 style="color: saddlebrown"></h2>
                        </div>
                        <div class="good_description col-md-2 col-md-offset-1">
                            <p>${good.description}</p>
                        </div>
                        <div class="categories col-md-2 col-md-offset-1">
                            <c:forEach items="${good.categories}" var="category">
                                <p>${category.name}</p>
                            </c:forEach>
                        </div>
                        <c:if test="${isAdmin}">
                            <div class="form-group">
                                <div class="col-md-2 col-md-offset-1">
                                    <a href="${s:mvcUrl('GCC#getEditGood').arg(0, good.id).build()}">
                                        <button class="btn btn-primary"><s:message code="btn.edit.good"/></button>
                                    </a>
                                    <a href="${s:mvcUrl('GCC#dropGood').arg(0, good.id).build()}">
                                        <button class="btn btn-danger"><s:message code="btn.drop.good"/></button>
                                    </a>
                                </div>
                            </div>
                        </c:if>
                        </div>
                    </c:if>

                </c:forEach>
            </c:when>
            <c:otherwise>
                <h3>No goods to display</h3>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="window">
        <div class="container">
            <div class="products">
                <div class="info">
                    <h3 class="new-models">${type}</h3>
                    <ul class=items_block" id=items">
                        <c:choose>
                            <c:when test="${fn:length(catalog_goods) gt 0}">
                                <c:forEach items="${catalog_goods}" var="good">
                                    <li class="item_img">
                                        <div class="column">
                                            <form action="/info" method="get">
                                                <a href="${s:mvcUrl('GC#showGood').arg(0, good.id).build()}"
                                                   style="color: saddlebrown"><img
                                                        src="<c:url value="/images/${good.img}"/>"
                                                        class="img-responsive" alt=""></a>
                                            </form>
                                            <div class="good-name">
                                                <h4 name="name_good">${good.name}</h4>
                                                <p name="price">${good.price} рублей</p>
                                            </div>
                                            <a href="${s:mvcUrl('GCC#getEditGood').arg(0, good.id).build()}">
                                                <button class="btn btn-primary"><s:message code="btn.edit.good"/></button>
                                            </a>
                                            <a href="${s:mvcUrl('GCC#dropGood').arg(0, good.id).build()}">
                                                <button class="btn btn-danger"><s:message code="btn.drop.good"/></button>
                                            </a>
                                        </div>
                                    </li>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <h3>Catalog empty</h3>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="clear-float"></div>
    <div class="banner-bottom"></div>


    <div>
</t:toolbar>
