package com.spring.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import com.spring.helloworld.model.Phim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("film")
public class PhimController {
    @GetMapping("")
    public String show(Model model){
        List<Phim> phimList = new ArrayList<>();
        phimList.add(new Phim("Bố già", "Trấn Thành, Vũ Ngọc Đãng", "Hài/Chính kịch",  2021));
        phimList.add(new Phim("Hai Phượng", "Lê Văn Kiệt", "Hành động võ thuật", 2019));
        phimList.add(new Phim("Cua lại vợ bầu", "Nhất Trung", "Hài/kịch", 2019));
        phimList.add(new Phim("Mắt Biếc", "Victor Vũ", "Lãng mạn/Chính kịch", 2019));
        phimList.add(new Phim("Em Chưa 18", "Lê Thanh Sơn", "Tình cảm hài hước", 2017));
        model.addAttribute("phimList", phimList);
        return "index";
    }
}
