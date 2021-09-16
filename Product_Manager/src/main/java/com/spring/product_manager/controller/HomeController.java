package com.spring.product_manager.controller;

import com.spring.product_manager.model.Product;
import com.spring.product_manager.model.ProductAddForm;
import com.spring.product_manager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public ModelAndView main(@PageableDefault(page = 0, size = 8)
                                 @SortDefault.SortDefaults({
                                         @SortDefault(sort = "id", direction = Sort.Direction.DESC)
                                 }) Pageable pageable){
        ModelAndView mav = new ModelAndView("index");
        Optional<Page<Product>> page = productService.list(pageable);
        mav.addObject("currentPage", page.get().getNumber());
        mav.addObject("previous", page.get().hasPrevious());
        if (page.get().hasPrevious())
            mav.addObject("previousPage", page.get().getNumber() - 1);
        mav.addObject("next", page.get().hasNext());
        if (page.get().hasNext()) {
            mav.addObject("nextPage", page.get().getNumber() + 1);
        }
        mav.addObject("page",page.get());
        mav.addObject("productAdd",new Product());
        return mav;

    }

    @PostMapping("product/add")
    public String createdNewProduct(@ModelAttribute Product request){
        System.out.println("===========>" + request.getName());
        System.out.println("===========>" + request.getBrand());
        System.out.println("===========>" + request.getMadein());
        System.out.println("===========>" + request.getPrice());
        Product product =  productService.add(request);
        return "redirect:/";
    }

    @GetMapping("product/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/";
    }
}
