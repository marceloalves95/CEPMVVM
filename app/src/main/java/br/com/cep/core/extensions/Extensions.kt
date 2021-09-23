package br.com.cep.core.extensions

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String, duration: Int) {
    Toast.makeText(this, message, duration).show()
}


