package com.zhongkk.spi.video.driver;

import com.zhongkk.spi.video.player.VideoPlayer;

/**
 * Description 业务描叙信息
 *
 * @author Created by 半仙 on 2019/7/3.
 */
public interface VideoPlayerDriver {

    VideoPlayer getPlayer(String url) throws IllegalAccessException;

    boolean support(String url);
}
