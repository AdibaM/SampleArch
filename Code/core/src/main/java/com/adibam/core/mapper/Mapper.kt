package com.adibam.core.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}