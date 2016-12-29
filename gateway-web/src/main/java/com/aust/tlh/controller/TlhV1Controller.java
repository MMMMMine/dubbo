package com.aust.tlh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;

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
        String url = httpServletRequest.getRequestURL().toString();
        String uri = httpServletRequest.getRequestURI();
        String authType = httpServletRequest.getAuthType();

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

    public static boolean matchCheck(String str1, String str2,int n){
        boolean matchingNum=true;

        for(int i=str1.length()-n,j=0;i<str1.length();i++,j++){
            if (!(str1.charAt(i)==str2.charAt(j))){
                matchingNum =false;
                break;
            }
        }

        return matchingNum;
    }

    public static int secMatchCheck(String str1, String str2){
        int matchNum = str1.length()<=str2.length()?str1.length():str2.length();

        for (int i =str1.length()-matchNum,j=0;i<str1.length();i++,j++){
            if (matchCheck(str1,str2,matchNum)){
                break;
            }else{
                matchNum++;
            }
        }

        return matchNum;
    }

    public static int ultMatchCheck(String str1,String str2){
        int positive = secMatchCheck(str1,str2);
        int negative = secMatchCheck(str2,str1);
        return positive>=negative?positive:-negative;
    }

    public static String assemble(ArrayList<String> list){
        int a = 0 ,b =0;
        int currentMatchNumber = 0;
        int tempMatchNum = 0;

        String str1 = "",str2 = "";

        while(list.size()>=2){
            a=0;
            b=1;
            currentMatchNumber=ultMatchCheck(list.get(a),list.get(b));
            for (int i =0; i< list.size();i++){
                for(int j = i+1;j<list.size();j++){
                    tempMatchNum = Math.abs(ultMatchCheck(list.get(i),list.get(j)));
                    if (Math.abs(currentMatchNumber)<tempMatchNum){
                        a=i;
                        b=j;
                        currentMatchNumber=tempMatchNum;
                    }
                }
            }
        }
        if (currentMatchNumber>0){
            str1 = list.get(a);
            str2 =list.get(b);
        }else {
            str1 = list.get(b);
            str2 = list.get(a);
        }
        if (a>=b){
            int c =a;
            a=b;
            b=c;
        }
        list.remove(a);
        list.remove(b-1);
        list.add(str1+str2.substring(Math.abs(currentMatchNumber)));

        return list.get(0);
    }




    public static void main(String[] args) {
//        String priCertPath = Thread.currentThread().getContextClassLoader().getResource(PropertiesUtil.getValue("invPriCert")).getPath();
//        String priCert = com.wangyin.aks.security.sign.util.Base64.encode(FileUtil.readFile(priCertPath));
//        System.out.print(priCert);
 /*        try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");

            FileReader reader = new FileReader(pubCertPath);
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
        }*/
        File file = new File("");
        Reader reader = null;
        try {
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;

            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r' &&((char) tempchar) != '\n' ) {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       /* try {
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(pubCertPath));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } */finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        // System.out.print(pubCertPath);

        String[] str = {"82df522956fd5bb675","e55c8256e07978798","907f4e4b",
        "bb6751f6b7b4ee55c","8798f8d8b90"};

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i<str.length;i++){
            list.add(str[i]);
        }

        String assembleResult = assemble(list);

        String sentence = "";
        for (int i = 0; i<assembleResult.length();i+=4){
            sentence = sentence+((char)Integer.parseInt(assembleResult.substring(i,i+4),16));
        }

        System.out.println("\n"+sentence);
    }

}
