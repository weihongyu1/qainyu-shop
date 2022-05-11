package com.why.shopserver.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 *
 * @author why
 * @create 2022-04-21 17:13
 **/
@Data
@Slf4j
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    private String secret;
    private Long expiration;
    private String header;
    /**
     * 生成token令牌
     *
     * @param userDetails 用户
     * @return 令token牌
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        //生成Token
        return generateToken(claims);
    }
    /**
     * 从claims生成令牌
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    /**
     * 从Token中获取用户名称
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username =  claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
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
            log.info("JWT格式验证失败：{}",token);
            claims = null;
        }
        return claims;
    }
    /**
     * 生成token的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
    /**
     * 根据token过去过期时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }
    /**
     *
     * 验证Token是否过期
     * @param token
     * @param userDetails
     * @return true表示没有过期，false表示过期
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
    /**
     * 判断令牌是否过期
     * @param token
     * @return
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
     * 判断token是否可以刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }
    /**
     * 刷新token
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    public String getToken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String token = "";
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Authorization")){
                    token = cookie.getValue();
                }
            }
        }
        return token;
    }
}