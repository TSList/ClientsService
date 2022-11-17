package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "phones")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20, nullable = false)
	private String phone;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id",nullable = false,
		foreignKey = @ForeignKey(name = "FK_phones_clientsservice"))
	private Client client;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Phone phone1 = (Phone) o;
		return Objects.equals(id, phone1.id) && Objects.equals(phone, phone1.phone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, phone);
	}

	@Override
	public String toString() {
		return "Phone{" +
			"id=" + id +
			", phone='" + phone + '\'' +
			'}';
	}
}
