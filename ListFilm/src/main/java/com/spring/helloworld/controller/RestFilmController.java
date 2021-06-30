package com.spring.helloworld.controller;

import java.util.List;

import com.spring.helloworld.model.Film;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RestFilmController {
    @GetMapping("films")
    public ResponseEntity<List<Film>> getAllFilm(){
        List<Film> films = List.of(
            new Film("Bố già", "Trấn Thành, Vũ Ngọc Đãng", "Hài/Chính kịch",  2021),
            new Film("Hai Phượng", "Lê Văn Kiệt", "Hành động võ thuật", 2019),
            new Film("Cua lại vợ bầu", "Nhất Trung", "Hài/kịch", 2019),
            new Film("Mắt Biếc", "Victor Vũ", "Lãng mạn/Chính kịch", 2019),
            new Film("Em Chưa 18", "Lê Thanh Sơn", "Tình cảm hài hước", 2017)
        );
        return ResponseEntity.ok().body(films);
    }
}
