package com.linkgoo.framework.web.service.impl.doc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkgoo.framework.web.core.service.BaseServiceImpl;
import com.linkgoo.framework.web.entity.doc.Doctor;
import com.linkgoo.framework.web.repository.doc.DoctorRepository;
import com.linkgoo.framework.web.service.doc.DoctorService;


/**
 * Title: 医师
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:11:02
 * @version 1.0
 */

@Service("docDoctorService")
@Transactional(rollbackFor = Exception.class)
public class DoctorServiceImpl extends
		BaseServiceImpl<Long,Doctor,DoctorRepository> implements
        DoctorService{

}
