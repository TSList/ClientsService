package com.example.clientsservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//
@Entity
@Table(name = "clients")
public class Client {

	public enum Gender{
		NONE,MALE,FEMALE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, nullable = false)
	private String surname;
	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String patronymic;
	@Column(nullable = false, columnDefinition = "int(1) default 0")
	private Gender gender;
	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@Column(columnDefinition = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	private Set<Phone> phones;

	@ManyToMany(fetch = FetchType.LAZY)//,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name = "clients_accounts",
		joinColumns = 	@JoinColumn(name = "client_id"),
		inverseJoinColumns = @JoinColumn(name = "account_id"))
	private Set<Account> accounts;


	public Client(Integer id, String surname, String name, String patronymic, Gender gender, String email, Set<Phone> phones, Set<Account> accounts, Address address) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.gender = gender;
		this.email = email;
		this.phones = phones;
		this.accounts = accounts;
		this.address = address;
	}

	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", referencedColumnName = "id",
		foreignKey = @ForeignKey(name = "FK_clients_address"))
	private Address address;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Client client = (Client) o;
		return Objects.equals(id, client.id) && Objects.equals(surname, client.surname) && Objects.equals(name, client.name) && Objects.equals(patronymic, client.patronymic) && gender == client.gender && Objects.equals(email, client.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, surname, name, patronymic, gender, email);
	}


	@Override
	public String toString() {
		return "Client{" +
			"id=" + id +
			", surname='" + surname + '\'' +
			", name='" + name + '\'' +
			", patronymic='" + patronymic + '\'' +
			", gender=" + gender +
			", email='" + email + '\'' +
			", birthDate=" + birthDate +
			", phones=" + phones +
			", accounts=" + accounts +
			", address=" + address +
			'}';
	}
}
