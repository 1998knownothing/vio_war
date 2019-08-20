package com.ye.vio.service;

import com.ye.vio.entity.SonReply;

public interface SonReplyService {

    int addSonReply(SonReply sonReply);

    int removeSonReplyByUserIdAndSonReplyId(String userId,  String sonReplyId,String topicId);
}
