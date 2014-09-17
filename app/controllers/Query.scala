package controllers

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
    val query = request.body
    Ok(views.html.index(s"Your query: ${query}"))
  }

}
