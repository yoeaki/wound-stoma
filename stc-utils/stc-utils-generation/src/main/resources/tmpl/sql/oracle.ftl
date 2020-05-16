--start
drop table ${table.fullName};
create table ${table.fullName} (
	<#list table.pk as column>
	${column.nameLower} ${column.dbType} not null,
	</#list>
	<#list table.plainColumns as column>
	${column.nameLower} ${column.dbType}<#if column_has_next>,</#if>
	</#list>
);
alter table ${table.fullName} add constraint ${table.fullName}_pk PRIMARY KEY(<#list table.pk as column>${column.nameLower}<#if column_has_next>,</#if></#list>);
<#if (table.pk?size==1)>
	<#list table.pk as column><#if column.javaType=="Long" || column.javaType=="Integer">
drop sequence seq_${table.fullName}_id;
create sequence seq_${table.fullName}_id minvalue 1 maxvalue 999999999999999999999999999 start with 1 increment by 1 nocache;
	</#if></#list>
</#if>
-- Add comments to the columns
<#list table.columns as column>
comment on column ${table.fullName}.${column.nameLower} is '${column.comment}';
</#list>
--end
