package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//область
	@Column(length = 100, nullable = false)
	private String region;
	//район
	@Column(length = 100, nullable = false)
	private String district;
	//город
	@Column(length = 100, nullable = false)
	private String city;
	//улица
	@Column(length = 100, nullable = false)
	private String street;
	//номер дома
	@Column(length = 100)
	private String house;
	//квартира
	@Column(length = 100)
	private String apartment;
}
