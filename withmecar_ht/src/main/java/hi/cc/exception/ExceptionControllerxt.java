package hi.cc.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerxt {
    @ExceptionHandler(value = UnauthorizedException.class)
    public String handlerException(HttpServletRequest request,Exception e){
        return "unauth";
    }
}
