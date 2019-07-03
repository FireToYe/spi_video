package com.zhongkk.spi.video.player;

/**
 * Description 业务描叙信息
 *
 * @author Created by 半仙 on 2019/7/3.
 */
public interface VideoPlayer {
    /**
     * 播放
     * @param url
     * @return
     */
    String play(String url);

    /**
     * 获取对应时长
     */
    long duration(String url);

    /**
     * 播放器名称
     * @return
     */
    String playerName();

    /**
     * 播放器版本
     */
    String playerVersion();
}
