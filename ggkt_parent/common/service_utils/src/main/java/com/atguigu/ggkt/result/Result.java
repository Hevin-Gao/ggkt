package com.atguigu.ggkt.result;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
//同统一返回结果类
@Data//生成相应的get、set方法
public class Result<T> {
    private Integer code;//状态码
    private String message;//返回状态信息
    private T data;//返回数据

    public Result(){//无参构造

    }
    // 成功的方法,没有data数据
//    public static<T> Result<T> ok(){
//        Result<T> result = new Result<>();
//        result.setCode(200);
//        result.setMessage("成功");
//        return result;
//    }
//    //失败的方法，没有data数据
//    public static<T> Result<T> fail(){
//        Result<T> result = new Result<>();
//        result.setCode(201);
//        result.setMessage("失败");
//        return result;
//    }
    // 成功的方法,有data数据
    public static<T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        if(data!=null){
            result.setData(data);
        }
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }
    //失败的方法，有data数据
    public static<T> Result<T> fail(T data){
        Result<T> result = new Result<>();
        if(data!=null){
            result.setData(data);
        }
        result.setCode(201);
        result.setMessage("失败");
        return result;
    }
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

}