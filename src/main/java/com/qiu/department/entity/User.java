package com.qiu.department.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Collection;


@Data
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 780648192026748343L;

    private Long id;
    /**
     * 姓名
     */
    private String username;
    /**
     * 学号
     */
    private String sno;

    private String password;
    /**
     * 状态：0 正常 -1 注销
     */
    private Integer state;
    /**
     * 入住时间
     */
    private LocalDateTime createTime;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 0、管理员  1、学生
     */
    private Integer type;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 楼栋id
     */
    private Long departmentId;
    /**
     * 寝室名称
     */
    private String room;
    /**
     * 院系名称
     */
    private String instituteName;
    /**
     * 权限
     */
    private String authority;

    private String major;

    private int roomBed;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
}