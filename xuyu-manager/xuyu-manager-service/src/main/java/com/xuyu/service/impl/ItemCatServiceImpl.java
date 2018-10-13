package com.xuyu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.xuyu.common.pojo.EasyUITreeNode;
import com.xuyu.mapper.TbItemCatMapper;
import com.xuyu.pojo.TbItemCat;
import com.xuyu.pojo.TbItemCatExample;
import com.xuyu.pojo.TbItemCatExample.Criteria;
import com.xuyu.service.ItemCatService;
/**
 * 商品分类管理service
 * @author Administrator
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Override
	public List<EasyUITreeNode> getItemcatList(@RequestParam("id")long parentId) {
		//根据parentId查询分类列表
		TbItemCatExample example=new TbItemCatExample();
		//设置查询条件
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//转换成EasyUITreeNode列表
		ArrayList<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			//创建一个节点对象
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			//添加到列表中
			resultList.add(node);
		}
		return resultList;
	}

}
