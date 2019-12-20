package com.github.malinink.eventlogger.domain.services

import com.github.malinink.eventlogger.domain.posts.PostInterface

interface PostsServiceInterface {
    suspend fun get(id: Int): PostInterface
}
