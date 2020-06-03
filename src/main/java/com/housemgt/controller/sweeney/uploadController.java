package com.housemgt.controller.sweeney;


import com.alibaba.fastjson.JSONObject;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import com.qiniu.storage.Configuration;


@Controller
public class uploadController {
    @ResponseBody
    @RequestMapping(path = {"/upload/"} , method = { RequestMethod.POST})
    public JSONObject upload(@RequestParam("file") MultipartFile file) throws IOException {
        JSONObject result = new JSONObject();
        //七牛云域名
        String qiniuUrl = "qb8iapbjf.bkt.clouddn.com";
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //…其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //…生成上传凭证，然后准备上传
        String accessKey = "V60G3fZWiq7TIV6NR9mz_yZySwENkkcnt_EReUli";
        String secretKey = "wVBp0I_5BdhzLDdXuYGeJSLU86DA0dL0g3Jw7Ay1";
        String bucket = "housemgt";

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //这里获取上传的文件名

        String key = file.getOriginalFilename();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            byte[] localFilePath = file.getBytes();
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //拼接url
            //返回的文件名是putRet.key
            String responseUrl = qiniuUrl+"/"+putRet.key;
            result.put("data",responseUrl);
            System.out.println("上传文件成功");
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return result;
    }
}
