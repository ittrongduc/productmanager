package com.zdzz.product.controller;

import com.zdzz.product.service.FBVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Controller
public class FBController {

    @Autowired
    private FBVideoService fbVideoService;

    @RequestMapping(value = "/video", method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded")
    public String responseVideo(@RequestParam String link, HttpServletResponse response){

        if (StringUtils.isEmpty(link)){
            return "index";
        }

        try {

            fbVideoService.getVideo(link, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }

}
