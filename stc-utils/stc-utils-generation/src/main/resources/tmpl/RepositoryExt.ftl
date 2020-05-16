package ${template.generationPackage};

import org.springframework.stereotype.Repository;

/**
 * Title: ${table.comment}
 *
 * Company: ${config.company}
 *
 * @author ${config.author}
 * @date ${.now}
 * @version 1.0
 */

@Repository("${table.modelNameFirstLowerCamel}${table.nameFirstUpperCamel}RepositoryExt")
public interface ${template.generationClassName} {

}
