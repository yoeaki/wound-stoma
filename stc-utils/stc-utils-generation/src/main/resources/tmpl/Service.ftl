package ${template.generationPackage};

import ${config.baseClassPath}.web.core.service.BaseService;

import ${templates.entity.generationClassesPath};


/**
 * Title: ${table.comment}
 *
 * Company: ${config.company}
 *
 * @author ${config.author}
 * @date ${.now}
 * @version 1.0
 */

public interface ${template.generationClassName} extends
		BaseService<<#list table.pk as column>${column.javaType}</#list>,${templates.entity.generationClassName}>{

}
