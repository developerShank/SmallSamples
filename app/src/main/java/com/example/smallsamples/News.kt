package com.example.smallsamples

/**
 * (C) Koninklijke Philips N.V., 2022.
 * All rights reserved.
 */
data class News(val status: String, val totalResult: Int, val articles: List<Articles>)