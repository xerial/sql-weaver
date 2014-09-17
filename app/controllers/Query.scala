package controllers

import anorm.SqlParser
import com.facebook.presto.sql.parser.{ParsingException, SqlParser}
import play.api._
import play.api.mvc._
import play.api.mvc.BodyParsers.parse

/**
 *
 */
object Query extends Controller {

  def index = Action {
    Ok(views.html.index("hello query"))
  }

  def validate = Action(parse.text) { request =>
    val sql = request.body
    val sqlParser = new SqlParser
    try {
      val statement = sqlParser.createStatement(sql)
      Ok(views.html.index(s"Your query: ${sql}"))
    }
    catch {
      case e : ParsingException =>
        BadRequest(views.html.index(s"syntax error: ${e.getErrorMessage}"))
    }
  }

}
