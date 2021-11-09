package com.guzman.BeltExam_TvShows.models;


import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.springframework.format.annotation.DateTimeFormat;

;


@Entity
@Table(name="ratings")

public class Rating {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private double rating;
    @Column(updatable=false)
    private Date created_at;
    private Date updated_at;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tvShow_id")
    private TvShow tvShow;
    
    
    public Rating() {
    	
        
    }

	public Rating(double rating) {

		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Date createdAt) {
		this.created_at = createdAt;
	}

	public Date getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updated_at = updatedAt;
	}
	
	public TvShow getTvShow() {
		return tvShow;
	}

	public void setTvShowId(TvShow tvShow) {
		this.tvShow = tvShow;
	}
    
    @PrePersist
    protected void onCreate(){
        this.created_at = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updated_at = new Date();
    }

}
