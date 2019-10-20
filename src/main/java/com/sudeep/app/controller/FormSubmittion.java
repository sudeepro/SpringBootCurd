package com.sudeep.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sudeep.app.constant.AppConstant;
import com.sudeep.app.entity.RegisterEntity;
import com.sudeep.app.model.FormRegister;
import com.sudeep.app.properties.PropertiesCache;
import com.sudeep.app.repository.RegisterDao;



/**
 * 
 * @author Sudeep FormSubmittion controller
 */
@Controller
public class FormSubmittion {

	/**
	 * RegisterDao
	 */
	@Autowired
	private RegisterDao dao;
	/**
	 * PropertiesCache
	 */
	@Autowired
	private PropertiesCache props;

	/**
	 * 
	 * @param map
	 * @return String load the form
	 */
	@RequestMapping(value = "/get")
	public String getForm(Map<String, Object> map) {
		map.put(AppConstant.FORM_SUBMIT, new FormRegister());
		loadFormData(map);
		return props.getMap().get("form");
	}

	/**
	 * 
	 * @param map load country details
	 */
	private void loadFormData(Map<String, Object> map) {
		List<String> list = new ArrayList();
		list.add("India");
		list.add("Usa");
		list.add("Japan");
		list.add("Aus");
		list.add("England");
		map.put(AppConstant.FORM_COUNTRY, list);
	}

	/**
	 * 
	 * @param map
	 * @param form
	 * @return String save the data
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String save(Map<String, Object> map, @ModelAttribute("user") FormRegister form,RedirectAttributes redirectAttributes) {
		RegisterEntity rs = null;
		rs = new RegisterEntity();
		BeanUtils.copyProperties(form, rs);
		RegisterEntity rs1 = dao.save(rs);
//		map.put(AppConstant.FORM_MSG, rs1.getUserId() == null ? props.getMap().get("ns") : props.getMap().get("s"));
		redirectAttributes.addFlashAttribute(AppConstant.FORM_MSG, rs1.getUserId() == null ? props.getMap().get("ns") : props.getMap().get("s"));
//		return props.getMap().get("form");
		return "redirect:result";
	}
	
	/**
	 * 
	 * @param map
	 * @return String load the form
	 */
	@RequestMapping(value = "/result")
	public String redirect(Map<String, Object> map) {
		map.put(AppConstant.FORM_SUBMIT, new FormRegister());
		loadFormData(map);
		return props.getMap().get("form");
	}
	
	

	/**
	 * 
	 * @param map
	 * @param form
	 * @return String save the data
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String update(Map<String, Object> map, @ModelAttribute("user") FormRegister form,
			@RequestParam("uid") Integer no) {
		RegisterEntity rs = null;
		rs = new RegisterEntity();
		BeanUtils.copyProperties(form, rs);
		rs.setUserId(no);
		RegisterEntity rs1 = dao.save(rs);
		
		map.put(AppConstant.FORM_MSG, rs1.getUserId() == null ? props.getMap().get("uns") : props.getMap().get("us"));
		return "redirect:viewUser?pid=" + 1;
	}

	/**
	 * 
	 * @param map
	 * @param form
	 * @return String view User
	 */
	@RequestMapping(value = "/viewUser1")
	public String viewUser1(Map<String, Object> map) {
		List<FormRegister> list = new ArrayList();
		Iterable<RegisterEntity> it = dao.findAll();
		FormRegister fr = null;
		for (RegisterEntity l : it) {
			fr = new FormRegister();
			BeanUtils.copyProperties(l, fr);
			list.add(fr);
		}
		map.put(AppConstant.FORM_VIEW, list);
		return props.getMap().get("display");
	}

	/**
	 * 
	 * @param map
	 * @param form
	 * @return String view User
	 */
	@RequestMapping(value = "/viewUser")
	public String viewUser2(Map<String, Object> map, @RequestParam("pid") Integer cp) {
		int pageSize = 3;
		Pageable pageable = PageRequest.of(cp - 1, pageSize);
		List<FormRegister> list = new ArrayList();
		Page<RegisterEntity> page = dao.findAll(pageable);
		int ps = page.getTotalPages();
		FormRegister fr = null;
		for (RegisterEntity l : page) {
			fr = new FormRegister();
			BeanUtils.copyProperties(l, fr);
			list.add(fr);
		}
		map.put(AppConstant.CURRENT_PAGE, cp);
		map.put(AppConstant.PAGE_SIZE, ps);
		map.put(AppConstant.FORM_VIEW, list);
		return props.getMap().get("display");
	}

	/**
	 * 
	 * @param map
	 * @param form
	 * @return String view User
	 */
	@RequestMapping(value = "/update")
	public String update(Map<String, Object> map, @RequestParam("uid") Integer uid) {
		RegisterEntity user = dao.getOne(uid);
		FormRegister fr = new FormRegister();
		BeanUtils.copyProperties(user, fr);
		loadFormData(map);
		map.put("v",fr.getUserId());
		map.put(AppConstant.UPDATE_VIEW, fr);
		return props.getMap().get("up");

	}

	@RequestMapping(value = "/delete")
	public String viewDelete(@RequestParam("uid") Integer uid) {
		dao.deleteById(uid);
		return "redirect:viewUser?pid=" + 1;
	}

}
