package com.peaksoft.springboot_security.controller;


import com.peaksoft.springboot_security.entity.Product;
import com.peaksoft.springboot_security.repository.ProductRepository;
import com.peaksoft.springboot_security.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
//@ComponentScan("com.peaksoft.springboot_security")
public class ProductController {

    private final ProductService productService;

    @RequestMapping
    public String viewHomePage(Model model){
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        return "product_page";
    }

    @RequestMapping("/new")
    public  String showPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product")Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView updateProduct(@PathVariable(name = "id") long id){
        ModelAndView view = new ModelAndView("edit_product");
        Product product = productService.getById(id);
        view.addObject("product", product);
        return view;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/test")
    public String get(){
        return "test";
    }
}
