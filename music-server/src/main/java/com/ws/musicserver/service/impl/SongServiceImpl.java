package com.ws.musicserver.service.impl;

import com.ws.musicserver.dao.SongMapper;
import com.ws.musicserver.domain.Song;
import com.ws.musicserver.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 歌曲Service实现类
 * @date 2020/12/6 10:39
 */
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    //  增加
    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song)>0;
    }

    //  修改
    @Override
    public boolean update(Song song) {
        return songMapper.update(song)>0;
    }

    //  删除
    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id)>0;
    }

    //  根据主键查询整个对象
    @Override
    public Song selectByPrimaryKey(Integer id) {
        return songMapper.selectByPrimaryKey(id);
    }

    //  查询所有歌曲
    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    /*  根据歌名精确查询列表
     *   @param name
     * */
    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }

    /*  根据歌名模糊查询列表
     *   @param name
     * */
    @Override
    public List<Song> likeSongOfName(String name) {
        return songMapper.likeSongOfName("%"+name+"%");
    }

    /*  根据歌手id查询
     *   @param singerId
     * */
    @Override
    public List<Song> songOfSingerId(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }
}
