package com.qf.j1904.service;

import hi.car.pojo.MemberTag;
import hi.car.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TagService_xpy {
    /**
     * 查询所有标签
     * @return
     */
    public List<Tag> findAll();

    /**
     * 查询当前会员的标签信息
     * @param id
     * @return
     */
    public List<Tag> findTagByMid(int id);

    /**
     * 删除会员标签
     * @param map
     * @return
     */
    public boolean deleteMemTag(int mid,int tid);

    /**
     * 添加会员标签
     * @param map
     * @return
     */
    public boolean saveMemTag(MemberTag mt);
    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    public Tag findNameById(int mid,int tid);

    public Tag findByName(String name);
}
