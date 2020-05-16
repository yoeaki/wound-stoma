package ${template.generationPackage};

import org.springframework.stereotype.Repository;
import ${config.baseClassPath}.web.core.Repository.BaseRepository;
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

@Repository("${table.modelNameFirstLowerCamel}${table.nameFirstUpperCamel}Repository")
public interface ${template.generationClassName} extends BaseRepository<${templates.entity.generationClassName}> {

}
