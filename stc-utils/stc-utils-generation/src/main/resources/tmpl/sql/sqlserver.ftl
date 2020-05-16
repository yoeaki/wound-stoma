--start
if exists (select 1
            from  sysobjects
           where  id = object_id('${table.fullName}')
            and   type = 'U')
   drop table ${table.fullName}
go
create table ${table.fullName} (
	<#list table.pk as column>
	${column.nameLower} ${column.dbType} not null <#if (table.pk?size==1)><#if column.javaType=="Long" || column.javaType=="Integer">IDENTITY(1,1)</#if></#if>  ,
	</#list>
	<#list table.plainColumns as column>
	${column.nameLower}  <#if column.dbType=='date'>datetime <#else> ${column.dbType}</#if> ,
	</#list>
	primary key (<#list table.pk as column>${column.nameLower}<#if column_has_next>,</#if></#list>)
);

-- Add comments to the columns
<#list table.columns as column>
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'${column.comment}' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'${table.fullName}', @level2type=N'COLUMN',@level2name=N'${column.nameLower}';
</#list>
--end
<#---- Add translation-->
<#--insert into sys_international(code, lang, content, create_time, creator, update_time, updator)-->
<#--values('${table.nameFirstLower}','zh_CN','${table.comment}',getdate(),1, getdate(), 1);-->

<#--<#list table.columns as column>-->
<#--insert into sys_international(code, lang, content, create_time, creator, update_time, updator)-->
<#--values('${column.nameFirstLower}','zh_CN','${column.comment}',getdate(),1, getdate(), 1);-->
<#--</#list>-->
