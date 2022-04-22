package com.why.shopserver.user.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 用户信息
 *
 * @author why
 * @create 2022-04-22 16:37
 **/
@Entity //标记实体类
@Table(name = "user_login")
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin implements UserDetails, Serializable {

    /** 主键id **/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //主键生成策略 , 此策略为数据库自动生成 (自动增长)
    @Column(name="id")
    private Integer id;

    /** 用户名 **/
    @Column(name = "account")
    private String username;

    /** 密码 **/
    @Column(name = "pass_word")
    private String password;

    /** 权限 **/
    @Column(name = "permission")
    private String auths;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(this.auths);
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getAuths() {
        return auths;
    }
}