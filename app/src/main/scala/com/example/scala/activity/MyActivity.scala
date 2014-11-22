package com.example.scala.activity

import activity.TypedActivity
import android.app.Activity
import android.os.Bundle
import android.view.{Menu, MenuItem}
import android.widget.{TextView, Button, EditText}
import com.example.scala.R
import globals._

object MyActivity  {
  def apply(): MyActivity = {
    new MyActivity("Hello Scala")
  }
}

class MyActivity(message: String) extends Activity with TypedActivity {
  def this() = this("Hello Scala")

  // NOTE: Since these are lazy, they aren't evaluated until they are used the 1st time
  lazy val helloMessageView: TextView = findView(R.id.helloMessage)
  lazy val userNameEditText: EditText = findView(R.id.usernameEditText)
  lazy val passwordEditText: EditText = findView(R.id.passwordEditText)
  lazy val loginButton: Button = findView(R.id.loginButton)

  override def create(bundle: Bundle) {
    setContentView(R.layout.activity_my)

    helloMessageView.setText(message)

    userNameEditText.onTextChanged(text =>
      loginButton.setEnabled(!text.isEmpty)
    )

    loginButton.onClick(view => {
      val text: String = userNameEditText.getText.toString
      Toast.showShort(s"Hello $text!")
    })

    val pix: Int = 22.dp
    Toast.showShort(s"22 dp = $pix px on this device")
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
