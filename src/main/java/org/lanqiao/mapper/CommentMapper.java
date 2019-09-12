package org.lanqiao.mapper;

import org.lanqiao.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer comId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer comId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}