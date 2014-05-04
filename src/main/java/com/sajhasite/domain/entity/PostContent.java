package com.sajhasite.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post_contents")
public class PostContent extends AbstractEntity {	
	private static final long serialVersionUID = 1L;
	
	private Long postId;
	
	private Post post;
	private String content;
	
	@Id
	@Column(name="post_id")
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	
	
	
	@MapsId
	@OneToOne(mappedBy="postContent")
	@JoinColumn(name="post_id")
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Column(name="content", length=16777215)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
