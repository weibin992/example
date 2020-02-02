package cn.weibin.springboot.model;

/**
 * 数据库表: user
 * 创建时间: 2020-02-01 21:17:46
 * @author Mybatis-Generator
 */
public class User {
    /** id */
    private Integer id;

    /** 用户名 */
    private String userName;

    /** 密码 */
    private String password;

    /** 数据状态 */
    private Boolean recordStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Boolean recordStatus) {
        this.recordStatus = recordStatus;
    }
}