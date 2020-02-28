package com.qianfeng.dao;

import com.qianfeng.pojo.Video;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface VideoDao {

    /**
     * 插入视频相关信息
     * @param video
     * @return
     */

    int insertVideo(Video video);
/*<select id="selectVideo" resultType="com.qianfeng.pojo.Video">*/

    /**
     * 查询视频信息
     * @param business_id
     * @return
     */

    List<Video>selectVideo(int business_id);
}
