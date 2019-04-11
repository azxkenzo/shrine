package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kenzo.shrine.R
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*


/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)

        view.next_button.setOnClickListener {
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = getString(R.string.shr_error_password)
            } else {
                password_text_input.error = null
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }

        view.password_edit_text.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(password_edit_text.text!!)) {
                // Clear the error.
                password_text_input.error = null
            }
            false
        }




        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        println("LoginFragment onDestroy")
    }

    private fun isPasswordValid(text: Editable?): Boolean = text != null && text.length >= 8

}
