package pc03980.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@NamedQueries({
	@NamedQuery(name = "Video.FindAll", query ="from Video")
})

@Entity
@Table
public class Video {
@Id
private String id;
private String title;
private String poster;
private int views;
private String description;
private String genre;
private boolean active;
@OneToMany(mappedBy = "video")
List <Favorite> favorites;
@OneToMany(mappedBy = "videoShare")
List <Share> shares;
public List<Share> getShares() {
	return shares;
}
public void setShares(List<Share> shares) {
	this.shares = shares;
}
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
public String getPoster() {
	return poster;
}
public void setPoster(String poster) {
	this.poster = poster;
}
public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public List<Favorite> getFavorites() {
	return favorites;
}
public void setFavorites(List<Favorite> favorites) {
	this.favorites = favorites;
}

}