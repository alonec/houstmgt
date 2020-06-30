package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.service.sweeney.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@Controller
public class FileController {
    @Autowired
    FileService fileService;

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    //图片上传
    @RequestMapping(path = {"/updateImage/"} , method = { RequestMethod.OPTIONS})
    @ResponseBody
    public String updateImage(@RequestParam("fileName") MultipartFile file


    )  {


        try {

            String fileURL = fileService.saveImage(file);

            if (file == null){
                return HouseUtil.getJSONString(1,"文件名异常，图片上传失败,请检查问价格式是否正确！！！！！！！！！！！！！！！！！！");
            }

            return HouseUtil.getJSONString(0,"图片上传成功！！！"+fileURL);
        }catch (Exception e){
            logger.error("图片上传失败！！！"+e.getMessage());
            HouseUtil.getJSONString(1,"图片上传失败～～～");
        }

        return "";
    }

    //图片下载
    @RequestMapping(path = {"/image/"} , method = { RequestMethod.GET})
    @ResponseBody
    public void readImage(@RequestParam("name") String imageName ,
                          HttpServletResponse response){
        try{
            response.setContentType("image/png");
            StreamUtils.copy(new FileInputStream(new File(HouseUtil.IMAGE_ADR+imageName)),response.getOutputStream());
        }catch (Exception e){
            logger.error("图片读取错误"+e.getMessage());
        }
    }
}
