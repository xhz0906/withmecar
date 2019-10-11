package com.qf.j1904.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.j1904.mapper.CarMapper_xpy;
import com.qf.j1904.service.CarService_xpy;
import hi.car.pojo.Car;
import hi.car.pojo.CarLogo;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CarServiceImpl_xpy implements CarService_xpy {
    @Autowired
    private CarMapper_xpy carMapper;

    @Override
    public boolean updateCar(Car car) {
        int c = carMapper.updateCar(car);
        return c>0?true:false;
    }

    @Override
    public boolean addCar(Car car) {
        int i = carMapper.addCar(car);
        return i>0?true:false;
    }

    @Override
    public int findMaxId() {
        return carMapper.findMaxId();
    }

    @Override
    public Car findCarByBranMake(int cid) {
        return carMapper.findCarByBranMake(cid);
    }

    @Override
    public List<Car> findAll() {
        return carMapper.findAll();
    }

    @Override
    public List<Car> findAllByPinpai(String bname) {
        return carMapper.findAllByPinpai(bname);
    }

    @Override
    public List<Car> findAllByCountry(String cname) {
        return carMapper.findAllByCountry(cname);
    }

    @Override
    public List<Car> findAllByState() {
        return carMapper.findAllByState();
    }

    @Override
    public List<Car> findAllPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        return carMapper.findAllPage();
    }

    @Override
    public int findMaxpage(int rows) {
        int c = carMapper.findCount();
        int page = c%rows==0?c/rows:c/rows+1;
        return page;
    }

    @Override
    public List<CarLogo> findCarLogoByCoun(String country) {
        return carMapper.findCarLogoByCoun(country);
    }

    @Override
    public CarLogo findCarLgByName(String name) {
        return carMapper.findCarLgByName(name);
    }


    @Override
    public List<Car> findByTag(String name) {
        return carMapper.findByTag(name);
    }

    @Override
    public List<Car> findByAct(int id) {
        return carMapper.findByAct(id);
    }
}
