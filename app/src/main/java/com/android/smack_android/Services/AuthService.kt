package com.android.smack_android.Services

import android.content.Context
import android.util.Log
import com.android.smack_android.Utilities.URL_REGISTER
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject

object AuthService {

    fun registerUser(context: Context, email: String, password: String, complete: (Boolean) -> Unit) {
        val jsonBody = JSONObject()
        jsonBody.put("email", email)
        jsonBody.put("password", password)

        val requestBody = jsonBody.toString()

        val registerRequest = object : StringRequest(Method.POST, URL_REGISTER, Response.Listener {
            complete(true)
        }, Response.ErrorListener { error ->
            Log.d("ERROR", "Could not register user: $error")
            complete(false)
        }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

}