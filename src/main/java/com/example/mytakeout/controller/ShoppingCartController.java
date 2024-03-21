package com.example.mytakeout.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;



//TODO: 购物车的东西

/*
 * 应该有一个购物车页面
 * 功能:
 * -添加菜品到购物车
 * -修改数量（+1），数量==0时删除菜品
 * -删除菜品
 * -返回购物车中的菜品信息
 */
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("cart")
public class ShoppingCartController {
    /**
     * 购物车中的信息
     * @param param
     * @return
     */
    // @GetMapping("/")
    // public R<ShoppingCart> getShopppingCart(@RequestParam String param) {
        
    // }
    /**
     * 在购物车中添加 商品 包括（菜品的id,数量）
     * @param shoppingCart
     * @return
     */
    // @PostMapping("/")
    // public R<ShoppingCart> addDish(@RequestBody ShoppingCart shoppingCart) {
    //     //TODO: process POST request
        
    //     reShoppingCart shoppingCart;
    // }
    
    
}
