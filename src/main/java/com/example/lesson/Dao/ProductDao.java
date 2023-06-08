package com.example.lesson.Dao;

import com.example.lesson.Record.ProductRecord;

import java.util.List;

public interface ProductDao {

    public List<ProductRecord> findAll();//複数返すからListにする

    public ProductRecord findById(int id);//単一だからListリストにしない

    public int insert(ProductRecord product);

    public int update(ProductRecord product);

    public int delete(int id);//なんかもう値に応じて変化する感じ




}
