package com.symplifica.test.controller;

import com.symplifica.test.service.OrderService;
import com.symplifica.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("list", productService.getAllProducts());
        model.addAttribute("order", orderService.getAllOrders());
        return "index";
    }
}
