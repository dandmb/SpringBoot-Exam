package com.example.howtodoinjava.springhystrixschoolservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
	public String getActorData(String name) {

		String response = restTemplate
				.exchange("http://localhost:8080/my-movie/getActors/{name}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, name).getBody();

		//System.out.println("Response Received as " + response + " -  " + new Date());

		return "The Actor name : " + response;
	}



	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	public String getFilmData() {

		String response = restTemplate
				.exchange("http://localhost:8080/my-movie/getFilms"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}).getBody();

		//System.out.println("Response Received as " + response + " -  " + new Date());

		return "Films : " + response;
	}



	@HystrixCommand(fallbackMethod = "callMovieServiceAndGetData_Fallback")
	public String getFilm(String name) {

		String response = restTemplate
				.exchange("http://localhost:8080/my-movie/getFilms/{name}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, name).getBody();

		//System.out.println("Response Received as " + response + " -  " + new Date());

		return "The Film name : " + response;
	}





	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	public String getAllActorData() {

		String response = restTemplate
				.exchange("http://localhost:8080/my-movie/getActors"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}).getBody();

		return "Actors : " + response;
	}








	
	@SuppressWarnings("unused")
	private String callStudentServiceAndGetData_Fallback() {
		//System.out.println("Student Service is down!!! fallback route enabled...");
		return "Service Unavailabale";
	}
	@SuppressWarnings("unused")
	private String callMovieServiceAndGetData_Fallback(String name) {
		//System.out.println("Student Service is down!!! fallback route enabled...");
		return "Service Unavailabale";
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
