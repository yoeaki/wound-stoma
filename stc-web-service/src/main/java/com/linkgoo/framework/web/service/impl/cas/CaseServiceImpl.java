package com.linkgoo.framework.web.service.impl.cas;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkgoo.framework.web.core.service.BaseServiceImpl;
import com.linkgoo.framework.web.entity.cas.Case;
import com.linkgoo.framework.web.repository.cas.CaseRepository;
import com.linkgoo.framework.web.service.cas.CaseService;


/**
 * Title: 病历
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:01:45
 * @version 1.0
 */

@Service("casCaseService")
@Transactional(rollbackFor = Exception.class)
public class CaseServiceImpl extends
		BaseServiceImpl<Long,Case,CaseRepository> implements
        CaseService{

}
