package ru.markkuzi.mycocktails.presentation

interface Mapper<R: Any, S: Any> {

    fun map(source: S) : R

}