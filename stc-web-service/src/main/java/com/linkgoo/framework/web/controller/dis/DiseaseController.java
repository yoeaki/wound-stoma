package com.linkgoo.framework.web.controller.dis;

import com.linkgoo.framework.web.core.response.RestResponse;
import com.linkgoo.framework.web.repository.dis.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.linkgoo.framework.web.core.controller.BaseController;

import com.linkgoo.framework.web.service.dis.DiseaseService;
import com.linkgoo.framework.web.entity.dis.Disease;

/**
 * Title: disease  疾病
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:05:10
 * @version 1.0
 */

@RestController("disDiseaseController")
@RequestMapping(value = "/api/dis/disease")
public class DiseaseController extends
		BaseController<Long,Disease,DiseaseService> {



}
