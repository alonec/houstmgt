package com.housemgt.service;


import com.housemgt.common.utils.HouseUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileService {
    //保存图片
    public String saveImage(MultipartFile file) throws IOException {

        int dotPos = file.getOriginalFilename().lastIndexOf(".");

        if (dotPos<0){
            return null;
        }

        String fileExt = file.getOriginalFilename().substring(dotPos+1).toLowerCase();

        if (!HouseUtil.checkFileExt(fileExt)){
            return null;
        }

        String failName = UUID.randomUUID().toString().replace("-","")+"."+fileExt;
        System.out.println(failName);

        Files.copy(file.getInputStream(),new File(HouseUtil.IMAGE_ADR+failName).toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println(HouseUtil.HOUSE +"image?name" + fileExt);
        return HouseUtil.HOUSE +"image?name=" +failName;
    }
}
