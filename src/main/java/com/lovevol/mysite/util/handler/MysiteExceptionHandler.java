package com.lovevol.mysite.util.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MysiteExceptionHandler {
    public static final String ERROR_PAGE = "/default/error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e){
        e.printStackTrace();
        if (isAjax(request)){
            return "error";
        }else {
            ModelAndView md = new ModelAndView();
            md.addObject("exception", e);
            md.addObject("path", request.getRequestURL());
            md.setViewName(ERROR_PAGE);
            return md;
        }

    }

    public boolean isAjax(HttpServletRequest request){
        return ("XMLHttpResuest".equals(request.getHeader("X-Requested-With")));
    }
}
