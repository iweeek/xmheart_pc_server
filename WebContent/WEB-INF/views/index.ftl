<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">  
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="renderer" content="webkit">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="./css/reset.css">
		<link rel="stylesheet" href="./css/swiper-3.4.2.min.css">
		<link rel="stylesheet" href="./css/layout.css">
		<link rel="stylesheet" href="./css/index.css">
		<link rel="stylesheet" href="./css/common.css">
	</head>
   <body>
     <#include "./fragments/_header.ftl"> 
     <#--<h3>Person List</h3>
     <a href="addPerson">Add Person</a>
     <br><br>
      <div>
         <table border="1">
            <tr>
               <th>First Name</th>
               <th>Last Name</th>
            </tr>
            <#list persons as person>
            <tr>
               <td>${person.firstName}</td>
               <td>${person.lastName}</td>
            </tr>
            </#list>
         </table>
      </div>-->
      <#include "./fragments/_footer.ftl">
   </body>
</html>