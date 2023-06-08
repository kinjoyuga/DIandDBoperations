package com.example.lesson;

import com.example.lesson.Record.ProductRecord;
import com.example.lesson.Service.ProductService;//自作したやつ
import org.springframework.boot.SpringApplication;//Spring Bootアプリケーションの起動時に使用
import org.springframework.boot.autoconfigure.SpringBootApplication;//SpringBootの設定を自動的に構成するため
import org.springframework.context.ConfigurableApplicationContext;//アプリ実行時取得できるアプリコンテキストを表す

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonApplication.class, args);
		//Spring FrameworkのSpringApplicationクラスを使用して、Javaアプリケーションを起動するためのメソッド

		ConfigurableApplicationContext context =
				SpringApplication.run(LessonApplication.class, args);
		//依存性の注入、Beanの管理、イベントの発生などを提供。複数のメソッドが使用可能になる
		ProductService productService = context.getBean(ProductService.class);

//指示している部分

		//deleteで削除
//		var delGoods = productService.delete(102);
//		System.out.println(delGoods);


		//insertで追加する
//		var Goods = new ProductRecord(102, "フランス人形", 2200);
//		productService.insert(Goods);//userServiceでUserの中身をinsertしてもらう

		//updateでproducts更新
		var upGoods = new ProductRecord(101,"蝋人形",10000);
		productService.update(upGoods);
		System.out.println(upGoods);

		//findAllで全部表示
		var list = productService.findAll();
		list.stream().forEach(System.out::println);

		//findByIdで一部表示
		var goods = productService.findById(102); // IDが1のユーザーのみを取得
		System.out.println(goods);

	}
}