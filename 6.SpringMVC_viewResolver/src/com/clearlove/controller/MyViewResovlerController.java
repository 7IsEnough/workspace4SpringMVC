package com.clearlove.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自定义视图解析器和视图对象
 * @author promise
 * @date 2021/7/3 - 16:28
 */
@Controller
public class MyViewResovlerController {

  @RequestMapping("handleplus")
  public String handlePlus(Model model) {
    // meinv:/gaoqing
    // forward:/login.jsp
    List<String> vName = new ArrayList<>();
    List<String> imgName = new ArrayList<>();
    vName.add("佟老师");
    vName.add("飞哥");
    imgName.add("萌萌");

    model.addAttribute("video", vName);
    model.addAttribute("imgs", imgName);
    return "meinv:/gaoqing";
  }

}
