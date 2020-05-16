package com.linkgoo.framework.web.service.impl.pat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkgoo.framework.web.core.service.BaseServiceImpl;
import com.linkgoo.framework.web.entity.pat.Reservation;
import com.linkgoo.framework.web.repository.pat.ReservationRepository;
import com.linkgoo.framework.web.service.pat.ReservationService;


/**
 * Title: 预约信息
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 23:27:39
 * @version 1.0
 */

@Service("patReservationService")
@Transactional(rollbackFor = Exception.class)
public class ReservationServiceImpl extends
		BaseServiceImpl<Long,Reservation,ReservationRepository> implements
        ReservationService{

}
