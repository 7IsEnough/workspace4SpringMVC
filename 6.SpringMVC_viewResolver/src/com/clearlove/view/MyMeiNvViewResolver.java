package com.clearlove.view;

import java.util.Locale;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * @author promise
 * @date 2021/7/3 - 16:32
 */
public class MyMeiNvViewResolver implements ViewResolver, Ordered {

  private Integer order = 0;

  @Override
  public View resolveViewName(String viewName, Locale locale) throws Exception {
    // 根据视图名返回视图对象
    if(viewName.startsWith("meinv:")){
      return new MyView();
    }else {
      // 如果不能处理返回null即可
      return null;
    }
  }

  /***
   *
   * @return
   */
  @Override
  public int getOrder() {
    return order;
  }

  // 改变视图解析器的优先级
  public void setOrder(Integer order) {
    this.order = order;
  }
}
