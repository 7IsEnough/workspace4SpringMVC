package com.clearlove.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author promise
 * @date 2021/10/3 - 15:57
 */
@ResponseStatus(reason = "用户被拒绝登录", value = HttpStatus.NOT_ACCEPTABLE)
public class UserNameNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
}
