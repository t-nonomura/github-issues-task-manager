package com.treeengineering.model.response

data class Repo(
    val id: Int,
    val name: String,
    val private: Boolean,
    val description: String,
    val has_issues: Boolean,
    val has_projects: Boolean
)
