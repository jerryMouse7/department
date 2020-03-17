package com.qiu.department.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiu.department.entity.JwtUser;
import com.qiu.department.entity.LoginUser;
import com.qiu.department.entity.User;
import com.qiu.department.security.SecurityConstants;
import com.qiu.department.service.UserService;
import com.qiu.department.utils.JwtTokenUtil;
import com.qiu.department.utils.JwtUtil;
import com.qiu.department.utils.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    @Autowired
    private UserService userService;
    private JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
    private ThreadLocal<Boolean> rememberMe = new ThreadLocal<>();
//    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/login");
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

       try{
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//            User user = userService.queryByUsername(username);
           Map<String,String> userDetails = new HashMap<>();
//           userDetails.put("id",user.getId().toString());
//           userDetails.put("username",user.getUsername());
           usernamePasswordAuthenticationToken.setDetails(userDetails);
           setDetails(request, usernamePasswordAuthenticationToken);
           System.out.println(getAuthenticationManager());
           return authenticationManager.authenticate(usernamePasswordAuthenticationToken);

       }catch (Exception e){
           System.out.println("出现错误");
       }
       return  null;


    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) throws IOException, ServletException {
        handleResponse(request, response, authentication, null);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
    }

    private void handleResponse(HttpServletRequest request, HttpServletResponse response, Authentication authResult, AuthenticationException failed) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        Result<String> responseEntity = new Result<String>(null);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        if (authResult != null) {
            // 处理登入成功请求
            UserDetails user= (UserDetails) authResult.getPrincipal();
            String token = jwtTokenUtil.generateToken(user);
            responseEntity.setStatus(HttpStatus.OK.value());
            responseEntity.setMsg("登入成功");
            responseEntity.setData("Bearer " + token);
            response.setStatus(HttpStatus.OK.value());
            response.getWriter().write(mapper.writeValueAsString(responseEntity));
        } else {
            // 处理登入失败请求
            // 处理登入失败请求
            responseEntity.setStatus(HttpStatus.BAD_REQUEST.value());
            responseEntity.setMsg("用户名或密码错误");
            responseEntity.setData(null);
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write(mapper.writeValueAsString(responseEntity));
        }
    }



}
