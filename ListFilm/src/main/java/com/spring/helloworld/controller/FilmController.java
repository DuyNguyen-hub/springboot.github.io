package com.spring.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import com.spring.helloworld.model.Film;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("film")
public class FilmController {
    @GetMapping("")
    public String show(Model model){
        List<Film> phimList = new ArrayList<>();
        phimList.add(new Film("Bố già", "Trấn Thành, Vũ Ngọc Đãng", "Hài/Chính kịch",  2021));
        phimList.add(new Film("Hai Phượng", "Lê Văn Kiệt", "Hành động võ thuật", 2019));
        phimList.add(new Film("Cua lại vợ bầu", "Nhất Trung", "Hài/kịch", 2019));
        phimList.add(new Film("Mắt Biếc", "Victor Vũ", "Lãng mạn/Chính kịch", 2019));
        phimList.add(new Film("Em Chưa 18", "Lê Thanh Sơn", "Tình cảm hài hước", 2017));
        model.addAttribute("phimList", phimList);
        return "index";
    }
}
