package com.ye.vio.service.impl;

import com.ye.vio.dao.HouseDao;
import com.ye.vio.dao.HouseImgDao;
import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.House;
import com.ye.vio.entity.HouseImg;
import com.ye.vio.enums.CustomizeErrorCode;
import com.ye.vio.exception.CustomizeException;
import com.ye.vio.service.HouseService;
import com.ye.vio.util.ImageUtil;
import com.ye.vio.util.PageUtil;
import com.ye.vio.util.PathUtil;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: vio
 * @description: 房源信息service
 * @author: Mr.liu
 * @create: 2019-08-08 23:53
 **/

@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    HouseDao houseDao;

    @Resource
    HouseImgDao houseImgDao;

    @Override
    public House getHouseByHouseId(String houseId) {
        if (houseId==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        return houseDao.queryHouseByHouseId(houseId);
    }

    @Override
    public List<House> getHouseList(RentCondition rentCondition, int pageIndex, int pageSize) {
        if(pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return houseDao.queryHouseList(rentCondition,rowIndex,pageSize);
    }

    @Override
    public List<House> getHouseListByUserId(String userId, int pageIndex, int pageSize) {
        if(userId==null||pageIndex<=0)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return houseDao.queryHouseListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addHouse(House house,List<CommonsMultipartFile> houseImgs) {
        if(house==null||house.getUser().getUserId()==null)
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);

                house.setHouseId(UUIDUtils.UUID());
                house.setState(1);
                house.setCreateTime(new Date());
        int effectedNum=0;

                effectedNum = houseDao.insertHouse(house);
                if (effectedNum <= 0) {
                    throw new CustomizeException(CustomizeErrorCode.HOUSE_ADD_ERROR);
                }

            if(houseImgs!=null&&houseImgs.size()>0){
                addHouseImgs(house,houseImgs);
            }else
                throw new CustomizeException(CustomizeErrorCode.HOUSE_IMG_UPLOAD_ERROR);

            return effectedNum;

    }

    @Override
    @Transactional
    public int removeHouseByHouseId(String houseId, String userId) {

        int effected=0;

            if (houseId != null && userId != null) {
                deleteHouseImgs(houseId);
            }else {
                throw new CustomizeException(4123,"删除房源图片失败，houseid 或 userid 不能为空");
            }
            effected=houseDao.deleteHouseByHouseId(houseId,userId);
            if(effected<=0)
                throw new CustomizeException(CustomizeErrorCode.HOUSE_DELETE_ERROR);


        return effected;
    }

    private void addHouseImgs(House house, List<CommonsMultipartFile> houseImgs) {
        String dest = PathUtil.getHouseImagePath(house.getHouseId());
        List<String> imgAddrList = ImageUtil.generateNormalImgs(houseImgs, dest);
        if (imgAddrList != null && imgAddrList.size() > 0) {
            List<HouseImg> houseImgList = new ArrayList<HouseImg>();
            for (String imgAddr : imgAddrList) {
                HouseImg houseImg = new HouseImg();
                houseImg.setHouseImgId(UUIDUtils.UUID());
                houseImg.setHouseImgAddr(imgAddr);
                houseImg.setHouseId(house.getHouseId());
                houseImg.setCreateTime(new Date());
                houseImgList.add(houseImg);
            }

                int effectedNum = houseImgDao.batchInsertHouseImg(houseImgList);
                if (effectedNum <= 0) {
                    throw new RuntimeException("创建商品详情图片失败");
                }

        }
    }

    private void deleteHouseImgs(String houseId) {
        List<HouseImg> houseImgList = houseImgDao.queryHouseImgList(houseId);

        for (HouseImg houseImg : houseImgList) {
            ImageUtil.deleteFile(houseImg.getHouseImgAddr());
        }
        houseImgDao.deleteHouseImgByHouseId(houseId);
    }

}
