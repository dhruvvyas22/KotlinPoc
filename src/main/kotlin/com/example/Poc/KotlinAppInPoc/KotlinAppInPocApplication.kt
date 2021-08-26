package com.example.Poc.KotlinAppInPoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KotlinAppInPocApplication

fun main(args: Array<String>) {
	runApplication<KotlinAppInPocApplication>(*args)
}

@RestController
class MessageResource {
	@RequestMapping("/show")
	@GetMapping
	fun index(): List<Message> = listOf(
		Message("1", "Hello!"),
		Message("2", "Bonjour!"),
		Message("3", "Privet!"),
	)

	@RequestMapping("/getError")
	@GetMapping
	fun getException()
	{
		throw CustomException("Custom Exception")
	}
}

data class Message(val id: String?, val text: String)

class CustomException(message: String) : Exception(message)
