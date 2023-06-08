package com.example.lesson.Service;

import com.example.lesson.Dao.ProductDao;
import com.example.lesson.Record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PgProductService implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductRecord> findAll(){
        return productDao.findAll();
    }

    @Override
    public ProductRecord findById(int id){
        return productDao.findById(id);
    }

    @Override
    public int insert(ProductRecord product){
        return productDao.insert(product);
    }

    @Override
    public int update(ProductRecord product){
        return productDao.update(product);
    }

    @Override
    public int delete(int id){
        return productDao.delete(id);
    }
}
