package com.wdtt.ttdw.web;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wdtt.ttdw.entity.service.NoticeService;

/**
 * 공지사항 컨트롤러
 */
@Controller
public class NoticeController {
	
	private NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}
	
	/**
	 * 공지사항 목록
	 */
	@RequestMapping("/notice")
	public ResponseEntity<?> list(Model model, @PageableDefault(sort = "createDate", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("notices", noticeService.findAll(pageable));
		return ResponseEntity.ok(noticeService.findAll(pageable));
	}
	
	@GetMapping("/notice/{id}")
	public String view(@PathVariable long id, Model model, @PageableDefault(sort = "createDate", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("notices", noticeService.findAll(pageable));
		return "notice/view";
	}
}
