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
