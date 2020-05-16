package com.linkgoo.framework.web.repository.dis;

import org.springframework.stereotype.Repository;
import com.linkgoo.framework.web.core.Repository.BaseRepository;
import com.linkgoo.framework.web.entity.dis.Disease;

/**
 * Title: 疾病
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:05:10
 * @version 1.0
 */

@Repository("disDiseaseRepository")
public interface DiseaseRepository extends BaseRepository<Disease> {

}
