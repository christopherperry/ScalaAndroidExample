import android.content.Context
import android.widget.{Button, EditText}
import com.example.scala.R

package object globals {
  case class TypedResource[T](id: Int)

  /**
   * You would manually place all typed resources here.
   */
  object TR {
    // EditText
    val usernameEditText = TypedResource[EditText](R.id.usernameEditText)
    val passwordEditText = TypedResource[EditText](R.id.passwordEditText)

    // Button
    val loginButton = TypedResource[Button](R.id.loginButton)
  }

  object Toast {
    def showShort(text: String)(implicit context: Context) = {
      android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT)
    }
    def showLong(text: String)(implicit context: Context) = {
      android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_LONG)
    }
  }
}