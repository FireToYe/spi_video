package com.zhongkk.spi.video.tencent.driver;

import com.zhongkk.spi.video.driver.VideoPlayerDriver;
import com.zhongkk.spi.video.manager.VideoPlayerManager;
import com.zhongkk.spi.video.player.VideoPlayer;
import com.zhongkk.spi.video.tencent.player.TencentVideoPlayer;

import java.sql.DriverManager;
import java.util.regex.Pattern;

/**
 * Description 腾讯视频播放驱动
 *
 * @author Created by 叶半仙 on 2019/7/3.
 */
public class TencentVideoPlayerDriver implements VideoPlayerDriver {
    /**
     * 如果url的格式是http://www.vip.qq.com/的格式，代表需要使用腾讯视频的播放器
     */
    public static final String  REGEX = "^http(s)?://www\\.vip\\.qq\\.com/[A-Za-z0-9\\.]*";
    public static final Pattern PATTERN = Pattern.compile(REGEX);
    @Override
    public VideoPlayer getPlayer(String url) {
        if (support(url)){
            // 此处可扩展成工厂或单例模式，直接new也是不太符合规范的
            return new TencentVideoPlayer();
        }
        throw new RuntimeException("该url不支持");
    }

    @Override
    public boolean support(String url) {
        return PATTERN.matcher(url).matches();
    }


    static{
        // 向VideoPlayerDriver注册驱动
        VideoPlayerManager.registered(new TencentVideoPlayerDriver());
    }
}
