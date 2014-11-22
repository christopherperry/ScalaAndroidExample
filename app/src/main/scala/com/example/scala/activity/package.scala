import android.app.Activity
import android.os.Bundle
import view.RichViews

package object activity {

  trait TypedActivity extends Activity with RichViews {
    implicit def activity = this

    def findView[T](id: Int) : T = activity.findViewById(id).asInstanceOf[T]

    override def onCreate(savedInstanceState: Bundle): Unit = {
      super.onCreate(savedInstanceState)
      create(savedInstanceState)
    }

    def create(bundle: Bundle) = {}
  }
}