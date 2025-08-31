package com.example.work.data.api

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import com.example.work.data.model.User

class MockInterceptor : Interceptor {
    private val json = Json { 
        ignoreUnknownKeys = true
        prettyPrint = true
    }
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.toString()
        
        val responseString = when {
            url.endsWith("users") -> {
                json.encodeToString(getMockUsers())
            }
            url.contains("users/") -> {
                val id = url.substringAfterLast("/").toIntOrNull() ?: 1
                json.encodeToString(getMockUser(id))
            }
            else -> "{}"
        }
        
        return Response.Builder()
            .code(200)
            .message("OK")
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .body(responseString.toResponseBody("application/json".toMediaType()))
            .build()
    }
    
    private fun getMockUsers(): List<User> = listOf(
        User(
            id = 1,
            name = "John Doe",
            email = "john@example.com",
            username = "johndoe",
            phone = "123-456-7890",
            website = "johndoe.com"
        ),
        User(
            id = 2,
            name = "Jane Smith",
            email = "jane@example.com",
            username = "janesmith",
            phone = "098-765-4321",
            website = "janesmith.com"
        ),
        User(
            id = 3,
            name = "Bob Johnson",
            email = "bob@example.com",
            username = "bobjohnson",
            phone = "555-123-4567",
            website = "bobjohnson.com"
        )
    )
    
    private fun getMockUser(id: Int): User = 
        getMockUsers().find { it.id == id } ?: getMockUsers().first()
}