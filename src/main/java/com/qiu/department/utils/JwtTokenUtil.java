package com.qiu.department.utils;

import com.qiu.department.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
@Component
public class JwtTokenUtil {
    private String secret = "eyJleHAiOjE1NDMyMDUyODUsInN1YiI6ImFkbWluIiwiY3Jlsdafuiqwe91230948ncwerapewirqerliqwaeutrofv";
    private Long expiration = 18000000L;
    private String header = "Authorization";
    private Long refreshToken = 6000000L;

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     *
     * @param userDetails 用户
     * @return 令牌
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        StringBuilder authString = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            authString.append(authority.getAuthority());
            authString.append(",");
        }
        claims.put("ROLE", authString.deleteCharAt(authString.length() - 1).toString());
//        claims.put("ROLE", userDetails.getAuthorities());
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
//        claims.put("refreshToken", new Date(System.currentTimeMillis() + refreshToken));
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
//            claims.put("refreshToken", new Date(System.currentTimeMillis() + refreshToken));
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userDetails 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {

        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    public Boolean checkedTokenTime(String token) {
        Claims claimsFromToken = getClaimsFromToken(token);
        if (claimsFromToken == null) {
            return false;
        }
        return true;
    }

    public Long TokenTime(String token) {

        try {
            Claims claimsFromToken = getClaimsFromToken(token);
            Long created = (Long) claimsFromToken.get("created");
            return created;
        } catch (Exception e) {
            return -1L;
        }

    }

    public List<SimpleGrantedAuthority> getUserRolesByToken(String token) {

//        List<LinkedHashMap<String, String>> roles = (List<LinkedHashMap<String, String>>) getTokenBody(token).get("ROLE");
//        LinkedHashMap<String, String> roleMap = roles.get(0);
//        String roleString = roleMap.get("authority");
//        return Arrays.stream(roleString.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        String roles = (String) getTokenBody(token).get("ROLE");
        String[] roleArray = roles.split(",");
        return Arrays.stream(roleArray).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

//        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

//        return Arrays.stream(role.split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        return roles.stream().map().collect(Collectors.toList());
    }

    private Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
