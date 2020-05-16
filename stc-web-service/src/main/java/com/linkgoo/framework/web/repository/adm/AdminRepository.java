package com.linkgoo.framework.web.repository.adm;

import org.springframework.stereotype.Repository;
import com.linkgoo.framework.web.core.Repository.BaseRepository;
import com.linkgoo.framework.web.entity.adm.Admin;

/**
 * Title: 管理员
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:04:41
 * @version 1.0
 */

@Repository("admAdminRepository")
public interface AdminRepository extends BaseRepository<Admin> {

}
