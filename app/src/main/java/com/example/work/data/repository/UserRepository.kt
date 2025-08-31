package com.example.work.data.repository

import com.example.work.data.api.ApiService
import com.example.work.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getUsers(): List<User> {
        return try {
            apiService.getUsers()
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    suspend fun getUser(id: Int): User? {
        return try {
            apiService.getUser(id)
        } catch (e: Exception) {
            null
        }
    }
}