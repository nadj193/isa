<!doctype html>
<html>
<head>
<title>Determine Click Position on click of a table cell</title>
<!--CSS -->
<style>
    td{
        color: black;
			font-size: 7pt;
 			width: 50px;
 			height: 30px;
 			border: 2px solid #000;
 			margin: 0;
 			padding: 3px;
 			background-color:white; 
        text-align:center;
    }
 
    td:hover{
        background: -moz-linear-gradient(top, #249ee4, #057cc0);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#249ee4), to(#057cc0));
    }
 
    td:active
    {
        background: -moz-linear-gradient(top, #057cc0, #249ee4);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#057cc0), to(#249ee4));
    }
 
    #result{
        font-weight:bold;
        font-size:16pt;
    }
</style>
<!--JAVASCRIPT -->
<script  src="http://code.jquery.com/jquery-1.9.1.min.js" ></script>     
<script>
    $(document).ready(function(){
        $("#myTable td").click(function() {     
 
            var column_num = parseInt( $(this).index() ) + 1;
            var row_num = parseInt( $(this).parent().index() )+1;    
 
            $("#result").html( "Row_num =" + row_num + "  ,  Rolumn_num ="+ column_num );
            window.location.href = "./AddRestoranTableController?row=" +  row_num + "&column=" + column_num;
        });
    });
</script>
</head>
<body>
    <div id="result"> </div>
    <table id="myTable" border="1" style="border-collapse: collapse;" cellpadding="8">
        <!--1st ROW-->
        <tr>
            <td>row 1, col 1</td>
            <td>row 1, col 2</td>
            <td>row 1, col 3</td>
            <td>row 1, col 4</td>
            <td>row 1, col 5</td>
        </tr>
 
        <!--2nd ROW-->
        <tr>
            <td>row 2, col 1</td>
            <td>row 2, col 2</td>
            <td>row 2, col 3</td>
            <td>row 2, col 4</td>
            <td>row 2, col 5</td>
        </tr>
 
        <!--3rd ROW-->
        <tr>
            <td>row 3, col 1</td>
            <td>row 3, col 2</td>
            <td>row 3, col 3</td>
            <td>row 3, col 4</td>
            <td>row 3, col 5</td>
        </tr>
 
        <!--4th ROW-->
        <tr>
            <td>row 4, col 1</td>
            <td>row 4, col 2</td>
            <td>row 4, col 3</td>
            <td>row 4, col 4</td>
            <td>row 4, col 5</td>
        </tr>
 
        <!--5th ROW-->
        <tr>
            <td>row 5, col 1</td>
            <td>row 5, col 2</td>
            <td>row 5, col 3</td>
            <td>row 5, col 4</td>
            <td>row 5, col 5</td>
        </tr>
    </table>
</body>
</html>