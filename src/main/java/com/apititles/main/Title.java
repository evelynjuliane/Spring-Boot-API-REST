package com.apititles.main;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	@NotNull(message = "Error: Descrição é um campo obrigatório!")
	@Size(min = 0, max =  40, message = "Error: A descrição não pode conter mais de 40 caracteres!")
	private String description;
	
	@NotNull(message ="Error: Data de vencimento é um campo obrigatório!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@NotNull(message= "Error: Valor é um campo obrigatório!")
	@DecimalMin(value = "0.01" , message = "Error: Valor não pode ser menor que 'R$0,01' !")
	@DecimalMax(value = "9999999.99", message = "Error: Valor não pode ser maior que 'R$9.999.999,99' !")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal value;
	
	@Enumerated(EnumType.STRING)
	private StatusTitle states;
	
		
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public StatusTitle getStates() {
		return states;
	}
	public void setStates(StatusTitle states) {
		this.states = states;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}