package com.qianfeng.service.impl;

import com.qianfeng.dao.VideoDao;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Video;
import com.qianfeng.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoDao videoDao;

    @Override
    public List<Video> selectVideo(int business_id ) {
        return videoDao.selectVideo( business_id );
    }

    /**
     * 实现视频的上传
     * @param video
     * @param multipartFile
     * @param request
     * @return
     */
    @Override
    public boolean upload(Video video, MultipartFile multipartFile, HttpServletRequest request) throws IOException {

        //========文件上传============start=================================
        //1 设置当前的文件放在哪一个路径下，（全路径：路径+文件名.扩展名）定义成File
        //（1.1）获取项目的根目录
        String projectPath = request.getServletContext().getRealPath("");
        //(1.2) 设置文件的全路径
        String filePath = projectPath+"/video/"+multipartFile.getOriginalFilename();
        //（1.3）创建file对象
        File file = new File(filePath);

        //2 判断路径是否存在，如果不存在，则创建对应的父路径
        File fileParentFile = file.getParentFile();
        if(!fileParentFile.exists()){
            fileParentFile.mkdirs();
        }
        //3 创建文件（路径+文件名.扩展名）空文件
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file+"======================");
        // 4 转移文件
        multipartFile.transferTo(new File(filePath));
        //============================end=========================


        //=========数据保存==============start==============================
        Business business = (Business) request.getSession().getAttribute("business");

        //1.获取数据
        video.setVideo_src("/video/"+multipartFile.getOriginalFilename());
        video.setBusiness_id(business.getBusiness_id());


        //获取对应Dao层
        int res = videoDao.insertVideo(video);

        //带着相关参数执行数据库方法，返回结果即可
        //===============================end=================================
        if(res>0){
            return true;
        }else{
            return false;
        }

    }
}
