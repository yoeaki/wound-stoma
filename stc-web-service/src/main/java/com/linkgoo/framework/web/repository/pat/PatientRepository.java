package com.linkgoo.framework.web.repository.pat;

import org.springframework.stereotype.Repository;
import com.linkgoo.framework.web.core.Repository.BaseRepository;
import com.linkgoo.framework.web.entity.pat.Patient;

/**
 * Title: 病人
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:02:27
 * @version 1.0
 */

@Repository("patPatientRepository")
public interface PatientRepository extends BaseRepository<Patient> {

}
