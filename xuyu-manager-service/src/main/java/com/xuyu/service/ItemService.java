package com.xuyu.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.xuyu.common.pojo.EUDataGridResult;
import com.xuyu.pojo.TbItem;


public interface ItemService {

	TbItem getItemById(@RequestParam("itemId")long itemId);
	
	EUDataGridResult getItemList(int page,int rows);
}
