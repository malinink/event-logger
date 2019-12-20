package com.github.malinink.eventlogger.application.v1.actions

import com.github.malinink.eventlogger.application.v1.models.Post
import com.github.malinink.eventlogger.domain.services.PostsServiceInterface
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1Post(postsService: PostsServiceInterface) {

    val post = postsService.get(1)
    respond(Post("#${post.id}", post.title))
}
