package com.treeengineering.core.action

interface Action<out T> {
    val data: T
}
