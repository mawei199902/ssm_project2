package com.qianfeng.controller;

import com.qianfeng.pojo.Video;
import com.qianfeng.service.VideoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/VideoController")
public class VideoController {
    @Autowired
    VideoService videoService;

    /*    @RequestMapping("/getSystemUserAllInfo")
    public String getSystemUserAllInfo(HttpServletRequest request){
        List<SystemUserAndUsername> list = systemUserService.getSystemUserAllInfo();
        request.setAttribute("list",list);
        return "../page/system/systemoper.jsp";
    }*/

    @RequestMapping("/selectVideo")
    @ResponseBody
    public String selectVideo(HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Video)session.getAttribute("list")).getBusiness_id();
         List<Video> list = videoService.selectVideo(business_id);
        request.setAttribute("list",list);
        return "../page/video/quaryVideo.jsp";
    }

    @RequestMapping("/uploadVideo")
    public String uploadVideo(Video video, @RequestParam("videoFile") MultipartFile multipartFile, HttpServletRequest request){
        boolean result = false;
        System.out.println(video.getVideo_title());
        System.out.println(multipartFile+"========================");
        //1执行上传功能
        try {
            result = videoService.upload(video,multipartFile,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //处理反馈数据
        if (result){
            return "../page/video/addVideo.jsp";
        }else{
            return null;
        }


    }
}
