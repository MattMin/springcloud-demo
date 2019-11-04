package com.mzyupc.order.vo;

/**
 * @author mzyupc@163.com
 * @date 2019/11/4 16:08:38
 */
public class UserVO {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
