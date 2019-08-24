package com.ye.vio.service.impl;

import com.ye.vio.dao.TopicDao;
import com.ye.vio.entity.HouseImg;
import com.ye.vio.entity.Topic;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.TopicService;
import com.ye.vio.util.ImageUtil;
import com.ye.vio.util.PageUtil;
import com.ye.vio.util.PathUtil;
import com.ye.vio.util.UUIDUtils;
import com.ye.vio.vo.TopicVo;
import com.ye.vio.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
        if (topicId==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        return topicDao.queryTopicByTopicId(topicId);
    }

    @Override
    public List<Topic> getTopicList(String keyword, int type, int pageIndex, int pageSize) {
        if (pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return topicDao.queryTopicList(keyword,type,rowIndex,pageSize);
    }

    @Override
    public List<Topic> getTopicListByUserId(String userId, int type, int pageIndex, int pageSize) {
        if (userId==null||pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return topicDao.queryTopicListByUserId(userId,type,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addTopic(Topic topic,CommonsMultipartFile file) {
        if (topic.getUserVo().getUserId()==null||topic.getContent()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        topic.setTopicId(UUIDUtils.UUID());
        topic.setCreateTime(new Date());
        int effectedAdd=topicDao.insertTopic(topic);
            if(file!=null){
                addTopicResumImg(topic,file);
            }
        int effectedUpdate=topicDao.updateTopic(topic);
        if (effectedUpdate<=0)
            throw new CustomizeException(CustomizeErrorCode.TOPIC_UPDATE_RESUME_ERROR);
        if (effectedAdd<=0)
            throw new CustomizeException(CustomizeErrorCode.TOPIC_ADD_ERROR);

        return effectedAdd;
    }

    @Override
    @Transactional
    public int removeTopic(String topicId, String userId) {
        if (topicId==null||userId==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

        deleteTopicResumeImgs(topicId);

        int effected=topicDao.deleteTopic(topicId,userId);

        if (effected<=0)
            throw new CustomizeException(CustomizeErrorCode.TOPIC_DELETE_ERROR);

        return effected;
    }

    public void addTopicResumImg(Topic topic, CommonsMultipartFile logo){
        //获取图片目录相对值路径
        String dest= PathUtil.getResumeImagePath(topic.getTopicId());
        String resumeImgAddr= ImageUtil.generateThombnail(logo,dest);
        topic.setResumeImg(resumeImgAddr);
    }

    private void deleteTopicResumeImgs(String topicId) {
      TopicVo topicVo= topicDao.queryTopicByTopicId(topicId);
      ImageUtil.deleteFile(topicVo.getResumeImg());

    }

}
