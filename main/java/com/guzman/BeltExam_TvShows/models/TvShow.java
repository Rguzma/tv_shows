package com.guzman.BeltExam_TvShows.models;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.JoinColumn;
@Entity
@Table(name="tvShows")
public class TvShow {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tvShow_id;
    @NotNull
    @Size(min = 3, max = 20)
    private String title;
    private String network;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_at;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updated_at;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ratings", 
        joinColumns = @JoinColumn(name = "tvShow_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> user;
    private double rating;
    
    public TvShow (){
    	
    }


	public TvShow(@NotNull @Size(min = 3, max = 20) String title, String network) {

		this.title = title;
		this.network = network;
	}


	public Long getTvShow_id() {
		return tvShow_id;
	}


	public void setTvShow_id(Long tvShow_id) {
		this.tvShow_id = tvShow_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getNetwork() {
		return network;
	}


	public void setNetwork(String network) {
		this.network = network;
	}

	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}
	

	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


	public Date getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
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
