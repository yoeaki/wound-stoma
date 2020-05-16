package com.linkgoo.framework.web.service.impl.dis;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkgoo.framework.web.core.service.BaseServiceImpl;
import com.linkgoo.framework.web.entity.dis.Disease;
import com.linkgoo.framework.web.repository.dis.DiseaseRepository;
import com.linkgoo.framework.web.service.dis.DiseaseService;


/**
 * Title: 疾病
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:05:10
 * @version 1.0
 */

@Service("disDiseaseService")
@Transactional(rollbackFor = Exception.class)
public class DiseaseServiceImpl extends
		BaseServiceImpl<Long,Disease,DiseaseRepository> implements
        DiseaseService{

}
