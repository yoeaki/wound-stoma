${table.nameLower}.title=${table.localeComment}
<#list table.columns as column>
${table.nameLower}.${column.nameLower}=${column.localeComment}
</#list>