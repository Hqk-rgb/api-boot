package top.whf.security.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import top.whf.common.exception.ErrorCode;
import top.whf.common.utils.HttpContextUtils;
import top.whf.common.utils.JsonUtils;
import top.whf.common.utils.Result;

import java.io.IOException;
/**
 * @ClassName SecurityAuthenticationEntryPoint
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 18:35
 */
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint{
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

        response.getWriter().print(JsonUtils.toJsonString(Result.error(ErrorCode.UNAUTHORIZED)));
    }
}
