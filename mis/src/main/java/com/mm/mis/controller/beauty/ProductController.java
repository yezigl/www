/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.mm.mis.controller.beauty;

import java.util.List;
import java.util.Map;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mm.data.model.beauty.Product;
import com.mm.mis.controller.BaseController;
import com.mm.service.beauty.ProductService;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月29日
 */
@Controller
@RequestMapping("/beauty")
public class ProductController extends BaseController {

    @Resource
    ProductService productService;
    
    @Override
    protected String vmtpl() {
        return "product";
    }

    @Override
    protected String category() {
        return "product";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Model model, @RequestParam(defaultValue = "0") int offset) {
        
        List<Product> products = productService.getAll();
        
        model.addAttribute("products", products);
        
        return vm("products");
    }
    
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public String product(Model model, @PathVariable int productId) {
        
        Product product = productService.get(productId);
        
        model.addAttribute("product", product);
        
        return vm("product");
    }
    
    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String dealAddPGet(Model model) {
        return vm("productadd");
    }
    
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> dealAddPost(@ModelAttribute Product product) {
        ModelAndView mv = new ModelAndView();
        
        if (product.getId() != 0) {
            productService.update(product);
        } else {
            productService.create(product);
        }
        
        mv.addObject("id", product.getId());
        mv.addObject("name", product.getName());
        mv.addObject("imgUrl", product.getImgUrl());
        mv.addObject("code", 200);
        
        return mv.getModel();
    }
    
    @RequestMapping(value = "/products/query", method = RequestMethod.GET)
    @ResponseBody
    public Object productQuery(@RequestParam(defaultValue = "") String pkw) {
        
        ModelAndView mv = new ModelAndView();
        
        List<Product> products = productService.getAll();
        
        mv.addObject("products", products);
        
        return mv.getModel();
    }
}
