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

    <div class="row">
        <div class="col-lg-4 col-md-8 mx-auto">
            <!--Form with header-->
            <div class="card">
                <div class="card-block">

                    <!--Header-->
                    <div class="form-header blue-gradient">
                        <h3><i class="fa fa-user"></i> Register:</h3>
                    </div>

                    <!--Body-->
                    <form:form method="post" commandName="user">
                        <div class="md-form">
                            <i class="fa fa-user prefix"></i>
                            <form:input path="name" id="form3" cssClass="form-control"/>
                            <form:errors path="name" cssStyle="color:red"/>
                            <label for="form3">Your name</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-envelope prefix"></i>
                            <form:input path="login" id="form2" cssClass="form-control"/>
                            <form:errors path="login" cssStyle="color:red"/>
                            <label for="form2">Your email</label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-lock prefix"></i>
                            <form:password path="password" id="form4" cssClass="form-control"/>
                            <form:errors path="password" cssStyle="color:red"/>
                            <label for="form4">Your password</label>
                        </div>
                        <label class="custom-control custom-radio">
                            <form:radiobutton path="gender" id="radio1" cssClass="custom-control-input" value="1"/>
                            <form:errors path="gender" cssStyle="color:red"/>
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">Man</span>
                        </label>
                        <label class="custom-control custom-radio">
                            <form:radiobutton path="gender" id="radio2" cssClass="custom-control-input" value="0"/>
                            <form:errors path="gender" cssStyle="color:red"/>
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">Woman</span>
                        </label>

                        <div class="text-center">
                            <button class="btn btn-indigo">Sign up</button>
                            <hr>
                            <fieldset class="form-group">
                                <input type="checkbox" id="checkbox1">
                                <label for="checkbox1">Subscribe me to the newsletter</label>
                            </fieldset>
                        </div>
                        <form:input path="captcha" cssClass="form-control" />
                        <form:errors path="captcha" cssStyle="color: red"/>${captchaError}
                        <img height="300px" id="captchaImage1" border="0" width="300px"
                             src="<c:url value="/images1/image.jpg"/>" onclick="f1()" />
                    </form:form>

                </div>
            </div>
        </div>
        <!--/Form with header-->
    </div>

    <script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.js"/>"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="<c:url value="/js/tether.min.js"/>"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>


    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="<c:url value="/js/mdb.min.js"/>"></script>
</t:toolbar>