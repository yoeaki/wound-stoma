--start
drop table if exists ${table.fullName};
create table ${table.fullName} (
	<#list table.pk as column>
	${column.nameLower} ${column.dbType} not null <#if (table.pk?size==1)><#if column.javaType=="Long" || column.javaType=="Integer">auto_increment</#if></#if> comment '${column.comment}',
	</#list>
	<#list table.plainColumns as column>
	${column.nameLower} ${column.dbType} comment '${column.comment}',
	</#list>
	primary key (<#list table.pk as column>${column.nameLower}<#if column_has_next>,</#if></#list>)
);
--end
