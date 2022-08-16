package com.example.smallsamples

/**
 * (C) Koninklijke Philips N.V., 2022.
 * All rights reserved.
 */
data class Articles(val articles: Articles,
                    val author: String,
                    val title: String,
                    val description: String,
                    val url: String,
                    val urlToImage: String,
                    val publishedAt: String,
                    val content: String)