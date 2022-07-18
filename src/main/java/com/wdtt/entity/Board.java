package com.wdtt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	private String content;
	
	private int hits;
	
	private boolean isPublic;
	
	@ManyToMany(mappedBy = "likeBoards")
	private List<Member> likes = new ArrayList<>();
	
	@OneToMany
	private List<Comment> comments = new ArrayList<>();
	
	@OneToMany
	private List<BoardFile> files = new ArrayList<>();
	
	@CreatedDate
	private Date createDate;
	
	@LastModifiedDate
	private Date updateDate;
	
	

	
	
}
