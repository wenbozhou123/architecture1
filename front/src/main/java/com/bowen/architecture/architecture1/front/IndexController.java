package com.bowen.architecture.architecture1.front;

import com.bowen.architecture.architecture1.cartMgr.service.ICartService;
import com.bowen.architecture.architecture1.cartMgr.vo.CartModel;
import com.bowen.architecture.architecture1.cartMgr.vo.CartQueryModel;
import com.bowen.architecture.architecture1.goodsmgr.service.IGoodsService;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsModel;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsQueryModel;
import com.bowen.architecture.architecture1.orderMgr.service.IOrderDetailService;
import com.bowen.architecture.architecture1.orderMgr.service.IOrderService;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderDetailModel;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderModel;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderQueryModel;
import com.bowen.architecture.architecture1.pageutil.Page;
import com.bowen.architecture.architecture1.storeMgr.service.IStoreService;
import com.bowen.architecture.architecture1.storeMgr.vo.StoreModel;
import com.bowen.architecture.architecture1.util.format.DateFormatHelper;
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
    @Autowired
    private IOrderService orderService = null;
    @Autowired
    private IOrderDetailService orderDetailService = null;
    @Autowired
    private IStoreService storeService = null;

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

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(@CookieValue("MyLogin") String myLogin) {
        int customerUuid = Integer.parseInt(myLogin.split(",")[0]);
        CartQueryModel cqm = new CartQueryModel();
        cqm.getPage().setPageShow(1000);
        cqm.setCustomerUuid(customerUuid);
        Page<CartModel> page = cartService.getByConditionPage(cqm);


        //2.
        float totalMoney = 0.0f;
        for(CartModel cm : page.getResult()){
            totalMoney += 10;
        }
        OrderModel order = new OrderModel();
        order.setCustomerUuid(customerUuid);
        order.setOrderTime(DateFormatHelper.long2str(System.currentTimeMillis()));
        order.setSaveMoney(0.0f);
        order.setTotalMoney(totalMoney);
        order.setState(1);
        orderService.create(order);


        OrderQueryModel oqm = new OrderQueryModel();
        oqm.setOrderTime(order.getOrderTime());
        Page<OrderModel> orderPage = orderService.getByConditionPage(oqm);
        order = orderPage.getResult().get(0);


        //3:
        for(CartModel cm : page.getResult()){
            OrderDetailModel odm = new OrderDetailModel();
            odm.setGoodsUuid(cm.getGoodsUuid());
            odm.setOrderNum(cm.getBuyNum());
            odm.setPrice(10.0f);
            odm.setMoney(odm.getPrice()*odm.getOrderNum());
            odm.setSaveMoney(0.0f);
            odm.setOrderUuid(order.getUuid());
            orderDetailService.create(odm);

            //4:
            StoreModel sm = storeService.getByGoodsUuid(cm.getGoodsUuid());
            sm.setStoreNum(sm.getStoreNum()-odm.getOrderNum());
            storeService.update(sm);

            //5:
            cartService.delete(cm.getUuid());
        }
        return "success";
    }

}
