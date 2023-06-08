package com.example.lesson.Dao;

import com.example.lesson.Record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PgProductDao implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @Override
    public List<ProductRecord> findAll(){
        return namedParameterJdbcTemplate.query("SELECT * FROM products ORDER BY id",
                new DataClassRowMapper<>(ProductRecord.class));
    }

    //追加
    @Override
    public ProductRecord findById(int id) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = namedParameterJdbcTemplate.query("SELECT * FROM products WHERE id = :id", param, new DataClassRowMapper<>(ProductRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int insert(ProductRecord product) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", product.id());
        param.addValue("name", product.name());
        param.addValue("price", product.price());
        return namedParameterJdbcTemplate.update("INSERT INTO products VALUES(:id, :name, :price)", param);
    }

    @Override
    public int update(ProductRecord product){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id",product.id());
        param.addValue("name",product.name());
        param.addValue("price",product.price());
        String sql = "UPDATE products SET name = :name, price = :price WHERE id = :id";
        return namedParameterJdbcTemplate.update(sql,param);
    }

    @Override
    public int delete(int id){
        String sql = "DELETE FROM products WHERE id= :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
        return namedParameterJdbcTemplate.update(sql,param);
    }
}