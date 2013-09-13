<@content for="title">Add new holiday</@content>

<span class="error_message"><@flash name="message"/></span>
<h2>Adding new oliday</h2>


<@form action="create" method="post">
    <table style="margin:30px">
        <tr>
            <td>From:</td>
            <td><input type="text" name="from_date" value="${(flasher.params.from_date)!}"> *
                            <span class="error">${(flasher.errors.from_date)!}</span>
            </td>
        </tr>
        <tr>
            <td>To:</td>
            <td><input type="text" name="to_date" value="${(flasher.params.to_date)!}"> *
                            <span class="error">${(flasher.errors.to_date)!}</span>
            </td>
        </tr>
        <tr>
            <td>status:</td>
            <td><input type="text" name="status" value="${(flasher.params.status)!}"> *
                <span class="error">${(flasher.errors.status)!}</span>
            </td>
        </tr>
        <tr>
            <td>category:</td>
            <td><input type="text" name="category" value="${(flasher.params.category)!}"> *
                <span class="error">${(flasher.errors.category)!}</span>
            </td>
        </tr>
        <tr>
            <td>comment:</td>
            <td><textarea name="comment" >${(flasher.params.comment)!}</textarea>
                <span class="error">${(flasher.errors.comment)!}</span>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><@link_to>Cancel</@link_to> | <input type="submit" value="Add new holiday"></td>

        </tr>
    </table>
</@form>



