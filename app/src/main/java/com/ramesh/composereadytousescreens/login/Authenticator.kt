package com.ramesh.composereadytousescreens.login

object Authenticator {

    fun authenticate(userName: String, password: String): Boolean {
        val validUserName = "admin"
        val validPassword = "admin1234"
        return validUserName == userName && validPassword == password
    }
}