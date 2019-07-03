package com.zhongkk.spi.video.example;

import com.zhongkk.spi.video.manager.VideoPlayerManager;
import com.zhongkk.spi.video.player.VideoPlayer;

import java.sql.DriverManager;

/**
 * Description 业务描叙信息
 *
 * @author Created by 半仙 on 2019/7/3.
 */
public class Main {
    public static void main(String[] args) {
        testTencent();
        testYouku();
    }

    public static void testTencent() {
        String url = "http://www.vip.qq.com/zhongkk.mp4";
        VideoPlayer player = VideoPlayerManager.player(url);
        System.out.println("=====  "+player.playerName()+"播放器欢迎您  =====");
        System.out.println(player.play(url));
        System.out.println("时长： "+player.duration(url)+"分钟");
    }
    public static void testYouku() {
        String url = "http://www.youku.com/zhongkk.mp4";
        VideoPlayer player = VideoPlayerManager.player(url);
        System.out.println("=====  "+player.playerName()+"播放器欢迎您  =====");
        System.out.println(player.play(url));
        System.out.println("时长： "+player.duration(url)+"分钟");
    }
}
