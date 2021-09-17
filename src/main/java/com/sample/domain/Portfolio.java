package com.sample.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sample.web.PersonResolver;

@Entity
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "portfolio name is required")
	private String name;
	
	@OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
	@NotNull(message = "portfolio manager is required")
	@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = PersonResolver.class)
	private Person manager;
	
	@NotNull(message = "portfolio inception date is required")
	private LocalDate inceptionDate;
	
	private LocalDate closeDate;

	public Portfolio() {
		super();
	}

	public Portfolio(Long id, String name, Person manager, LocalDate inceptionDate, LocalDate closeDate) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.inceptionDate = inceptionDate;
		this.closeDate = closeDate;
	}

	public Portfolio(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Person getManager() {
		return manager;
	}

	public LocalDate getInceptionDate() {
		return inceptionDate;
	}

	public LocalDate getCloseDate() {
		return closeDate;
	}
	
	
}
