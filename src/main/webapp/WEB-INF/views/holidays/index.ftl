 <@content for="title">Holidays List</@content>


<div class="message"><@flash name="message"/></div>



<@link_to action="new_form">Add new holiday</@link_to>

<table>
    <tr>
      <th>user_id</th>
      <th>from_date</th>
      <th>to_date</th>
      <th>status</th>
      <th>category</th>
    </tr>
<#list holidays as hd>
    <tr>
        <td>${hd.user_id!-1}</td>
        <td>${hd.from_date}</td>
        <td>${hd.to_date}</td>
        <td>${hd.step}</td>
        <td>${hd.category}</td>
        <td>
            <@link_to action="show" id=hd.id>Show</@link_to>|
            <@confirm text="Are you sure you want to delete this holiday: ?" form=hd.id>Delete</@confirm>
            <@form  id=hd.id action="delete" method="delete" html_id=hd.id />
            |<@link_to action="toRequested" id=hd.id method="get">To Requested</@link_to>
        </td>
        <td>${hd}</td>
    </tr>
</#list>
</table>




