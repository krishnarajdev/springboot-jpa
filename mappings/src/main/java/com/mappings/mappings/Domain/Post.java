package com.mappings.mappings.Domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Post")
@Table(name = "post")
public class Post implements Serializable{
 
    @Id
    @GeneratedValue
    private Long id;
 
    private String title;
 
    @JsonManagedReference
    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
              fetch = FetchType.LAZY, optional = false)
    private PostDetails details;
 
    //Getters and setters omitted for brevity
 
    public void setDetails(PostDetails details) {
        if (details == null) {
            if (this.details != null) {
                this.details.setPost(null);
            }
        }
        else {
            details.setPost(this);
        }
        this.details = details;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PostDetails getDetails() {
		return details;
	}
}