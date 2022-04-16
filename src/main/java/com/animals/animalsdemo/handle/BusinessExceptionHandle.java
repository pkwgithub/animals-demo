package com.animals.animalsdemo.handle;
import com.animals.animalsdemo.exception.BusinessException;
import com.animals.animalsdemo.exception.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pankewei
 * @date 2021/8/2
 */

@ControllerAdvice
public class BusinessExceptionHandle extends RuntimeException{

    private Logger logger = LoggerFactory.getLogger(BusinessExceptionHandle.class);
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Response<String> myExceptionErrorHandler(BusinessException ex) throws Exception {
        Response<String> r = new Response();
        r.setMsg(ex.getMsg());
        r.setCode(ex.getCode());
        r.setStatus(ex.getCode()==200?true:false);
        return r;
    }
}
