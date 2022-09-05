package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴
@Entity
public class Board {
	
	@Id	//Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량 데이터
	private String content;	//썸머노트 라이브러리 <html> 태그가 섞여서 디자인이 됨
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne //Many = board, one = user
	@JoinColumn(name="userId")
	private User user; //DB는 오브젝트를 저장할 수 없다 FK,자바는 오브젝트를 저장할 수 없다.	
	
	@CreationTimestamp //시간이 자동 입력
	private Timestamp createDate;
	
	
	
	
}
