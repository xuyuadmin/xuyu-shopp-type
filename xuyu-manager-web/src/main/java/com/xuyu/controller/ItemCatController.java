package com.xuyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuyu.common.pojo.EasyUITreeNode;
import com.xuyu.service.ItemCatService;

/**
 * 商品分类管理controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode>getItemCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		List<EasyUITreeNode> list = itemCatService.getItemcatList(parentId);
		return list;
	}
}
