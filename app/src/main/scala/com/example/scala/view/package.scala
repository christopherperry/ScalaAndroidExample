import android.text.{Editable, TextWatcher}
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import globals.TypedResource

package object view {

  trait TypedViewHolder {
    def view: View

    def findView[T](tr: TypedResource[T]) = view.findViewById(tr.id).asInstanceOf[T]
  }

  trait TypedView extends View with TypedViewHolder {
    def view = this
  }

  trait RichViews extends RichView with RichEditText

  trait RichView {

    implicit class ViewPimper(view: View) {

      def onClick(f: View => Unit) = {
        view.setOnClickListener(new OnClickListener {
          override def onClick(v: View): Unit = {
            f(v)
          }
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