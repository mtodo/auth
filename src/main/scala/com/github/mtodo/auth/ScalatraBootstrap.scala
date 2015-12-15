import org.scalatra.LifeCycle

import javax.servlet.ServletContext

import com.github.mtodo.auth.HelloExample

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) = {
    context mount (new HelloExample, "/*")
  }
}
