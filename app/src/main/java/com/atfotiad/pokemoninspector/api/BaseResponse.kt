package com.atfotiad.pokemoninspector.api

import com.atfotiad.pokemoninspector.model.Result

data class BaseResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)