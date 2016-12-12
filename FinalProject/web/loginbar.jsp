<%--
  Created by IntelliJ IDEA.
  User: Павел
  Date: 12-Dec-16
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<div class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Airlines</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li ><a href="#">Tickets </a></li>
                <li ><a href="#">Flights </a></li>
                <li ><a href="#">About us </a></li>
            </ul>
            <div class="navbar-form navbar-right">
                <!-- Login -->

                <button id="SingInButton" type="button" class="btn btn-default" data-toggle="modal" data-target="#login-modal">Login</button>
                <!-- BEGIN # MODAL LOGIN -->
                <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header" align="center">
                                <img class="img-circle" id="img_logo" src="http://www.iaateam.com/images/blueplane.png">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </button>
                            </div>

                            <!-- Begin # DIV Form -->
                            <div id="div-forms">

                                <!-- Begin # Login Form -->
                                <form id="login-form">
                                    <div class="modal-body">
                                        <div id="div-login-msg">
                                            <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                                            <span id="text-login-msg">Type your username and password.</span>
                                        </div>
                                        <input name="login" id="login_username" class="form-control" type="text" placeholder="Username" required>
                                        <input name="password" id="login_password" class="form-control" type="password" placeholder="Password" required>
                                    </div>
                                    <div class="modal-footer">
                                        <div>
                                            <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
                                        </div>
                                        <div>
                                            <button id="login_lost_btn" type="button" class="btn btn-link">Lost Password?</button>
                                            <button id="login_register_btn" type="button" class="btn btn-link">Register</button>
                                        </div>
                                    </div>
                                </form>
                                <!-- End # Login Form -->

                                <!-- Begin | Lost Password Form -->
                                <form id="lost-form" style="display:none;">
                                    <div class="modal-body">
                                        <div id="div-lost-msg">
                                            <div id="icon-lost-msg" class="glyphicon glyphicon-chevron-right"></div>
                                            <span id="text-lost-msg">Type your e-mail.</span>
                                        </div>
                                        <input id="lost_email" class="form-control" type="text" placeholder="E-Mail" required>
                                    </div>
                                    <div class="modal-footer">
                                        <div>
                                            <button type="submit" class="btn btn-primary btn-lg btn-block">Send</button>
                                        </div>
                                        <div>
                                            <button id="lost_login_btn" type="button" class="btn btn-link">Log In</button>
                                            <button id="lost_register_btn" type="button" class="btn btn-link">Register</button>
                                        </div>
                                    </div>
                                </form>
                                <!-- End | Lost Password Form -->

                                <!-- Begin | Register Form -->
                                <form id="register-form" style="display:none;">
                                    <div class="modal-body">
                                        <div id="div-register-msg">
                                            <div id="icon-register-msg" class="glyphicon glyphicon-chevron-right"></div>
                                            <span id="text-register-msg">Register an account.</span>
                                        </div>
                                        <input id="register_username" class="form-control" type="text" placeholder="Username" required>
                                        <input id="register_email" class="form-control" type="text" placeholder="E-Mail" required>
                                        <input id="register_password" class="form-control" type="password" placeholder="Password" required>
                                    </div>
                                    <div class="modal-footer">
                                        <div>
                                            <button type="submit" class="btn btn-primary btn-lg btn-block">Register</button>
                                        </div>
                                        <div>
                                            <button id="register_login_btn" type="button" class="btn btn-link">Log In</button>
                                            <button id="register_lost_btn" type="button" class="btn btn-link">Lost Password?</button>
                                        </div>
                                    </div>
                                </form>
                                <!-- End | Register Form -->

                            </div>
                            <!-- End # DIV Form -->

                        </div>
                    </div>
                </div>
                <!-- END # MODAL LOGIN -->
                <!--Login End-->
                <button id="SignUpButton" type="button" class="btn btn-default" data-toggle="modal" data-target="#login-modal">Sign up</button>

            </div>
        </div>


    </div>
</div>


<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/js.js"></script>
</body>
</html>