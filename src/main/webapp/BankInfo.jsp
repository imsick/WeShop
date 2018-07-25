
<!DOCTYPE html>

<html lang="Chinese">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src = "http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script>
    $(document).ready(function(){
    $.ajax(
        {
            url: "/bank",

            type: "GET",

            success: function (data) {
                //前端调用成功后，  可以处理后端传回的json格式数据。
                var x= "<table class='table table-bordered'>" +
                    "                    <thead>" +
                    "                <tr>" +
                    "                    <th>UserId</th>" +
                    "                    <th>Money</th>" +
                    "                </tr>" +
                    "                </thead>" +
                    "                <tbody>"
                for(var key in data)
                {
                    x=x+"<tr>";

                    x=x+"<td>"+key+"</td>";
                    x=x+"<td>"+data[key]+"</td>";
                    x=x+"</tr>";
                }
                x=x+"</tbody>";
                $("#1").html(x);

            }
        });
    });
</script>
<body>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">

</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">

        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

            <h2>BankInfo</h2>
            <form action="/addBankAccout">
                User_id:<br>
                <input type="text" name="user_id" >
                <br>
                money:<br>
                <input type="text" name="money" >
                <br><br>
                <input type="submit" value="Submit">
                <br><br>
            </form>
            <div class="table-responsive" style="padding-right: 200px">
                <table class="table table-striped table-sm" id="1">


                </table>
            </div>
        </main>
    </div>
</div>

<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>


<!-- Graphs -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>

</body>
</html>