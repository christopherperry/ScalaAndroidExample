import android.text.{Editable, TextWatcher}
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText

package object view {

  trait TypedView extends View {
    def view = this

    def findView[T](id: Int): T = view.findViewById(id).asInstanceOf[T]
  }

  trait RichViews extends RichView with RichEditText

  trait RichView {

    implicit class ViewPimper(view: View) {

      def onClick(f: View => Unit) = {
        view.setOnClickListener(new OnClickListener {
          override def onClick(v: View) = f(v)
        })
      }
    }

  }

  trait RichEditText extends RichView {

    implicit class EditTextPimper(view: EditText) {

      def onTextChanged(f: String => Unit): Unit = {
        view.addTextChangedListener(new TextWatcher {
          override def beforeTextChanged(p1:CharSequence, p2: Int, p3: Int, p4: Int): Unit = {}

          override def onTextChanged(p1: CharSequence, p2: Int, p3: Int, p4: Int): Unit = { }

          override def afterTextChanged(p1: Editable): Unit = {
            f(p1.toString)
          }
        })
      }
    }
  }

}