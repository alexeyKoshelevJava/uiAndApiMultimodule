package ru.koshelev.api.payloads;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class UserPayloads{
	@JsonProperty ("name")
	private String name;
	@JsonProperty ("job")
	private String job;




}