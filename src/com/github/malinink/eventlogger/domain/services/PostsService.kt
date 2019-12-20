package com.github.malinink.eventlogger.domain.services

import com.github.malinink.eventlogger.domain.fetchers.PostsFetcherInterface
import com.github.malinink.eventlogger.domain.posts.Post
import com.github.malinink.eventlogger.domain.posts.PostInterface

class PostsService(postFetcher: PostsFetcherInterface) :
    PostsServiceInterface {
    private val postFetcher: PostsFetcherInterface = postFetcher

    override suspend fun get(id: Int): PostInterface {
        val post = postFetcher.get(id)

        return Post(post.id, post.title)
    }
}
