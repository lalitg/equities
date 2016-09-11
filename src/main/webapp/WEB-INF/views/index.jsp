<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>JQuery Simple Table Plugin Basic Demo</title>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
    <spring:url value="/resources/jquery.simpletable.js" var="simpleTableJs" />
	<spring:url value="/resources/table.js" var="tableJs" />
    
 <script src="${simpleTableJs}"></script>
    <script src="${tableJs}"></script>
   
   <style>
   body { background-color:#fafafa; font-family:'Roboto';}
   .container { margin:150px auto;}
   </style>
  </head>

  <body><div id="jquery-script-menu">
<div class="jquery-script-center">
<div class="jquery-script-ads"><script type="text/javascript"><!--
google_ad_client = "ca-pub-2783044520727903";
/* jQuery_demo */
google_ad_slot = "2780937993";
google_ad_width = 728;
google_ad_height = 90;
//-->
</script>
</div>
<div class="jquery-script-clear"></div>
</div>
</div>
  <div class="container">
  <h1>Portfolio</h1>
  <table class="table table-bordered table-striped table-fixed" id='list_badges'>
    <thead>
      <tr>
        <th class="text-center" id="companyName" type="text" prime="true" static="true">company</th>
        <th class="text-center" id="investmentPrice" type="text">Investment price</th>
        <th class="text-center" id="livePrice" type="text">Live price</th>
        <th class="text-center" id="quantity" type="text">Quantity</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    </tbody>
  </table></div>
 </body><script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</html>
