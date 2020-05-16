package ${template.generationPackage};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${config.baseClassPath}.web.core.controller.BaseController;

import ${templates.service.generationClassesPath};
import ${templates.entity.generationClassesPath};

/**
 * Title: ${table.nameLower}  ${table.comment}
 *
 * Company: ${config.company}
 *
 * @author ${config.author}
 * @date ${.now}
 * @version 1.0
 */

@RestController("${table.modelNameFirstLowerCamel}${table.nameFirstUpperCamel}Controller")
@RequestMapping(value = "/api/${table.modelNameFirstLowerCamel}/${table.nameFirstLowerCamel}")
public class ${template.generationClassName} extends
		BaseController<<#list table.pk as column>${column.javaType}</#list>,${templates.entity.generationClassName},${templates.service.generationClassName}> {

}
