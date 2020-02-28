package com.qianfeng.service;

import com.qianfeng.pojo.Video;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.io.IOException;
import java.util.List;

public interface VideoService {
    /**
     * 上传视频
     * @param video
     * @param multipartFile
     * @param request
     * @return
     */
    boolean upload(Video video, MultipartFile multipartFile, HttpServletRequest request)throws IOException;

    List<Video> selectVideo(int business_id );
}
