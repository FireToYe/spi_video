package com.zhongkk.spi.video.driver;

import com.zhongkk.spi.video.player.VideoPlayer;

/**
 * Description 业务描叙信息
 *
 * @author Created by 半仙 on 2019/7/3.
 */
public interface VideoPlayerDriver {

    /**
     * 获取对应的播放器
     * @param url
     * @return
     * @throws IllegalAccessException
     */
    VideoPlayer getPlayer(String url) throws IllegalAccessException;

    /**
     * 是否支持对应的url
     * @param url
     * @return
     */
    boolean support(String url);
}
