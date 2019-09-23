package hi.cc.utils;

import hi.car.pojo.AdminMenuAuth;
import hi.cc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RoleMenUtils {
    @Autowired
    private MenuService menuService;
    public List<AdminMenuAuth> test1(int roleId,int mpid){
        List<AdminMenuAuth> roleMen = menuService.findRoleMen(roleId);
        //List<AdminMenuAuth> list = new ArrayList<>();
        List<AdminMenuAuth> list1 = menuService.findByParentId(mpid);
        for (AdminMenuAuth a:roleMen) {
            for (AdminMenuAuth b:list1) {
                if (a.getId() == b.getId()){
                    b.setAction("true");
                    break;
                }
            }
        }
        return list1;
    }
}
