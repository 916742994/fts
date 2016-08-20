<html xmlns="http://www.w3.org/1999/html">
<body>
<link type="text/css" rel="stylesheet" href="${absoluteContextPath}/css/font-awesome.min.css"></link>
<link type="text/css" rel="stylesheet" href="${absoluteContextPath}/css/button.style.css"></link>
<link type="text/css" rel="stylesheet" href="${absoluteContextPath}/css/bootstrap.min.css"></link>
<link type="text/css" rel="stylesheet" href="${absoluteContextPath}/css/bootstrap-theme.min.css"></link>
<link type="text/css" rel="stylesheet" href="${absoluteContextPath}/css/bootstrap-social.css"></link>
<link href="${absoluteContextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css">

<script src="${absoluteContextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function changeCode() {
        var imgNode = document.getElementById("vimg");
        imgNode.src = "${absoluteContextPath}/util/VCode?t=" + Math.random();
    }
</script>

<h2>Hello World!</h2>


<div class="container">
    <div class="col-md-12">
        <form role="form" action="${absoluteContextPath}/index/sendEmail" method="post">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group" style="margin-left:15%">
                        <div class="col-md-9">
                            <label for="email" class="control-label" style="font-size: larger;">Email</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope"></i>
                                <input type="text" class="form-control" name="email" id="email" placeholder="email">
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="form-group" style="margin-left:15%">
                        <div class="col-md-9">
                            <label for="security" class="control-label" style="font-size: larger;">Security Code</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-edit"></i>
                                <input type="text" class="form-control" id="security" name="security"
                                       placeholder="security code">
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="form-group" style="margin-left:15%">
                        <div class="col-md-9">
                            <label for="pic" class="control-label" style="font-size: larger;">Code Pic</label>
                            <div class="templatemo-input-icon-container">
                                <label class="col-sm-5 control-label">
                                    <img id="vimg" title="点击更换" alt="点击更换" src="${absoluteContextPath}/util/VCode"
                                         onclick="changeCode()"/>
                                </label>
                            </div>
                        </div>
                    </div>

                    <br>
                    <div class="form-group" style="margin-left:15%">
                        <div class="col-md-9">
                            <input type="submit" value="Send Email" class="button button-royal button-pill">
                        </div>
                    </div>

                </div>
            </div>
    </div
</div>
</body>
</html>
