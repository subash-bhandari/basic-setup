package com.sajhasite.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment_contents")
public class CommentContent extends AbstractEntity {	
	private static final long serialVersionUID = 1L;
	
	private Long commentId;
	
	private Comment comment;
	private String content;
	
//	@Id
//	@Column(name="comment_id")
//	public Long getPostId() {
//		return postId;
//	}
//
//	public void setPostId(Long postId) {
//		this.postId = postId;
//	}
	
	@Id
	@Column(name="comment_id")
	public Long getCommentId() {
		return commentId;
	}



	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}



	

	
	@MapsId
	@OneToOne(mappedBy="commentContent")
	@JoinColumn(name="comment_id")
	public Comment getComment() {
		return comment;
	}

	

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	

	@Column(name="content", length=16777215)
	public String getContent() {
		return content;
	}

	

	public void setContent(String content) {
		this.content = content;
	}

}
