/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Nivas
 */
@Controller
public class MyController {
    
    @RequestMapping(value = {"/myPage.htm","aa.htm"})
    public String myMethod(){
        return "page";
    }
    
      @RequestMapping(value = "/myPage1.htm")
    public ModelAndView myMethod1(Model model){
        model.addAttribute("name","XYZ");
        
        
        return new ModelAndView("page1");
    }
    
    @RequestMapping(value = {"/","index.htm"})
    public String myMethod11(){
        return "index";
    }
    
    
     @RequestMapping(value = "/test.html",method = RequestMethod.GET)
    public @ResponseBody HashMap<String,String> myMethod111(){
        
        
        
        HashMap<String,String> list=new  HashMap<String,String>();
        list.put("one", "1");
        list.put("two", "2");
        
        return list;
    }
    
    
     @RequestMapping(value = "/test.html",headers = {"Accept=application/json","contentType=application/json"} ,method = RequestMethod.POST)
    public @ResponseBody HashMap<String,String> myMethod1111(@RequestBody String id){
        
        HashMap<String,String> list=new  HashMap<String,String>();
        list.put("one", "1");
        list.put("two", "2");
        
        return list;
    }
    
    @RequestMapping(value = "/test1.html" ,method = RequestMethod.GET)
    public @ResponseBody ArrayList<String> myMethod1112(){
        
        
        
        ArrayList<String> list=new  ArrayList<String>();
        list.add("one");
        list.add("two");
        
        return list;
    }
    
    
}
