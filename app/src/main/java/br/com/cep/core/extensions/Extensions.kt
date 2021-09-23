package br.com.cep.core.extensions

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Context.toast(message: String, duration: Int) {
    Toast.makeText(this, message, duration).show()
}
fun Context.createDialog(block: MaterialAlertDialogBuilder.() -> Unit = {}): AlertDialog {
    val builder = MaterialAlertDialogBuilder(this)
    builder.setPositiveButton(android.R.string.ok, null)
    block(builder)
    return builder.create()
}


