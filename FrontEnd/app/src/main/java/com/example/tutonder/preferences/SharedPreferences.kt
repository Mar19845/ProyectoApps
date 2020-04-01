package com.example.tutonder.preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(val context: Context) {
    private val LOG_IN = "0"
    val sharedPref: SharedPreferences = context.getSharedPreferences(LOG_IN, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, value: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(KEY_NAME, value)
        editor.commit()
    }

    fun getValueString(KEY_NAME: String): String? {
        return sharedPref.getString(KEY_NAME, null)
    }

}