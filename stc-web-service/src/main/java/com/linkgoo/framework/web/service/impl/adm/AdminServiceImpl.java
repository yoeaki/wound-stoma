package com.linkgoo.framework.web.service.impl.adm;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkgoo.framework.web.core.service.BaseServiceImpl;
import com.linkgoo.framework.web.entity.adm.Admin;
import com.linkgoo.framework.web.repository.adm.AdminRepository;
import com.linkgoo.framework.web.service.adm.AdminService;


/**
 * Title: 管理员
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:04:42
 * @version 1.0
 */

@Service("admAdminService")
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl extends
		BaseServiceImpl<Long,Admin,AdminRepository> implements
        AdminService{

}
