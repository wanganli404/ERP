package com.hnun.erp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnun.erp.bean.StoreAlert;
import com.hnun.erp.bean.Storedetail;
import com.hnun.erp.exception.ERPException;
import com.hnun.erp.mapper.StoredetailMapper;
import com.hnun.erp.service.StoreDetailService;
import com.hnun.erp.util.MailUtil;



@Service
public class StoreDetailServiceImpl extends BaseServiceImpl<Storedetail> implements StoreDetailService{

	
	StoredetailMapper storedetailMapper;
	@Autowired
	MailUtil  mailUtil;
	
	@Autowired
	public void setDepMapper(StoredetailMapper storedetailMapper) {
		this.storedetailMapper = storedetailMapper;
		this.baseMapper = storedetailMapper;
	}

	@Override
	public List<StoreAlert> getStorealertList() {
		
		return storedetailMapper.getStroealertList();
	}

	@Override
	public void sendStorealertMail(String to, String subject, String text) {
		//获取库存预警列表
				List<StoreAlert> list = storedetailMapper.getStroealertList();
				//获取list的个数
				int size = null == list?0:list.size();
				//判断count
				if (size>0) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
						//对页面传输过来的数据加工:_Time:[time]	
						subject+="_Time:"+sdf.format(new Date());
						//仓库中已有[count]种商品需要进货了
						text+=",仓库中已有"+String.valueOf(size)+"种商品需要进货了,请登录系统查看";
						//发送邮件
						mailUtil.sendMail(to, subject,text);
					} catch (MessagingException e) {
						e.printStackTrace();
						throw new ERPException("发用预警邮件失败!");
					}
				}else {
					throw new ERPException("没有需要发送预警邮件的商品");
				}
	}
		
	

	
}
