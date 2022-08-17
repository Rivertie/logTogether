package com.wdtt.ttdw.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	private String email;

	@Column(length = 100, nullable = false)
	private String password;
	
	private String status;
	
	@ManyToMany
	private List<Board> likeBoards = new ArrayList<>();
	
	@OneToMany
	private List<Team> teams = new ArrayList<>();

	@Builder
	public Member(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

}
