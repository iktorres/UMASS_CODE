package support

import scala.io.Source
import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox

object TreeTraversals {

  def raw(tree: Tree) = showRaw(tree)

  def asTree(file: String): Tree = {
    // Get a toolbox to create Scala trees.
    val toolbox = runtimeMirror(getClass.getClassLoader).mkToolBox()
    // Remove package declarations - the toolbox parser does not like them.
    val regexp = "package".r
    val source = regexp.replaceAllIn(Source.fromFile(file).getLines.mkString("\n"), "")
    // Parse into a tree.
    toolbox.parse(source)
  }

  def getMethods(file: String): List[DefDef] =
    getMethods(asTree(file))

  def getMethods(tree: Tree): List[DefDef] = {
    val traverser = new MethodTraverser
    traverser.traverse(tree)
    traverser.defdefs
  }

  def getMethod(tree: Tree, name: String): Option[DefDef] = {
    getMethods(tree).find {
      case DefDef(_, TermName(n), _, _, _, _) if n == name => true
      case _ => false
    }
  }

  def getMethod(file: String, name: String): Option[DefDef] =
    getMethod(asTree(file), name)

  def getVals(file: String): List[ValDef] =
    getVals(asTree(file))

  def getVals(tree: Tree): List[ValDef] = {
    val traverser = new ValTraverser
    traverser.traverse(tree)
    traverser.valdefs
  }

  def getVal(tree: Tree, name: String): Option[ValDef] = {
    getVals(tree).find {
      case ValDef(_, TermName(n), _, _) if n == name => true
      case _ => false
    }
  }

  def getVars(tree: Tree): List[ValDef] = {
    for {
      valdef <- getVals(tree)
      vardef = valdef if valdef.mods.hasFlag(Flag.MUTABLE)
    } yield vardef
  }

  def getVars(file: String): List[ValDef] =
    getVars(asTree(file))

  def getTerms(file: String): List[TermName] =
    getTerms(asTree(file))

  def getTerms(tree: Tree): List[TermName] = {
    val traverser = new MethodCallTraverser
    traverser.traverse(tree)
    traverser.calls
  }

  def getIfs(tree: Tree): List[If] = {
    val traverser = new IfExprTraverser
    traverser.traverse(tree)
    traverser.ifs
  }

  def getIfs(file: String): List[If] =
  getIfs(asTree(file))

  def hasVarDef(tree: Tree): Boolean =
    getVars(tree).size != 0

  def hasValDef(tree: Tree): Boolean = {
    getVals(tree).size != 0
  }

  def hasWhileLoop(tree: Tree): Boolean = {
    val traverser = new MethodCallTraverser
    traverser.traverse(tree)
    traverser.calls.exists {
      case TermName(s) if s.matches(".*while.*|.*doWhile.*") => true
      case _ => false
    }
  }

  def hasForEach(tree: Tree): Boolean = {
    val traverser = new MethodCallTraverser
    traverser.traverse(tree)
    traverser.calls.exists {
      case TermName(s) if s.matches("foreach") => true
      case _ => false
    }
  }

  def hasForComp(tree: Tree): Boolean = {
    val traverser = new MethodCallTraverser
    traverser.traverse(tree)
    traverser.calls.exists {
      case TermName(s) if s.matches("map") => true
      case _ => false
    }
  }

  def hasLoops(tree: Tree): Boolean =
    hasWhileLoop(tree) &&
    hasForEach(tree) &&
    hasForComp(tree)

  def hasIfs(tree: Tree): Boolean =
    getIfs(tree).nonEmpty

  def doesNotHaveIfs(tree: Tree): Boolean =
    getIfs(tree).isEmpty

  class MethodTraverser extends Traverser {
    var defdefs = List[DefDef]()
    override def traverse(tree: Tree): Unit = tree match {
      case defdef @ DefDef(_, _, _, _, _, rhs) =>
        defdefs = defdef :: defdefs
        super.traverse(tree)
      case _ => super.traverse(tree)
    }
  }

  class ValTraverser extends Traverser {
    var valdefs = List[ValDef]()
    override def traverse(tree: Tree): Unit = tree match {
      case valdef @ ValDef(mods, _, _, _) =>
        if (!mods.hasFlag(Flag.PARAM))
          valdefs = valdef :: valdefs
        super.traverse(tree)
      case _ => super.traverse(tree)
    }
  }

  class MethodCallTraverser extends Traverser {
    var calls = List[TermName]()
    override def traverse(tree: Tree): Unit = tree match {
      case Select(obj, name @ TermName(_)) =>
        calls = name :: calls
        super.traverse(tree)
      case LabelDef(name, _, _) =>
        calls = name :: calls
        super.traverse(tree)
      case _ => super.traverse(tree)
    }
  }

  class IfExprTraverser extends Traverser {
    var ifs = List[If]()
    override def traverse(tree: Tree): Unit = tree match {
      case ife @ If(c, ifb, elb) =>
        ifs = ife :: ifs
        super.traverse(tree)
      case _ => super.traverse(tree)
    }
  }

}
