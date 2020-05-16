package ${template.generationPackage};


/**
 * Title: ${table.comment}
 *
 * Company: ${config.company}
 *
 * @author ${config.author}
 * @date ${.now}
 * @version 1.0
 */

@SuppressWarnings("serial")
public class ${template.generationClassName} implements java.io.Serializable{

	/** pk，逗号分隔 */
	private String pks;
	<#if (table.pk?size>1)>
	public static class ${table.nameFirstUpperCamel}PK implements java.io.Serializable{
		<#list table.pk as column>
		/** ${column.comment} */
		<#if column.javaType=="java.util.Date">
		@org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
		</#if>
		private ${column.javaType} ${column.nameFirstLowerCamel};
		</#list>

		<#list table.pk as column>
		/** ${column.comment} */
		public ${column.javaType} get${column.nameFirstUpperCamel}() {
			return ${column.nameFirstLowerCamel};
		}
		/** ${column.comment} */
		public void set${column.nameFirstUpperCamel}(${column.javaType} ${column.nameFirstLowerCamel}) {
			this.${column.nameFirstLowerCamel}=${column.nameFirstLowerCamel};
		}
		</#list>
	}
	private ${table.nameFirstUpperCamel}PK pk=new ${table.nameFirstUpperCamel}PK();

	<#list table.pk as column>
	/** ${column.comment} */
	public ${column.javaType} get${column.nameFirstUpperCamel}() {
		return ${column.nameFirstLowerCamel};
	}
	/** ${column.comment} */
	public void set${column.nameFirstUpperCamel}(${column.javaType} ${column.nameFirstLowerCamel}) {
		this.${column.nameFirstLowerCamel}=${column.nameFirstLowerCamel};
	}
	</#list>
	</#if>

	<#if (table.pk?size>1)>
		<#assign fields=table.plainColumns>
	<#else>
		<#assign fields=table.columns>
	</#if>
	<#list fields as column>
	/** ${column.comment} */
	<#if column.javaType=="java.util.Date">
	@org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date ${column.nameFirstLowerCamel};
	<#elseif (column.notes)??&&column.notes?index_of("文件")!=-1>
	private com.linkgoo.framework.mybatis.type.FileType ${column.nameFirstLower};
	<#else>
	private ${column.javaType} ${column.nameFirstLowerCamel};
	</#if>
	</#list>

	<#list fields as column>
	/** ${column.comment} */
	<#if column.javaType=="java.util.Date">
	public java.util.Date get${column.nameFirstUpperCamel}() {
		return ${column.nameFirstLowerCamel};
	}
	/** ${column.comment} */
	public void set${column.nameFirstUpperCamel}(java.util.Date ${column.nameFirstLowerCamel}) {
		this.${column.nameFirstLowerCamel}=${column.nameFirstLowerCamel};
	}
	<#--<#elseif (column.notes)??&&column.notes?index_of("文件")!=-1>-->
	<#--public com.linkgoo.framework.mybatis.type.FileType ${column.getmethod}() {-->
		<#--return ${column.nameFirstLower};-->
	<#--}-->
	<#--/** ${column.comment} */-->
	<#--public void ${column.setmethod}(com.linkgoo.framework.mybatis.type.FileType ${column.nameFirstLower}) {-->
		<#--this.${column.nameFirstLower}=${column.nameFirstLower};-->
	<#--}-->
	<#else>
	public ${column.javaType} get${column.nameFirstUpperCamel}() {
		return ${column.nameFirstLowerCamel};
	}
	/** ${column.comment} */
	public void set${column.nameFirstUpperCamel}(${column.javaType} ${column.nameFirstLowerCamel}) {
		this.${column.nameFirstLowerCamel}=${column.nameFirstLowerCamel};
	}
	</#if>
	</#list>
	/** pk */
	public String getPks() {
		return pks;
	}
	/** pk */
	public void setPks(String pks) {
		this.pks = pks;
	}
}
