package com.zhongkk.spi.video.tencent.player;

import com.zhongkk.spi.video.player.VideoPlayer;

/**
 * Description 业务描叙信息
 *
 * @author Created by 半仙 on 2019/7/3.
 */
public class TencentVideoPlayer implements VideoPlayer {
    /**
     * 播放
     *
     * @param url
     * @return
     */
    @Override
    public String play(String url) {
        return playerName()+": "+url;
    }

    /**
     * 获取对应时长
     *
     * @param url
     */
    @Override
    public long duration(String url) {
        return url.length();
    }

    /**
     * 播放器名称
     *
     * @return
     */
    @Override
    public String playerName() {
        return "腾讯视频";
    }

    /**
     * 播放器版本
     */
    @Override
    public String playerVersion() {
        return "1.0.0-SNAPSHOT";
    }

}
