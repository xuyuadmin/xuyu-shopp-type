package com.xuyu.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.xuyu.common.pojo.EasyUITreeNode;

public interface ItemCatService {

	List<EasyUITreeNode>getItemcatList(@RequestParam("id")long parentId);
}
