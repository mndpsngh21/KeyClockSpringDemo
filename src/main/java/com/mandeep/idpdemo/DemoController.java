package com.mandeep.idpdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/main")
public class DemoController {
    @Autowired
    KeycloakLogoutHandler keycloakLogoutHandler;
    @ResponseBody
    @RequestMapping(path = "/demo")
    public String sampleRequest(){
        return "demo";
    }

    @ResponseBody
    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication auth){
        keycloakLogoutHandler.logout(request,response,auth);
        return "logged out";
    }
}
