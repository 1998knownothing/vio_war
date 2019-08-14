package com.ye.vio.service.impl;

import com.ye.vio.dao.TopicDao;
import com.ye.vio.entity.Topic;
import com.ye.vio.service.TopicService;
import com.ye.vio.util.PageUtil;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.TopicVo;
import com.ye.vio.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description:话题服务
 * @author: Mr.liu
 * @create: 2019-08-10 14:17
 **/
@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    private TopicDao topicDao;

    @Override
    public TopicVo getTopicByTopicId(String topicId) {

        return topicDao.queryTopicByTopicId(topicId);
    }

    @Override
    public List<Topic> getTopicList(String keyword, int type, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return topicDao.queryTopicList(keyword,type,rowIndex,pageSize);
    }

    @Override
    public List<Topic> getTopicListByUserId(String userId, int type, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return topicDao.queryTopicListByUserId(userId,type,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addTopic(Topic topic) {
        topic.setTopicId(UUIDUtils.UUID());
        UserVo userVo=new UserVo();
        userVo.setUserId("1");
        topic.setUserVo(userVo);
        topic.setCreateTime(new Date());
        return topicDao.insertTopic(topic);
    }

    @Override
    @Transactional
    public int removeTopic(String topicId, String userId) {
        return topicDao.deleteTopic(topicId,userId);
    }
}
