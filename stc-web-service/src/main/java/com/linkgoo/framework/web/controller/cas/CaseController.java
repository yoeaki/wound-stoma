package com.linkgoo.framework.web.controller.cas;

import com.linkgoo.framework.web.core.response.RestResponse;
import com.linkgoo.framework.web.entity.dis.Disease;
import com.linkgoo.framework.web.repository.cas.CaseRepository;
import com.linkgoo.framework.web.repository.dis.DiseaseRepository;
import com.linkgoo.framework.web.service.dis.DiseaseService;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import com.linkgoo.framework.web.core.controller.BaseController;

import com.linkgoo.framework.web.service.cas.CaseService;
import com.linkgoo.framework.web.entity.cas.Case;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;

/**
 * Title: case  病历
 *
 * Company: yuanxilong
 *
 * @author yoeaki
 * @date 2020-5-10 13:01:45
 * @version 1.0
 */

@RestController("casCaseController")
@RequestMapping(value = "/api/cas/case")
public class CaseController extends
		BaseController<Long,Case,CaseService> {
	private static final String pathRoot = "D:\\woundStoma\\imges";

	@Autowired
	CaseService caseService;
	@Autowired
	DiseaseService diseaseService;
	@Autowired
	CaseRepository caseRepository;

	@PutMapping("update")
	public RestResponse updatecc(@RequestBody Case aCase){

		int update = caseRepository.update(aCase);
		return update > 0 ? RestResponse.success("修改成功"):RestResponse.fail("修改失败");
	}

	@RequestMapping(value = "/upload", method = {RequestMethod.POST})
	public RestResponse upload(@RequestParam("file") MultipartFile file,  HttpServletRequest request) {
		try {
			uploadFile(file);
			System.out.println("upload end = " + System.currentTimeMillis());
			String filename = file.getOriginalFilename();
			System.out.println(filename);
			return RestResponse.success("上传成功",filename);
		} catch (Exception var3) {
			return RestResponse.fail(var3.getMessage());
		}
	}
	public String uploadFile(MultipartFile file) throws Exception {
		String shortPath =  file.getOriginalFilename();
		File dest = new File(pathRoot, shortPath);
		String savePath = pathRoot + File.separator + shortPath;
		if (!dest.getParentFile().exists()) {
			boolean rel = dest.getParentFile().mkdirs();
			if (!rel) {
				throw new Exception("文件夹创建失败");
			}
		}
		InputStream is = file.getInputStream();
		OutputStream os = new FileOutputStream(dest);
		try {
			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
		return savePath;
	}

	/**
	 * http://localhost:8080/file/download?fileName=新建文本文档.txt
	 * @param
	 * @param response
	 * @param request
	 * @return
	 */
	@GetMapping("/download/{id}")
	public Object downloadFile(@PathVariable("id") long id, HttpServletResponse response, HttpServletRequest request){
		Case aCase = caseService.get(id);
		String fileName = aCase.getCasePic();
		OutputStream os = null;
		InputStream is= null;
		try {
			// 取得输出流
			os = response.getOutputStream();
			// 清空输出流
			response.reset();
			response.setContentType("application/x-download;charset=GBK");
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("utf-8"), "iso-8859-1"));
			//读取流
			File f = new File(pathRoot + fileName);
			is = new FileInputStream(f);
			if (is == null) {
				return RestResponse.fail("下载附件失败，请检查文件“" + fileName + "”是否存在");
			}
			//复制
			IOUtils.copy(is, response.getOutputStream());
			response.getOutputStream().flush();
		} catch (IOException e) {
			return RestResponse.fail("下载附件失败,error:"+e.getMessage());
		}
		//文件的关闭放在finally中
		finally
		{
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@PutMapping("/casePic")
	public RestResponse casePic(@RequestBody Case aCase){
		Case res = caseService.get(aCase.getId());
		if (res == null) {
			return RestResponse.fail("订单不存在");
		}
		res.setCasePic(aCase.getCasePic());
		int update = caseService.update(res);
		return RestResponse.success(update);
	}

	@GetMapping("count")
	public RestResponse count(){
		int i = caseRepository.caseCount();
		System.out.println("总数：" + i);
		return RestResponse.success(i);
	}
}
