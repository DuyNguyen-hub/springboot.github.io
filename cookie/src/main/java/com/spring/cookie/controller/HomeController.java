package com.spring.cookie.controller;

import com.spring.cookie.model.Color;
import com.spring.cookie.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "home-layout";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        return "blog";
    }

    @GetMapping("setting")
    public String setting(Model model){
        model.addAttribute("color", new Color());
        return "setting";
    }


    @PostMapping("/setting")
    public String setting(HttpServletRequest request, HttpServletResponse response, Model model,
                            @ModelAttribute Color color) {
         String bgColor = color.getBgColor();
         String ftColor = color.getFtColor();
         String ftSize = color.getFtSize() + "px";
        if(bgColor != null) {
            Cookie bgrColor = CookieUtil.createCookie(
                "bgrColor",    //Key
                bgColor,        //Value
                15,           //Số giây cho đến khi hết hạn
                true,        //isSecured, yêu cầu cookie gửi lên bằng HTTPS
                false,        //HttpOnly, nếu bằng true thì javascript phía client sẽ không đọc được, chỉ server đọc
                "/",          //cookie này có hiệu lực từ đường dẫn nào
                request.getServerName()); //server nào
            response.addCookie(bgrColor);
        }

        if (ftColor != null) {
            Cookie fontColor = CookieUtil.createCookie(
                "fontColor",    //Key
                ftColor,        //Value
                15,           //Số giây cho đến khi hết hạn
                true,        //isSecured, yêu cầu cookie gửi lên bằng HTTPS
                false,        //HttpOnly, nếu bằng true thì javascript phía client sẽ không đọc được, chỉ server đọc
                "/",          //cookie này có hiệu lực từ đường dẫn nào
                request.getServerName());
                 //server nào
            response.addCookie(fontColor);
        }

        if(ftSize != null) {
            Cookie fontSize = CookieUtil.createCookie(
                "fontSize",    //Key
                ftSize,        //Value
                15,           //Số giây cho đến khi hết hạn
                true,        //isSecured, yêu cầu cookie gửi lên bằng HTTPS
                false,        //HttpOnly, nếu bằng true thì javascript phía client sẽ không đọc được, chỉ server đọc
                "/",          //cookie này có hiệu lực từ đường dẫn nào
                request.getServerName()); //server nào

            response.addCookie(fontSize);   
        }
        return "setting";
    }

}
