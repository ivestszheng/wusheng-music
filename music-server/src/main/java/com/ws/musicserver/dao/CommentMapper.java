package com.ws.musicserver.dao;

import com.ws.musicserver.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 无声 <ivestszheng@qq.com>
 * @version 1.0
 * @descripttion 评论DAO
 * @date 2020/12/18 13:50
 */
@Repository
public interface CommentMapper {
    /**
     *增加
     */
    public int insert(Comment comment);

    /**
     *修改
     */
    public int update(Comment comment);

    /**
     * 删除
     */
    public int delete(Integer id);

    /**
     * 根据主键查询整个对象
     */
    public Comment selectByPrimaryKey(Integer id);

    /**
     * 查询所有评论
     */
    public List<Comment> allComment();

    /**
     * 查询某个歌曲下的所有评论
     */
    public List<Comment> commentOfSongId(Integer songId);

    /**
     * 查询某个歌单下的所有评论
     */
    public List<Comment> commentOfSongListId(Integer songListId);
}
