package com.qf.j1904.mapper;

import hi.car.pojo.MemberCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemCarMapper_xpy {
    /**
     * 修改信息
     * @param mcar
     * @return
     */
    public int updateMemCar(@Param("mcar") MemberCar mcar);
    public MemberCar findMemCar(int id);
    /**
     * 根据会员id查询会员座驾
     * @param id
     * @return
     */
    public List<MemberCar> findMemCarById(@Param("map")Map<String,Integer> map);

    /**
     * 添加座驾
     * @param memcar
     * @return
     */
    public int  saveMemCar(MemberCar memcar);

    /**
     * 删除座驾信息
     * @param id
     * @return
     */
    public int deleteById(int id);
}
