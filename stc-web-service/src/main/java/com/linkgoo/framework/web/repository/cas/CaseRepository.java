package com.linkgoo.framework.web.repository.cas;

import org.springframework.stereotype.Repository;
import com.linkgoo.framework.web.core.Repository.BaseRepository;
import com.linkgoo.framework.web.entity.cas.Case;

/**
 * Title: 病历
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-16 15:17:37
 * @version 1.0
 */

@Repository("casCaseRepository")
public interface CaseRepository extends BaseRepository<Case> {

}
