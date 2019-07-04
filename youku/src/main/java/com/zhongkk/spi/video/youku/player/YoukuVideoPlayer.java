package com.zhongkk.spi.video.youku.player;

import com.zhongkk.spi.video.player.VideoPlayer;

/**
 * Description 业务描叙信息
 *
 * @author Created by 叶半仙 on 2019/7/3.
 */
public class YoukuVideoPlayer implements VideoPlayer {
    /**
     * 播放
     *
     * @param url
     * @return
     */
    @Override
    public String play(String url) {
        return playerName()+": 先来个150秒的广告吧，骚年 ： "+url.toLowerCase();
    }

    /**
     * 获取对应时长
     *
     * @param url
     */
    @Override
    public long duration(String url) {
        return url.length()<<1;
    }

    /**
     * 播放器名称
     *
     * @return
     */
    @Override
    public String playerName() {
        return "优酷视频，享你所想,享受双倍时长";
    }

    /**
     * 播放器版本
     */
    @Override
    public String playerVersion() {
        return "1.0.0-SNAPSHOT";
    }

}
