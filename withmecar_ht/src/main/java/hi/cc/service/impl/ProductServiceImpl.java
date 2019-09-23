package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.CarLogo;
import hi.car.pojo.Product;
import hi.cc.mapper.ZiYouShangPingMapper;
import hi.cc.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ZiYouShangPingMapper ziYouShangPingMapper;

    @Override
    public List<Product> findAllProduct(int page, int row) {
        PageHelper.startPage(page, row);
        List<Product> findallproduct = ziYouShangPingMapper.findAllProduct();
        System.out.println("findallproduct="+findallproduct);
        return findallproduct;
    }

    @Override
    public int ap(Product product) {
        int count=ziYouShangPingMapper.ap(product);
        return count;
    }
    @Override
    public boolean dp(int id){
        return ziYouShangPingMapper.dp(id)>0?true:false;
    }

    @Override
    public CarLogo fci(int id) {
        CarLogo fci=ziYouShangPingMapper.fci(id);
        System.out.println("fci="+fci);
        return fci;
    }

    @Override
    public Product fpi(int id) {
        Product fpi=ziYouShangPingMapper.fpi(id);
        System.out.println("fpi="+fpi);
        return fpi;
    }

    @Override
    public int maxPage(int row) {
        int count = ziYouShangPingMapper.totaCount();
        return count%row==0?count/row:count/row+1;
    }


//    @Override
//    public List<Product> findAllProductId() {
//        List<Product> apid = ziYouShangPingMapper.findAllProductId();
//        System.out.println("ap="+apid);
//        return apid;
//    }
}
