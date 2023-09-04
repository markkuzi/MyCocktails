package ru.markkuzi.mycocktails.presentation

interface Matches<T> {

    fun matches(data: T): Boolean
}