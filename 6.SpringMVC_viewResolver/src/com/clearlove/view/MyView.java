package com.clearlove.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

/**
 * 自定义视图
 * @author promise
 * @date 2021/7/3 - 16:42
 */
public class MyView implements View {

  /***
   * 返回的数据的内容类型
   * @return
   */
  @Override
  public String getContentType() {
    return "text/html";
  }

  @Override
  public void render(Map<String, ?> map, HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) throws Exception {
    System.out.println("之前保存的数据：" + map);
    httpServletResponse.setContentType("text/html");
    List<String> vn = (List<String>) map.get("video");
    httpServletResponse.getWriter().write("哈哈<h1>即将展现精彩内容</h1>");
    for (String s : vn) {
      httpServletResponse.getWriter().write("<a>下载" + s +".avi</a><br>");
    }
    httpServletResponse.getWriter().write("<script>"
        + "var aEle = document.getElementsByTagName('a')[0];"
        + "aEle.onclick = function(){"
        + "alert('想下载吗?交学费')"
        + "}"
        + "</script>");
  }
}
