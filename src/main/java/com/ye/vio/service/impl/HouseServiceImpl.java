package com.ye.vio.service.impl;

import com.ye.vio.dao.HouseDao;
import com.ye.vio.dao.HouseImgDao;
import com.ye.vio.dto.RentCondition;
import com.ye.vio.entity.House;
import com.ye.vio.entity.HouseImg;
import com.ye.vio.service.HouseService;
import com.ye.vio.util.ImageUtil;
import com.ye.vio.util.PageUtil;
import com.ye.vio.util.PathUtil;
import com.ye.vio.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
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
        return houseDao.queryHouseByHouseId(houseId);
    }

    @Override
    public List<House> getHouseList(RentCondition rentCondition, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);

        return houseDao.queryHouseList(rentCondition,rowIndex,pageSize);
    }

    @Override
    public List<House> getHouseListByUserId(String userId, int pageIndex, int pageSize) {
        int rowIndex= PageUtil.pageIndexToRowIndex(pageIndex,pageSize);
        return houseDao.queryHouseListByUserId(userId,rowIndex,pageSize);
    }

    @Override
    @Transactional
    public int addHouse(House house,List<CommonsMultipartFile> houseImgs) {
        if(house!=null&&house.getHouseId()!=null&&house.getUser().getUserId()!=null){
                house.setState(1);
                house.setCreateTime(new Date());
            try {
                int effectedNum = houseDao.insertHouse(house);
                if (effectedNum <= 0) {
                    throw new RuntimeException("创建商品失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("创建商品失败:" + e.toString());
            }
            if(houseImgs!=null&&houseImgs.size()>0){
                addHouseImgs(house,houseImgs);
            }
            return 200;
        }else{

        }

        return 0;
    }

    @Override
    @Transactional
    public int removeHouseByHouseId(String houseId, String userId) {

        try {
            if (houseId != null && userId != null) {
                deleteHouseImgs(houseId);
            }else {
                throw new RuntimeException("删除房源图片失败，houseid 或 userid 不能为空");
            }
        }catch (Exception e){
            throw new RuntimeException(e.toString());
        }

        return houseDao.deleteHouseByHouseId(houseId,userId);
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
            try {
                int effectedNum = houseImgDao.batchInsertHouseImg(houseImgList);
                if (effectedNum <= 0) {
                    throw new RuntimeException("创建商品详情图片失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("创建商品详情图片失败:" + e.toString());
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
