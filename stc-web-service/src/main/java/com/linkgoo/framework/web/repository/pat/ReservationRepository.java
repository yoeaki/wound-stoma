package com.linkgoo.framework.web.repository.pat;

import org.springframework.stereotype.Repository;
import com.linkgoo.framework.web.core.Repository.BaseRepository;
import com.linkgoo.framework.web.entity.pat.Reservation;

/**
 * Title: 预约信息
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-11 21:54:57
 * @version 1.0
 */

@Repository("patReservationRepository")
public interface ReservationRepository extends BaseRepository<Reservation> {

}
