package pc05132.hankook.entity;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@NamedQuery(
		name = "Tyre.FindAll",
		query="from Tyre"
		)
@Entity
@Table(name = "tyres")
public class Tyre {
	@Id
	private String idTyre;
	private String nameTyre;
	@OneToMany(mappedBy = "tyre")
	@Cascade(value = CascadeType.REMOVE)
	List<RelProductTyre> detailTyres;
	public String getIdTyre() {
		return idTyre;
	}
	public void setIdTyre(String idTyre) {
		this.idTyre = idTyre;
	}
	public String getNameTyre() {
		return nameTyre;
	}
	public void setNameTyre(String nameTyre) {
		this.nameTyre = nameTyre;
	}
	public List<RelProductTyre> getDetailTyres() {
		return detailTyres;
	}
	public void setDetailTyres(List<RelProductTyre> detailTyres) {
		this.detailTyres = detailTyres;
	}
	@Override
	public String toString() {
		return "Tyre [idTyre=" + idTyre + ", nameTyre=" + nameTyre + ", detailTyres=" + detailTyres + "]";
	}
	
}
