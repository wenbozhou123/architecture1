package com.bowen.architecture.architecture1.cartMgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bowen.architecture.architecture1.cartMgr.service.ICartService;
import com.bowen.architecture.architecture1.cartMgr.vo.CartModel;
import com.bowen.architecture.architecture1.cartMgr.vo.CartQueryModel;
import com.bowen.architecture.architecture1.pageutil.Page;
import com.bowen.architecture.architecture1.util.format.DateFormatHelper;
import com.bowen.architecture.architecture1.util.json.JsonHelper;

@Controller
@RequestMapping(value="/cart")
public class CartController {
	@Autowired
	private ICartService cartService = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "cart/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") CartModel m){
		cartService.create(m);
		return "cart/success";
	}
	@RequestMapping(value="toUpdate/{uuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("uuid") int uuid){
		CartModel m = cartService.getByUuid(uuid);
		model.addAttribute("m", m);
		return "cart/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String post(@ModelAttribute("m") CartModel m){
		cartService.update(m);
		return "cart/success";
	}
	@RequestMapping(value="toDelete/{uuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("uuid") int uuid){
		CartModel m = cartService.getByUuid(uuid);
		model.addAttribute("m", m);
		return "cart/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("uuid") int uuid){
		cartService.delete(uuid);
		return "cart/success";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")CartWebModel wm,Model model){
		CartQueryModel qm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			qm =  new CartQueryModel();
		}else{
			String s = wm.getQueryJsonStr();
			s = s.replace("-", "%");
			qm = (CartQueryModel)JsonHelper.str2Object(s, CartQueryModel.class);
		}
		
		qm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow() > 0){
			qm.getPage().setPageShow(wm.getPageShow());
		}
		
		Page dbPage = cartService.getByConditionPage(qm);
		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);
				
		return "cart/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "cart/query";
	}	
}
