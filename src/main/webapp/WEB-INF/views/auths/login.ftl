<@form action="authenticate" method="post">
	Login: <input type="text" name="uname" value="${(flasher.param.uname)!}"/>
	Password: <input type="password" name="password" value="${(flasher.param.password)!}"/>
	<input type="submit">
</@form>