package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate dateDepart;
	private int heureDepart;
	private int heureArrivee;
	private LocalDate dateArrivee;
	private Boolean ouvert;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAeroportDepart")
	private Aeroport aeroportDepart;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAeroportArrivee")
	private Aeroport aeroportArrivee;
	
	@OneToMany(mappedBy = "vol")
	private List<InfosEscale> listEscale;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idC")
	private CompagnieAerienne compagnie;
	
	@OneToMany(mappedBy = "vol")
	private List<Reservation> listReservation;
	
	
	
	
	

	public Vol() {
		super();
	}

	public Vol(LocalDate dateDepart, int heureDepart, int heureArrivee, LocalDate dateArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.dateArrivee = dateArrivee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}

	public int getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(int heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public LocalDate getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public List<InfosEscale> getListEscale() {
		return listEscale;
	}

	public void setListEscale(List<InfosEscale> listEscale) {
		this.listEscale = listEscale;
	}

	public CompagnieAerienne getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(CompagnieAerienne compagnie) {
		this.compagnie = compagnie;
	}

	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public Boolean getOuvert() {
		return ouvert;
	}

	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}

	@Override
	public String toString() {
		return "Vol [id=" + id + ", dateDepart=" + dateDepart + ", heureDepart=" + heureDepart + ", heureArrivee="
				+ heureArrivee + ", dateArrivee=" + dateArrivee + ", ouvert=" + ouvert + ", aeroportDepart="
				+ aeroportDepart + ", aeroportArrivee=" + aeroportArrivee + ", listEscale=" + listEscale
				+ ", compagnie=" + compagnie + ", listReservation=" + listReservation + "]";
	}
	
	
	
	
}
