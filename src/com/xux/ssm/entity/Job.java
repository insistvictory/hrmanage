package com.xux.ssm.entity;

import javafx.scene.DepthTest;

/**
 * Created by Administrator on 2018/10/12.
 */
public class Job {
    private Integer id;
    private Post post;
    private Dept dept;

    public Job() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", post=" + post +
                ", dept=" + dept +
                '}';
    }
}
