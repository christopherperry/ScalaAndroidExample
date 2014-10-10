package com.example.scala.activity

import activity.TypedActivity
import android.app.Activity
import android.os.Bundle
import android.view.{Menu, MenuItem}
import com.example.scala.R
import globals.{Toast, TR}

class MyActivity extends Activity with TypedActivity {

  // NOTE: Since these are lazy, they aren't evaluated until they are used the 1st time
  lazy val userNameEditText = findView(TR.usernameEditText)
  lazy val passwordEditText = findView(TR.passwordEditText)
  lazy val loginButton = findView(TR.loginButton)

  override def create(bundle: Bundle) {
    setContentView(R.layout.activity_my)

    userNameEditText.onTextChanged(text => {
      loginButton.setEnabled(!text.isEmpty)
    })

    loginButton.onClick(view => {
      val text: String = userNameEditText.getText.toString
      Toast.showShort(s"Hello $text!")
    })
  }

  override def onCreateOptionsMenu(menu: Menu): Boolean = {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater.inflate(R.menu.my, menu)
    true
  }

  override def onOptionsItemSelected(item: MenuItem): Boolean = {
    if (item.getItemId == R.id.action_settings) true
    else super.onOptionsItemSelected(item)
  }
}
