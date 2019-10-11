package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.MessageMapper_xpy;
import com.qf.j1904.service.MessageService_xpy;
import hi.car.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl_xpy implements MessageService_xpy {
    @Autowired
    private MessageMapper_xpy messageMapper;
    @Override
    public List<Message> findMessByTime(Map<String, String> map) {
        return messageMapper.findMessByTime(map);
    }

    @Override
    public List<Message> findMessageDesc() {
        return messageMapper.findMessageDesc();
    }

    @Override
    public List<Message> findAll() {
        return messageMapper.findAll();
    }

    @Override
    public Message findById(int id) {
        return messageMapper.findById(id);
    }

    @Override
    public int updateIs(int id) {
        return messageMapper.updateIs(id);
    }
}
