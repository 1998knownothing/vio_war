package com.ye.vio.service;

import com.ye.vio.entity.FatherReply;



public interface FatherReplyService {

    int addFatherReply(FatherReply fatherReply);

    int removeFatherReplyByUserIdAndFatherReplyId( String userId, String fatherReplyId,String topicId);


}
