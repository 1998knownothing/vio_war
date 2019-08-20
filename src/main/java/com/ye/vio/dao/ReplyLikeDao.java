package com.ye.vio.dao;


import com.ye.vio.entity.ReplyLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ReplyLikeDao {


    public int insertReplyLike(ReplyLike replyLike);

    public List<ReplyLike> queryReplyLikeByReplyIdAndUserId(ReplyLike replyLike);

    public int updateReplyNum(@Param("type") int type, @Param("sonReplyId") String sonReplyId,@Param("fatherReplyId") String fatherReplyId);

    public int deleteReplyLike(@Param("userId") String userId, @Param("sonReplyId") String sonReplyId,@Param("fatherReplyId") String fatherReplyId);
}
