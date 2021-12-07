package com.beans;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nom", "codePostal", "codeInsee", "libelleAcheminement", "ligne5", "coordonnees" })
@Generated("jsonschema2pojo")
public class Ville {

		@JsonProperty("nom")
		private String nom;
		@JsonProperty("codePostal")
		private String codePostal;
		@JsonProperty("codeInsee")
		private String codeInsee;
		@JsonProperty("libelleAcheminement")
		private String libelleAcheminement;
		@JsonProperty("ligne5")
		private String ligne5;
		@JsonProperty("coordonnees")
		private Coordonnees coordonnees;
		public Ville() {	
			super();
		}
		public Ville(String nom,String codePostal,Coordonnees coords,String codeInsee,String libelleAcheminement,String ligne5) {
			super();
			this.setNom(nom);
			this.setCodePostal(codePostal);
			this.setCodeInsee(codeInsee);
			this.setLibelle(libelleAcheminement);
			this.setLigne5(ligne5);
			this.setCoordonnees(coords);
			
		}
		@JsonProperty("nom")
		public String getNom() {
			return nom;
		}

		@JsonProperty("nom")
		public void setNom(String nom) {
			this.nom = nom;
		}

		@JsonProperty("codePostal")
		public String getCodePostal() {
			return codePostal;
		}

		@JsonProperty("codePostal")
		public void setCodePostal(String codePostal) {
			this.codePostal = codePostal;
		}

		@JsonProperty("codeInsee")
		public String getCodeInsee() {
			return codeInsee;
		}

		@JsonProperty("codeInsee")
		public void setCodeInsee(String codeInsee) {
			this.codeInsee = codeInsee;
		}

		@JsonProperty("libelleAcheminement")
		public String getLibelle() {
			return libelleAcheminement;
		}

		@JsonProperty("libelleAcheminement")
		public void setLibelle(String libelleAcheminement) {
			this.libelleAcheminement = libelleAcheminement;
		}

		@JsonProperty("ligne5")
		public String getLigne5() {
			return ligne5;
		}

		@JsonProperty("ligne5")
		public void setLigne5(String ligne5) {
			this.ligne5 = ligne5;
		}

		@JsonProperty("coordonnees")
		public Coordonnees getCoordonnees() {
			return coordonnees;
		}

		@JsonProperty("coordonnees")
		public void setCoordonnees(Coordonnees coordonnees) {
			this.coordonnees = coordonnees;
		}

	
	public double distanceWith(Ville ville) {
		
		double latA = Double.parseDouble(this.getCoordonnees().getLatitude())*Math.PI/180;
		double longA = Double.parseDouble(this.getCoordonnees().getLongitude())*Math.PI/180;
		double latB = Double.parseDouble(ville.getCoordonnees().getLatitude())*Math.PI/180;
		double longB = Double.parseDouble(ville.getCoordonnees().getLongitude())*Math.PI/180;
		double a = Math.pow(Math.sin((latB-latA)/2), 2) + Math.cos(latA)*Math.cos(latB)*Math.pow(Math.sin((longB-longA)/2), 2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = 6371*c;
		return (double) Math.round(d * 100) / 100; // arrondi au cientième
	}

}
