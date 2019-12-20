package com.github.malinink.eventlogger.infrastructure

import com.github.malinink.eventlogger.domain.fetchers.PostsFetcherInterface
import com.github.malinink.eventlogger.domain.services.PostsService
import com.github.malinink.eventlogger.domain.services.PostsServiceInterface
import com.github.malinink.eventlogger.infrastructure.fetchers.PostsFetcher
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

val template = module {
    singleBy<PostsServiceInterface, PostsService>()
    singleBy<PostsFetcherInterface, PostsFetcher>()
}
