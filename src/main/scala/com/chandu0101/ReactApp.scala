package com.chandu0101

import chandu0101.scalajs.react.components.materialui.{MuiDialog, MuiInput}
import japgolly.scalajs.react._
import org.scalajs.dom

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport


object ReactApp extends JSApp {


  val component = ReactComponentB[Unit]("Error")
    .render(P => {
    val dialogActions = List(
      MuiDialog.Action(text = "CANCEL"),
      MuiDialog.Action(text = "SUBMIT")
    )
    MuiDialog(title = "Document name", actions = dialogActions)(
      MuiInput(placeholder = "First name", description = "your first name as DOB", name = "firstname")
    )
  }).buildU

  def apply() = component()

  @JSExport
  override def main(): Unit = {

    React.render(component(), dom.document.body)
  }
}
