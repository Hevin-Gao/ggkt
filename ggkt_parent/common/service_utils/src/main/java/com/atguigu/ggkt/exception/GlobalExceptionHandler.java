package com.atguigu.ggkt.exception;

import com.atguigu.ggkt.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice //aop底层用到了aop，通过aop在现有功能种加入异常处理
public class GlobalExceptionHandler{
    //全局异常处理
    @ExceptionHandler(Exception.class)// 括号内()表示针对哪个异常进行处理@ExceptionHandler(Exception.class)
    @ResponseBody//返回json数据
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null).message("执行了全局异常处理");
    }

    //特定异常处理：ArithmeticException
    @ExceptionHandler(ArithmeticException.class)// 括号内()表示针对哪个异常进行处理@ExceptionHandler(Exception.class)
    @ResponseBody//返回json数据
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.fail(null).message("执行了ArithmeticException异常处理");
    }

    //自定义异常处理GgktException
    @ExceptionHandler(GgktException.class)// 括号内()表示针对哪个异常进行处理@ExceptionHandler(Exception.class)
    @ResponseBody//返回json数据
    public Result error(GgktException e){
        e.printStackTrace();
        return Result.fail(null).code(e.getCode()).message(e.getMsg());
    }


}

