/*
 * Scala.js (https://www.scala-js.org/)
 *
 * Copyright EPFL.
 *
 * Licensed under Apache License 2.0
 * (https://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package java.util

import scala.scalajs.js.annotation.JavaDefaultMethod

import java.util.function.Consumer

trait Iterator[E] {
  def hasNext(): Boolean
  def next(): E

  @JavaDefaultMethod
  def remove(): Unit =
    throw new UnsupportedOperationException("remove")

  @JavaDefaultMethod
  def forEachRemaining(action: Consumer[_ >: E]): Unit = {
    while (hasNext())
      action.accept(next())
  }
}
