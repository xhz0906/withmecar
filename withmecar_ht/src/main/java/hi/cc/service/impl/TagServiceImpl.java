package hi.cc.service.impl;

import hi.car.pojo.Tag;
import hi.cc.mapper.TagMapper;

import hi.cc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Tag> findQbz() {
        return tagMapper.findQbz();
    }
    @Override
    public List<Tag> findSy() {
        return tagMapper.findSy();
    }

    @Override
    public Tag findByid(int tagid) {
        return tagMapper.findByid(tagid);
    }

    @Override
    public int updateById(Tag tag) {
        return tagMapper.updateById(tag);
    }

    @Override
    public boolean findByName(String name) {
        Tag byName = tagMapper.findByName(name);
        return byName!=null?true:false;
    }

    @Override
    public int updateLoc1(int id) {
        return tagMapper.updateLoc1(id);
    }

    @Override
    public int updateLoc2(int id) {
        return tagMapper.updateLoc2(id);
    }

}
