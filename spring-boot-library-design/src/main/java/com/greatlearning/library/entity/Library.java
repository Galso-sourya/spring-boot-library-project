package com.greatlearning.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Library {
@Id
private long id;
private String name;
private String commaSeparatedBooknames;
}
