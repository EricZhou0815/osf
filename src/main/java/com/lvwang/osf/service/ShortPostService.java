package com.lvwang.osf.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lvwang.osf.model.ShortPost;
import com.lvwang.osf.util.Property;

@Service("shortPostService")
public class ShortPostService extends PostService{

	public Map<String, Object> newPost(Integer author, String content){		
		Map<String, Object> map = new HashMap<String, Object>();
		if(content == null || content.length() == 0){
			map.put("status", Property.ERROR_POST_EMPTY);
			return map;
		}
		ShortPost spost = new ShortPost();
		spost.setPost_author(author);
		spost.setPost_content(content);
		spost.setId(savePost(spost));
		map.put("spost", spost);
		map.put("status", Property.SUCCESS_POST_CREATE);
		return map;
	}
}
