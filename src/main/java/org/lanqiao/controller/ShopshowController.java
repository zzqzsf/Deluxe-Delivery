package org.lanqiao.controller;

import org.lanqiao.service.ShopshowServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShopshowController {
@Autowired
    ShopshowServiseImpl shopshowServise;

}
