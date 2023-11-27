package pc05132.lab6.bai2.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@NamedQueries({
	@NamedQuery(
		    name = "Video.findVideoFavorite",
		    query = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY"
		),
	@NamedQuery(
		    name = "Video.findVideoNotFavorite",
		    query = "SELECT o FROM Video o WHERE o.favorites IS EMPTY"
		)
})
@Entity
@Table(name = "videos")
public class Video {
	@Id
	private String id;
	private String title;
	private String description;
	private String poster;
	private Integer views = 0;
	private Boolean active = true;	
	@OneToMany(mappedBy = "videox")
	private List<Favorite> favorites;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	
}
