package com.qf.j1904.mapper;

import hi.car.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MessageMapper_xpy {
    /**
     * 根据时间段来搜索对象
     * @param map
     * @return
     */
    public List<Message> findMessByTime(@Param("map") Map<String,String> map);

    /**
     * 根据时间降序排序
     * @return
     */
    public List<Message> findMessageDesc();

    /**
     * 查询所有
     * @return
     */
    public List<Message> findAll();

    /**
     * 根据id查询消息
     * @param id
     * @return
     */
    public Message findById(int id);

    /**
     * 根据id修改信息的状态
     * @param id
     * @return
     */
    public int updateIs(int id);
}
