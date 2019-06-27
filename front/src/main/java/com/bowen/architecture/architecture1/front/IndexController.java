package com.bowen.architecture.architecture1.front;

import com.bowen.architecture.architecture1.goodsmgr.service.IGoodsService;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsModel;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsQueryModel;
import com.bowen.architecture.architecture1.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IGoodsService goodsService = null;

    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String toIndex(Model model) {
        GoodsQueryModel goodsQueryModel = new GoodsQueryModel();
        goodsQueryModel.getPage().setPageShow(100);
        Page<GoodsModel> page = goodsService.getByConditionPage(goodsQueryModel);

        model.addAttribute("page", page);
        return "index";
    }

}
