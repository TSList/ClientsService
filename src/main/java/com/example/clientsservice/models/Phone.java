package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;

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
}
