package com.linkgoo.framework.web.repository.doc;

import org.springframework.stereotype.Repository;
import com.linkgoo.framework.web.core.Repository.BaseRepository;
import com.linkgoo.framework.web.entity.doc.Doctor;

/**
 * Title: 医师
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:11:02
 * @version 1.0
 */

@Repository("docDoctorRepository")
public interface DoctorRepository extends BaseRepository<Doctor> {

}
