import android.content.Context
import android.content.res.Resources

package object globals {

  object Toast {
    def showShort(text: String)(implicit context: Context): Unit = {
      android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT).show()
    }
    def showLong(text: String)(implicit context: Context): Unit = {
      android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_LONG).show()
    }
  }

  implicit class dp(dpValue: Int) {
    def dp: Int = (dpValue * Resources.getSystem.getDisplayMetrics.density + 0.5).toInt
  }
}