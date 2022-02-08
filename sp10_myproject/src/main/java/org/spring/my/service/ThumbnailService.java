package org.spring.my.service;

import java.util.List;

import org.spring.my.dto.Page;
import org.spring.my.dto.Thumbnail;

public interface ThumbnailService {
	String makeThumb(String filename);
	List<Thumbnail> selectList(Page page);
}
