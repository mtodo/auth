import org.scalatra.LifeCycle

import javax.servlet.ServletContext

import com.github.mtodo.auth.Signup
import com.github.mtodo.auth.Signin

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) = {
    context mount (new Signup, "/auth/signup/*")
    context mount (new Signin, "/auth/signin/*")
  }
}
