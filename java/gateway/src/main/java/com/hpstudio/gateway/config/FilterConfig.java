package com.hpstudio.gateway.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpstudio.gateway.entity.Result;
import com.hpstudio.gateway.entity.User;
import com.hpstudio.gateway.login.util.JwtUtil;
import com.hpstudio.gateway.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.hpstudio.gateway.constant.ErrorCodeConstant.*;

/**
 * @author mawen
 * @date 2020/9/13 21:27
 * @email 455766076@qq.com
 */
@Slf4j
@Configuration
public class FilterConfig implements GlobalFilter, Ordered {
    @Autowired
    private UserService userService;

    @Value("${filter}")
    private boolean filter;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest request = exchange.getRequest();
        if (!filter) {
            return chain.filter(exchange);
        }
        String value = request.getPath().value();
        // TODO: 2020/9/17 先暂时这样不过滤注册用户的接口
        if (value.equals("/forum/user/add")) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst("token");
        if (null == token) {
            return getVoidMono(response, TOKEN_NULL_CODE, TOKEN_NULL_MSG);
        }
        //解析token
        DecodedJWT decode = JWT.decode(token);
        //获取id
        Integer id = decode.getClaim("id").asInt();
        User user = userService.selectUserById(id);
        if (null == user) {
            return getVoidMono(response, USER_NULL_CODE, USER_NULL_MSG);
        }
        Boolean isverify = false;
        try {
            isverify = JwtUtil.isverify(token, user);
        } catch (ExpiredJwtException e) {
            return getVoidMono(response, TOKEN_TIMEOUT_CODE, TOKEN_TIMEOUT_MSG);
        }
        if (!isverify) {
            return getVoidMono(response, PASSWORD_NOTMATCH_CODE, PASSWORD_NOTMATCH_MSG);
        }
        return chain.filter(exchange);
    }

    public Mono<Void> getVoidMono(ServerHttpResponse response, int code, String msg) {
        response.getHeaders().add("Content-Type", "application-json;Charset=UTF-8");
        Result result = Result.fail(code, msg);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMsg = null;
        try {
            jsonMsg = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        DataBuffer wrap = response.bufferFactory().wrap(jsonMsg.getBytes());
        return response.writeWith(Flux.just(wrap));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
