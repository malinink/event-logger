package com.github.malinink.eventlogger.domain.fetchers

import com.github.malinink.eventlogger.infrastructure.posts.Post

interface PostsFetcherInterface {
    suspend fun get(id: Int): Post
}
