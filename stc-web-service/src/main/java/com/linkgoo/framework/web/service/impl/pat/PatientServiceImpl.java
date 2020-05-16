package com.linkgoo.framework.web.service.impl.pat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkgoo.framework.web.core.service.BaseServiceImpl;
import com.linkgoo.framework.web.entity.pat.Patient;
import com.linkgoo.framework.web.repository.pat.PatientRepository;
import com.linkgoo.framework.web.service.pat.PatientService;


/**
 * Title: 病人
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:02:27
 * @version 1.0
 */

@Service("patPatientService")
@Transactional(rollbackFor = Exception.class)
public class PatientServiceImpl extends
		BaseServiceImpl<Long,Patient,PatientRepository> implements
        PatientService{

}
