package com.bootdo.fro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/3/29.
 */
@Controller
@RequestMapping("/fro")
public class IndexController {

    @RequestMapping("/index")
    public String freIndex(){
      return "fro/index";
    }
}
