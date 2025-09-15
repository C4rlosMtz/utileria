package com.mtz.utileria.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Usuario implements Serializable {
	private static final long serialVersionUID = 4404003914264219757L;

	@Id
	private Integer id;
	private String nombre;

}
