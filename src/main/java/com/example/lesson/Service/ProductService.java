package com.example.lesson.Service;

import com.example.lesson.Record.ProductRecord;

import java.util.List;

public interface ProductService {

    public List<ProductRecord> findAll();//複数返すからListにする

    public ProductRecord findById(int id);//単一だからListリストにしない

    public int insert(ProductRecord product);//追加

    public int update(ProductRecord product);//更新

    public int delete(int id);//削除

}