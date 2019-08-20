package com.ye.vio.dao;


import com.ye.vio.entity.SonReply;
import org.apache.ibatis.annotations.Param;

public interface SonReplyDao {

    int insertSonReply(SonReply sonReply);

    int deleteSonReplyByUserIdAndSonReplyId(@Param("userId") String userId, @Param("sonReplyId") String sonReplyId);

}
