package org.lanqiao.mapper;

import org.lanqiao.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
	int deleteByPrimaryKey(Integer comId);


	int insertSelective(Comment record);


	int updateByPrimaryKeySelective(Comment record);
    List<Comment> selectAllComment(Integer shopId);

	List<Comment> SelectOpinion(Integer shopId, Integer level);
}