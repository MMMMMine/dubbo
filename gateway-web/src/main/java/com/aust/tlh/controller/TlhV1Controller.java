package com.aust.tlh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * 类描述:
 * Created by tanglinhui on 2016/12/21.
 * Version 1.0
 */
@Controller
@RequestMapping("/aust/tlh")
public class TlhV1Controller {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    Object test(@RequestBody String req, HttpServletRequest httpServletRequest) {
        String filePath = "/vj.key";
        File file = new File(filePath);
        try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");

            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String str = null;

            while((str = br.readLine()) != null) {
                sb.append(str);
            }
            System.out.println(sb.toString().length());
            br.close();
            reader.close();

            // write string to file
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return "welcome";
    }


    public static void main(String[] args) {

    }

}
