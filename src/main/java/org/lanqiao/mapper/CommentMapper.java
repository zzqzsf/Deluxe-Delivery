package org.lanqiao.mapper;

import org.lanqiao.entity.Comment;

public interface CommentMapper {
	int deleteByPrimaryKey(Integer comId);


	int insertSelective(Comment record);


	int updateByPrimaryKeySelective(Comment record);


}