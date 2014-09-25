package controllers


import org.antlr.runtime.{CommonTokenStream, ANTLRStringStream}
import org.apache.hadoop.hive.ql.parse.{ParseException, ParseDriver}
import play.api._
import play.api.mvc._
import play.api.mvc.BodyParsers.parse


/**
 *
 */
object HiveQuery extends Controller {

  def index = Action {
    Ok(views.html.index("hello Hive query"))
  }

  def validate = Action(parse.text) { request =>
    val sql = request.body

    val driver = new ParseDriver()
    try {
      val ast = driver.parse(sql)
      Logger.debug(ast.dump())
      ast.dump()
      Ok(views.html.index(s"Your query: ${sql}"))
    }
    catch {
      case e:ParseException =>
        // Extract error parts
        Ok(views.html.index(s"parse exception: ${e.getMessage}"))
    }


  }

}
