package com.clearlove.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author promise
 * @date 2021/8/14 - 19:22
 */
@Controller
public class FileUploadController {

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public String upload(
      @RequestParam(value = "username", required = false) String username,
      @RequestParam("headerimg") MultipartFile file,
      Model model) {
    System.out.println("上传的文件信息：");
    System.out.println("文件项的name：" + file.getName());
    System.out.println("文件的名字：" + file.getOriginalFilename());

    // 文件保存
    try {
      file.transferTo(new File("F:\\" + file.getOriginalFilename()));
      model.addAttribute("msg", "文件上传成功了");
    } catch (Exception e) {
      model.addAttribute("msg", "文件上传失败了！" + e.getMessage());
    }

    return "forward:/index.jsp";
  }
}
