insert into users values(0, 'admin', 'admin', 'Administrator',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() );
insert into users values(1, 'otakacs', 'x', 'TAKACS, Otto',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() );
insert into users values(2, 'eric', 'x', 'Eric Polk',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() );

insert into holidays values(1, 0, parsedatetime('2013-01-01','yyyy-mm-dd'), parsedatetime('2013-01-01','yyyy-mm-dd') , 'requested', 'cat', 'comment');
insert into holidays values(2, 0, parsedatetime('2013-02-01','yyyy-mm-dd'), parsedatetime('2013-02-10','yyyy-mm-dd') , 'requested', 'cat', 'comment');
insert into holidays values(3, 1, parsedatetime('2013-01-01','yyyy-mm-dd'), parsedatetime('2013-01-01','yyyy-mm-dd') , 'requested', 'cat', 'comment');
insert into holidays values(4, 1, parsedatetime('2012-01-01','yyyy-mm-dd'), parsedatetime('2012-01-01','yyyy-mm-dd') , 'requested', 'cat', 'comment');
insert into holidays values(5, 1, parsedatetime('2011-01-01','yyyy-mm-dd'), parsedatetime('2011-01-01','yyyy-mm-dd') , 'requested', 'cat', 'comment');
insert into holidays values(6, 2, parsedatetime('2013-01-01','yyyy-mm-dd'), parsedatetime('2013-01-01','yyyy-mm-dd') , 'requested', 'cat', 'comment');
