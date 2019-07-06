package com.bowen.architecture.architecture1.front;

import com.bowen.architecture.architecture1.cartMgr.service.ICartService;
import com.bowen.architecture.architecture1.cartMgr.vo.CartModel;
import com.bowen.architecture.architecture1.cartMgr.vo.CartQueryModel;
import com.bowen.architecture.architecture1.goodsmgr.service.IGoodsService;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsModel;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsQueryModel;
import com.bowen.architecture.architecture1.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IGoodsService goodsService = null;

    @Autowired
    private ICartService cartService = null;

    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String toIndex(Model model) {
        GoodsQueryModel goodsQueryModel = new GoodsQueryModel();
        goodsQueryModel.getPage().setPageShow(100);
        Page<GoodsModel> page = goodsService.getByConditionPage(goodsQueryModel);

        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/toGoodsDesc/{goodsUuid}", method = RequestMethod.GET)
    public String toGoodsDesc(Model model, @PathVariable("goodsUuid") int goodsUuid) {
       GoodsModel gm = goodsService.getByUuid(goodsUuid);
       model.addAttribute("m", gm);
        return "goods/desc";
    }

    @RequestMapping(value = "/addToCart/{goodsUuid}", method = RequestMethod.GET)
    public String addToCart(Model model, @PathVariable("goodsUuid") int goodsUuid, @CookieValue("MyLogin") String myLogin) {
        int customerUuid = Integer.parseInt(myLogin.split(",")[0]);
        CartModel cm = new CartModel();
        cm.setCustomerUuid(customerUuid);
        cm.setGoodsUuid(goodsUuid);
        cm.setBuyNum(1);
        cartService.create(cm);

        CartQueryModel cqm = new CartQueryModel();
        cqm.getPage().setPageShow(1000);
        cqm.setCustomerUuid(customerUuid);
        Page<CartModel> page = cartService.getByConditionPage(cqm);
        model.addAttribute("page", page);
        return "cart/myCart";
    }

    @RequestMapping(value = "/toCart", method = RequestMethod.GET)
    public String toCart(Model model, @CookieValue("MyLogin") String myLogin) {
        int customerUuid = Integer.parseInt(myLogin.split(",")[0]);
        CartQueryModel cqm = new CartQueryModel();
        cqm.getPage().setPageShow(1000);
        cqm.setCustomerUuid(customerUuid);
        Page<CartModel> page = cartService.getByConditionPage(cqm);
        model.addAttribute("page", page);
        return "cart/myCart";
    }

}
