package org.lanqiao.mapper;

import org.lanqiao.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer comId);



    int insertSelective(Comment record);



    int updateByPrimaryKeySelective(Comment record);


}