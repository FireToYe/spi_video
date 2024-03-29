package com.zhongkk.spi.video.youku.driver;

import com.zhongkk.spi.video.driver.VideoPlayerDriver;
import com.zhongkk.spi.video.manager.VideoPlayerManager;
import com.zhongkk.spi.video.player.VideoPlayer;
import com.zhongkk.spi.video.youku.player.YoukuVideoPlayer;

import java.util.regex.Pattern;

/**
 * Description 优酷播放器驱动
 *
 * @author Created by 叶半仙 on 2019/7/3.
 */
public class YoukuVideoPlayerDriver implements VideoPlayerDriver {
    /**
     * 如果url的格式是http://www.youku.com/的格式，代表需要使用优酷视频的播放器
     */
    public static final String  REGEX = "^http(s)?://www\\.youku\\.com/[A-Za-z0-9\\.]*";
    public static final Pattern PATTERN = Pattern.compile(REGEX);
    @Override
    public VideoPlayer getPlayer(String url) {
        if (support(url)){
            return new YoukuVideoPlayer();
        }
        throw new RuntimeException("该url不支持");
    }

    @Override
    public boolean support(String url) {
        return PATTERN.matcher(url).matches();
    }

    static{
        VideoPlayerManager.registered(new YoukuVideoPlayerDriver());
    }
}
