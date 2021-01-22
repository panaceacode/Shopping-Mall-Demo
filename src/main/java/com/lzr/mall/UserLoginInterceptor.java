package com.lzr.mall;

import com.lzr.mall.consts.MallConst;
import com.lzr.mall.exception.UserLoginException;
import com.lzr.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /**
     *
     * true: 表示继续流程
     * false: 表示中断
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...");
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);

        if (user == null) {
            log.info("user=null");
            throw new UserLoginException();
        }
        return true;
    }
}
