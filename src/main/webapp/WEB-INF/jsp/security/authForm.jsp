<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:toolbar>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>--%>
    <!-- Material Design Bootstrap -->
    <link href="<c:url value="/css/mdb.css"/>" rel="stylesheet"/>

    <link rel='stylesheet' id='style.css-css'
          href='https://mdbootstrap.com/wp-content/themes/mdbootstrap4/style.css?ver=4.7.4' type='text/css'
          media='all'/>
    <link rel='stylesheet' id='compiled.css-css' href="<c:url value="/css/style.css-css.css"/>" type='text/css'/>

    <br><br>

    <c:if test="${error != null}">
        <div class="text-danger">
            <b>Wrong email or password.</b>
        </div>
    </c:if>
    <div class="row">
        <div class="col-lg-4 col-md-8 mx-auto">
            <div class="card">
                <div class="card-block">

                    <!--Header-->
                    <div class="form-header  purple darken-4">
                        <h3><i class="fa fa-lock"></i> Login:</h3>
                    </div>

                    <!--Body-->
                        <%--<c:url value="/j_spring_security_check" var="loginUrl" />--%>
                    <form:form method="post" commandName="loginForm">
                        <div class="md-form">
                            <i class="fa fa-envelope prefix"></i>
                            <form:input type="text" path="name" id="form2" cssClass="form-control"/>
                            <label for="form2">Your email</label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-lock prefix"></i>
                            <form:password path="password" id="form4" cssClass="form-control"/>
                            <label for="form4">Your password</label>
                        </div>

                        <div class="text-center">
                            <button class="btn btn-deep-purple">Login</button>
                        </div>
                    </form:form>

                </div>

                <!--Footer-->
                <div class="modal-footer">
                    <div class="options">
                        <p>Not a member? <a href="#">Sign Up</a></p>
                        <p>Forgot <a href="#">Password?</a></p>
                    </div>
                </div>

            </div>

        </div>
    </div>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.js"/>"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="<c:url value="/js/tether.min.js"/>"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>


    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="<c:url value="/js/mdb.min.js"/>"></script>
</t:toolbar>