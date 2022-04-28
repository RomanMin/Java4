package HomeWork06;

import HomeWork06.dao.ProductsMapper;
import HomeWork06.model.Products;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {




        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));
        SqlSession session = sessionFactory.openSession();
        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        Products product = productsMapper.selectByPrimaryKey(100L);
        System.out.println(product);
    }
}
