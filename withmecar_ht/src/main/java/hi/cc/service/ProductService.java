package hi.cc.service;

import hi.car.pojo.CarLogo;
import hi.car.pojo.Product;

import java.util.List;

public interface ProductService {
    public List<Product>findAllProduct(int page, int row);
    public int ap(Product product);
    public boolean dp(int id);
    public CarLogo fci(int id);
    public Product fpi(int id);
    public int maxPage(int row);

}
