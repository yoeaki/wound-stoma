package ${template.generationPackage};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${config.baseClassPath}.web.core.service.BaseServiceImpl;
import ${templates.entity.generationClassesPath};
import ${templates.repository.generationClassesPath};
import ${templates.service.generationClassesPath};


/**
 * Title: ${table.comment}
 *
 * Company: ${config.company}
 *
 * @author ${config.author}
 * @date ${.now}
 * @version 1.0
 */

@Service("${table.modelNameFirstLowerCamel}${table.nameFirstUpperCamel}Service")
@Transactional(rollbackFor = Exception.class)
public class ${template.generationClassName} extends
		BaseServiceImpl<<#list table.pk as column>${column.javaType}</#list>,${templates.entity.generationClassName},${templates.repository.generationClassName}> implements
        ${templates.service.generationClassName}{

}
