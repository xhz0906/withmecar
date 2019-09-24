package com.qf.j1904.service;

import hi.car.pojo.MemberCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemCarService_xpy {
    /**
     * 修改信息
     * @param mcar
     * @return
     */
    public boolean updateMemCar(MemberCar mcar);
    public MemberCar findMemCar(int id);
    /**
     * 根据会员id查询会员座驾
     * @param id
     * @return
     */
    public List<MemberCar> findMemCarById(int id, int type);
    /**
     * 添加座驾
     * @param memcar
     * @return
     */
    public boolean  saveMemCar(MemberCar memcar);

    /**
     * 删除座驾信息
     * @param id
     * @return
     */
    public boolean deleteById(int id);
}
