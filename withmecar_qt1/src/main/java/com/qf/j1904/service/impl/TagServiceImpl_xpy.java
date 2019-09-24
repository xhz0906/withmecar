package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.TagMapper_xpy;
import com.qf.j1904.service.TagService_xpy;
import hi.car.pojo.MemberTag;
import hi.car.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TagServiceImpl_xpy implements TagService_xpy {
    @Autowired
    private TagMapper_xpy tagMapper;
    @Override
    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    @Override
    public List<Tag> findTagByMid(int id) {
        return tagMapper.findTagByMid(id);
    }

    @Override
    public boolean deleteMemTag(int mid,int tid) {
        Map<String, Integer> map = new HashMap<>();
        map.put("mid",mid);
        map.put("tid",tid);
        int c = tagMapper.deleteMemTag(map);
        return c>0?true:false;
    }

    @Override
    public boolean saveMemTag(MemberTag mt) {
        int c = tagMapper.saveMemTag(mt);
        return c>0?true:false;
    }

    @Override
    public Tag findNameById(int mid,int tid) {
        Map<String,Integer> map = new HashMap<>();
        map.put("mid",mid);
        map.put("tid",tid);
        return tagMapper.findNameById(map);
    }

    @Override
    public Tag findByName(String name) {
        return tagMapper.findByName(name);
    }
}
