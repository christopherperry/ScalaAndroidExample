import _root_.globals.TypedResource
import android.app.Activity
import android.os.Bundle
import android.view.View
import view.{RichViews, TypedViewHolder}

package object activity {

  trait TypedActivity extends Activity with TypedActivityHolder with RichViews {
    override def activity = this

    override def onCreate(savedInstanceState: Bundle): Unit = {
      super.onCreate(savedInstanceState)
      create(savedInstanceState)
    }

    def create(bundle: Bundle)

    def findView[T >: View](id: Int): T = activity.findViewById(id)
  }

  trait TypedActivityHolder {
    def activity: Activity

    def findView[T](tr: TypedResource[T]) = activity.findViewById(tr.id).asInstanceOf[T]
  }

  object TypedResource {
    implicit def view2typed(v: View) = new TypedViewHolder {
      def view = v
    }

    implicit def activity2typed(act: Activity) = new TypedActivityHolder {
      def activity = act
    }
  }
}