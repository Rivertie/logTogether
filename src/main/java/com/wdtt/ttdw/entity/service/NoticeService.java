package com.wdtt.ttdw.entity.service;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wdtt.ttdw.entity.Notice;
import com.wdtt.ttdw.entity.repository.NoticeRepository;

/**
 * 공지사항 서비스를 처리합니다.
 */
@Service
public class NoticeService {
	
	private NoticeRepository noticeRepositiory;

	public NoticeService(NoticeRepository noticeRepositiory) {
		super();
		this.noticeRepositiory = noticeRepositiory;
	}
	
	public Page<Notice> findAll(Pageable pageable) {
		return noticeRepositiory.findAll(pageable);
	}
	
	public Notice findById(Long id) {
		return noticeRepositiory.findById(id)
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시물입니다."));
	}
	
}
