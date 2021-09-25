package com.clearlove.controller;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @author promise
 * @date 2021/9/23 - 13:59
 */
public class MyLocaleResolver implements LocaleResolver {

  /**
   * 解析返回Locale
   * @param httpServletRequest
   * @return
   */
  @Override
  public Locale resolveLocale(HttpServletRequest httpServletRequest) {
    Locale l;
    String localeStr = httpServletRequest.getParameter("locale");
    // 如果带了locale参数就用参数指定的区域信息，如果没带就用请求头的
    if (!StringUtils.isEmpty(localeStr)) {
      l = new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
    } else {
      l = httpServletRequest.getLocale();
    }
    return l;
  }

  /**
   * 修改locale
   * @param httpServletRequest
   * @param httpServletResponse
   * @param locale
   */
  @Override
  public void setLocale(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Locale locale) {
    throw new UnsupportedOperationException(
        "Cannot change HTTP accept header - use a different locale resolution strategy");
  }
}
