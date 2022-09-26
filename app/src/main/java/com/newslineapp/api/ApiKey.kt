package com.newslineapp.api

import java.io.File

class ApiKey {
    companion object{
        private const val apiKeyFile = "ApiKey.txt"
        val apiKey = File(apiKeyFile).readText()
    }
}