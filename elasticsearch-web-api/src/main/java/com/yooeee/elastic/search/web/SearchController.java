package com.yooeee.elastic.search.web;

import com.yooeee.elastic.search.SearchShop;
import com.yooeee.elastic.search.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/6.
 */

@RestController
@RequestMapping("")
public class SearchController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private ShopService shopService;



    @RequestMapping(value = "/shops/{keyword}/{lat}/{lon}/",method = RequestMethod.GET)
    public List<Map<String,Object>> shopSearch(@PathVariable("keyword") String keyword, @PathVariable("lat") Double lat
            , @PathVariable("lon") Double lon, HttpServletRequest request){
        SearchShop shop = new SearchShop();
        String page = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        if (page!=null){

            shop.setCurrentPage(Integer.valueOf(page));
        }
        if (pageSize !=null){
            shop.setSize(Integer.valueOf(pageSize));
        }

        shop.setDistance(20000);
        shop.setName(keyword);
        shop.setUnit("km");
        shop.setLatitude(lat);
        shop.setLongitude(lon);
        logger.info(shop.toString());
        return shopService.shopSearch(shop);
    }

}
