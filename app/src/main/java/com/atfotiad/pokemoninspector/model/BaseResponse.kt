package com.atfotiad.pokemoninspector.model

data class BaseResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)