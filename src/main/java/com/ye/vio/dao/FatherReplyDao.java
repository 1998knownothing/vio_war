package com.ye.vio.dao;

import com.ye.vio.entity.FatherReply;
import org.apache.ibatis.annotations.Param;

public interface FatherReplyDao {

    int insertFatherReply(FatherReply fatherReply);

    int deleteFatherReplyByUserIdAndFatherReplyId(@Param("userId") String userId,@Param("fatherReplyId") String fatherReplyId);

    int updateTopicCommentNum(@Param("type")int type, @Param("topicId") String topicId);

}
