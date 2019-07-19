package com.sweet.hzy.service.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sweet.bean.UserPay;
import com.sweet.hzy.mapper.UserPayMapper;
import com.sweet.hzy.service.UserPayService;
import com.sweet.util.ServletUtil;
import com.sweet.util.SysException;
@Service
public class UserPayServiceImp implements UserPayService{

	@Resource
	private UserPayMapper userPayMapper;
	
	@Override
	public Map<String,Object> getUserPayList(Integer page,Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 8 : pageSize;
		PageHelper.startPage(page,pageSize);
		Integer id = Integer.valueOf(ServletUtil.getSessionVal("id"));
		List<UserPay> list = userPayMapper.getUserPayList(id);
		PageInfo<UserPay> pageInfo = new PageInfo<UserPay>(list);
		Map<String,Object> map = new HashMap();
		map.put("list",pageInfo.getList());
		map.put("count",userPayMapper.getUserPayCount(id));
		return map;
	}

	@Override
	public int insertUserPay(UserPay pay) {
		pay.setUserid(Integer.valueOf(ServletUtil.getSessionVal("id")));
		return userPayMapper.insertUserPay(pay);
	}

	@Override
	public int deleteUserPay(Integer id) throws SysException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		UserPay pay = userPayMapper.getDeletePayTime(id);
		String now = df.format(new Date());
		String del = df.format(pay.getTime());
		if(!now.equals(del)) throw new SysException("只能删除当天记录");
		return userPayMapper.deleteUserPay(id);
	}

	@Override
	public int updateUserPay(UserPay pay) {
		return userPayMapper.updateUserPay(pay);
	}

	@Override
	public List<UserPay> getMoneyListByWeek(Date time) {
		return userPayMapper.getMoneyListByWeek(Integer.valueOf(ServletUtil.getSessionVal("id")), time);
	}

	@Override
	public List<UserPay> getMoneyListByMonth(Date time) {
		return userPayMapper.getMoneyListByMonth(Integer.valueOf(ServletUtil.getSessionVal("id")), time);
	}

	@Override
	public List<UserPay> getMoneyListByYear(Date time) {
		return userPayMapper.getMoneyListByYear(Integer.valueOf(ServletUtil.getSessionVal("id")), time);
	}

	@Override
	public List<UserPay> getMoneyListByMonthWeek(Date time) {
		return userPayMapper.getMoneyListByMonthWeek(Integer.valueOf(ServletUtil.getSessionVal("id")), time);
	}

	@Override
	public List<UserPay> getMoneyListByDic(Date time) {
		return userPayMapper.getMoneyListByDic(Integer.valueOf(ServletUtil.getSessionVal("id")), time);
	}

	@Override
	public List<UserPay> getMoneyListByDicMonth(Date time) {
		return userPayMapper.getMoneyListByDicMonth(Integer.valueOf(ServletUtil.getSessionVal("id")), time);
	}

}
