/** Oracle */
drop table ${table.shortModelNameLower}_${table.nameLower};
create table ${table.shortModelNameLower}_${table.nameLower} (
	<#list table.pk as column>
	${column.nameLower} ${column.dataType} not null,
	</#list>
	<#list table.plainColumns as column>
	${column.nameLower} ${column.dataType}<#if column_has_next>,</#if>
	</#list>
);
alter table ${table.shortModelNameLower}_${table.nameLower} add constraint ${table.shortModelNameLower}_${table.nameLower}_pk PRIMARY KEY(<#list table.pk as column>${column.nameLower}<#if column_has_next>,</#if></#list>);

<#if (table.pk?size==1)>
	<#list table.pk as column><#if column.javaType=="Long">
drop sequence seq_${table.shortModelNameLower}_${table.nameLower}_id;
create sequence seq_${table.shortModelNameLower}_${table.nameLower}_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
	</#if></#list>
</#if>
-- Add comments to the columns 
<#list table.columns as column>
comment on column ${table.shortModelNameLower}_${table.nameLower}.${column.nameLower} is '${column.comment}';
</#list>
/**
####MYSQL###
drop table if exists ${table.shortModelNameLower}_${table.nameLower};
create table ${table.shortModelNameLower}_${table.nameLower} (
	<#list table.pk as column>
	${column.nameLower} ${column.dataType} not null <#if (table.pk?size==1)><#if column.javaType=="Long">auto_increment</#if></#if> comment '${column.comment}',
	</#list>
	
	<#list table.plainColumns as column>
	${column.nameLower} ${column.dataType} comment '${column.comment}',
	</#list>
	primary key (<#list table.pk as column>${column.nameLower}<#if column_has_next>,</#if></#list>)
) ;

*/
