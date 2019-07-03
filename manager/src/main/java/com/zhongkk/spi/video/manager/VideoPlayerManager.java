package com.zhongkk.spi.video.manager;

import com.sun.istack.internal.NotNull;
import com.zhongkk.spi.video.driver.VideoPlayerDriver;
import com.zhongkk.spi.video.player.VideoPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.time.temporal.Temporal;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Description 业务描叙信息
 *
 * @author Created by 半仙 on 2019/7/3.
 */
public class VideoPlayerManager {
    /**
     * 处理器集合
     */
    private final static CopyOnWriteArrayList<VideoPlayerDriver> registeredDrivers = new CopyOnWriteArrayList<>();


    private static final Logger logger = LoggerFactory.getLogger( VideoPlayerManager.class );
    static {
        loadInitialPlayers();
        logger.debug("加载驱动完成");
    }
    private static void loadInitialPlayers(){
        ServiceLoader<VideoPlayerDriver> serviceLoader = ServiceLoader.load(VideoPlayerDriver.class);
        Iterator<VideoPlayerDriver> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
    }

    /**
     * 获取对应的播放器
     * @param url
     * @return
     */
    public static VideoPlayer player(String url){
        VideoPlayer videoPlayer = null;
        for (VideoPlayerDriver  driver:registeredDrivers){
            try {
                    videoPlayer = driver.getPlayer(url);
                    break;
            }catch (Exception e){
                logger.debug("驱动器：{}，处理发生异常",driver.getClass(),e);
            }
        }
        return videoPlayer;
    }

    /**
     * 获取所有的驱动器
     * @return
     */
    public static  List<VideoPlayerDriver> getDrivers(){
        List<VideoPlayerDriver> videoPlayerDrivers = new LinkedList<>();
        registeredDrivers.forEach(e->videoPlayerDrivers.add(e));
        return videoPlayerDrivers;
    }

    public static synchronized void registered(VideoPlayerDriver videoPlayerDriver){
        logger.info("注册驱动：{}",videoPlayerDriver.getClass());
        registeredDrivers.addIfAbsent(videoPlayerDriver);
    }
    public static void main(String[] args) {
       logger.info("测试驱动加载");
    }
}
